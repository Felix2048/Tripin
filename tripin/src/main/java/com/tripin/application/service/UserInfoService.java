package com.tripin.application.service;

import com.tripin.application.annotation.Authorized;
import com.tripin.application.annotation.Logged;
import com.tripin.application.domain.Token;
import com.tripin.application.entity.MyUserInfo;
import com.tripin.application.entity.UserInfo;
import com.tripin.application.enums.ErrorCode;
import com.tripin.application.enums.UserStatus;
import com.tripin.application.exception.TripinException;
import com.tripin.application.mapper.UserInfoMapper;
import com.tripin.application.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @Title: UserService
 * @Description: 业务处理 UserInfo
 * @Author: Felix
 * @Date: 6/1/2018 0:39
 * @Version: 1.0
 **/

@Service
public class UserInfoService {

    private static final Logger logger = LoggerFactory.getLogger("com.tripin.application.service.UserInfoService");

    private final UserInfoMapper userInfoMapper;

    private HashMap<String, Token> tokenHashMap;

    public HashMap<String, Token> getTokenHashMap() {
        // UserInfoService是单例的，故可以通过返回tokenHashMap给AuthorizationAspect进行权限验证，引入Redis后废弃
        return tokenHashMap;
    }

    private HashMap<Integer, Token> onlineUserHashMap;

    @Autowired
    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
        tokenHashMap = new HashMap<>();
        onlineUserHashMap = new HashMap<>();
    }

    /**
     * @Description: 使用userName、phone、email和password进行登陆
     * @param account, password
     * @throws TripinException
     * @return TokenUtil
     */
    @Logged({"account", "password"})
    @Transactional
    public Token userLogin(String account, String password) {
        // 与数据库值进行匹配
        UserInfo userInfo = null;
        Token token = null;
        userInfo = userInfoMapper.getOneByUserName(account);
        if (null == userInfo) {
            // 用户以非userName方式登录
            userInfo = userInfoMapper.getOneByPhone(account);
        }
        if (null == userInfo) {
            // 用户以非userName或phone方式登录
            userInfo = userInfoMapper.getOneByEmail(account);
        }

        if (null == userInfo) {
            // 不存在该用户
            throw new TripinException(ErrorCode.LOGIN_ERROR);
        }
        else {
            if(password.equals(userInfo.getPassword())) {
                token =  TokenUtil.create(userInfo);
            }
            else{
                throw new TripinException(ErrorCode.LOGIN_ERROR);
            }
        }
        if(userInfo.getUserStatus() == UserStatus.BANNED) {
            // 禁止登录
            throw new TripinException(ErrorCode.LOGOIN_BANNED);
        }

        // 建立token与用户信息对应关系，暂时使用HashMap存储，拓展可在建立缓存层时使用Redis
        if(onlineUserHashMap.containsKey(token.getUserID())) {
            try {
                // 调用userLogout方法处理重复登陆,忽略其抛出的异常
                logger.info("Double login found! Calls userLogout();");
                this.userLogout(token);
            } catch (TripinException ignored) {
            }
        }
        tokenHashMap.put(token.getToken(), token);
        onlineUserHashMap.put(token.getUserID(), token);

        return token;
    }

    /**
     * @Description: 注销拥有当前token中的userID用户的登陆
     * @param token
     * @throws TripinException
     */
    @Logged({"token"})
    @Transactional
    public void userLogout(Token token) throws TripinException {
        if(onlineUserHashMap.containsKey(token.getUserID())) {
            Token onlineUser = onlineUserHashMap.get(token.getUserID());
            // 删除现有token
            onlineUserHashMap.remove(onlineUser.getUserID());
            tokenHashMap.remove(onlineUser.getToken());
        }
        else {
            throw new TripinException(ErrorCode.LOGOUT_ERROR);
        }
    }

    /**
     * @Description: 获取用户的信息（除密码、帐号状态外）
     * @param token
     */
    @Authorized
    @Logged({"token"})
    @Transactional
    public MyUserInfo getMyUserInfo(Token token) throws TripinException {

        MyUserInfo myUserInfo = userInfoMapper.getOneFromView(token.getUserID());
        if (null == myUserInfo) {
            throw new TripinException(ErrorCode.QUERY_ERROR);
        }
        return myUserInfo;
    }

    /**
     * @Description: 修改password
     * @param token, newPassword
     */
    @Authorized
    @Logged({"token", "newPassword"})
    @Transactional
    public void updateUserPassword(Token token, String newPassword) throws TripinException {

        int affectedRows = userInfoMapper.updatePassword(token.getUserID(), newPassword);
        if (affectedRows != 1) {
            throw new TripinException(ErrorCode.UPDATE_ERROR);
        }
    }

}
