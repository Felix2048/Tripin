package com.tripin.application.service;

import com.tripin.application.domain.Token;
import com.tripin.application.entity.UserInfo;
import com.tripin.application.enums.ErrorCode;
import com.tripin.application.exception.TripinException;
import com.tripin.application.mapper.UserInfoMapper;
import com.tripin.application.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Title: UserService
 * @Description: 业务处理 UserInfo
 * @Author: Felix
 * @Date: 6/1/2018 0:39
 * @Version: 1.0
 **/

@Service
public class UserInfoService {

    private static final Logger logger = LoggerFactory.getLogger("com.service.UserService");

    private final UserInfoMapper userInfoMapper;

    private HashMap<String, Token> tokenHashMap;

    private HashMap<Integer, Token> onlineUserHashMap;

    @Autowired
    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
        tokenHashMap = new HashMap<>();
        onlineUserHashMap = new HashMap<>();
    }

    /**
     * @Description: 使用userName、phone、email和password进行登陆
     * @throws TripinException
     * @return TokenUtil
     */
    public Token userLogin(String account, String password) {
        logger.info("userLogin() param:" + account.getClass().getName() + " = " + account
            + ", " + password.getClass().getName() + " = " + password);
        // 与数据库值进行匹配
        UserInfo userInfoByUserName = userInfoMapper.getOneByUserName(account);
        UserInfo userInfoByPhone = userInfoMapper.getOneByPhone(account);
        UserInfo userInfoByEmail = userInfoMapper.getOneByEmail(account);
        Token token = null;
        if (null != userInfoByUserName) {
            // 以userName登陆
            if(password.equals(userInfoByUserName.getPassword())) {
                token = TokenUtil.create(userInfoByUserName);
            }
            else{
                throw new TripinException(ErrorCode.LOGIN_ERROR);
            }
        }
        else if (null != userInfoByPhone) {
            // 以phone登陆
            if(password.equals(userInfoByPhone.getPassword())) {
                token =  TokenUtil.create(userInfoByPhone);
            }
            else{
                throw new TripinException(ErrorCode.LOGIN_ERROR);
            }
        }
        else if (null != userInfoByEmail) {
            // 以email登陆
            if(password.equals(userInfoByEmail.getPassword())) {
                token =  TokenUtil.create(userInfoByEmail);
            }
            else{
                throw new TripinException(ErrorCode.LOGIN_ERROR);
            }
        }
        else{
            throw new TripinException(ErrorCode.LOGIN_ERROR);
        }

        // 建立token与用户信息对应关系，暂时使用HashMap存储，拓展可在建立缓存层时使用Redis
        if(onlineUserHashMap.containsKey(token.getUserID())) {
            // 重复登陆
            Token onlineUser = onlineUserHashMap.get(token.getUserID());
            // 删除现有token
            onlineUserHashMap.remove(onlineUser.getUserID());
            tokenHashMap.remove(onlineUser.getToken());
        }
        tokenHashMap.put(token.getToken(), token);
        onlineUserHashMap.put(token.getUserID(), token);

        return token;
    }

    /**
     * @Description: 获取User表中全部数据
     * @return userInfoArray
     */
    public List<UserInfo> getAll(){
        logger.info("getAll()");
        return userInfoMapper.getAll();
    }

    /**
     * @Description: 按userID来获取表中的一条数据
     * @param userID
     * @return userInfo
     */
    public UserInfo getOne(Integer userID){
        logger.info("getOne() param:" + userID.getClass().getName() + " = " + userID.toString());
        return userInfoMapper.getOne(userID);
    }

    /**
     * @Description: 按userName来获取表中的一条数据
     * @param userName
     * @return userInfo
     */
    public UserInfo getOneByUserName(String userName) {
        logger.info("getOneByUserName() param:" + userName.getClass().getName() + " = " + userName);
        return userInfoMapper.getOneByUserName(userName);
    }

    /**
     * @Description: 按phone来获取表中的一条数据
     * @param phone
     * @return userInfo
     */
    public UserInfo getOneByPhone(String phone) {
        logger.info("getOneByUserName() param:" + phone.getClass().getName() + " = " + phone);
        return userInfoMapper.getOneByPhone(phone);
    }

    /**
     * @Description: 按email来获取表中的一条数据
     * @param email
     * @return userInfo
     */
    public UserInfo getOneByEmail(String email) {
        logger.info("getOneByUserName() param:" + email.getClass().getName() + " = " + email);
        return userInfoMapper.getOneByEmail(email);
    }

    /**
     * @Description: 向表中插入一条数据
     * @param userInfo
     */
    @Transactional
    public int insert(UserInfo userInfo) {
        logger.info("insert() param:" + userInfo.getClass().getName() + " = " + userInfo.toString());
        return userInfoMapper.insert(userInfo);
    }

    /**
     * @Description: 修改表中一条数据的password
     * @param userID, newPassword
     */
    @Transactional
    public int updatePassword(Integer userID, String newPassword) throws TripinException {
        logger.info("insert() param:" + userID.getClass().getName() + " = " + userID.toString() + ", " +
                newPassword.getClass().getName() + " = " + newPassword);
        int affectedRows = userInfoMapper.updatePassword(userID, newPassword);
        if (affectedRows != 1) {
            throw new TripinException(ErrorCode.UPDATE_ERROR);
        }
        return affectedRows;
    }

    /**
     * @Description: 删除表中的一条数据
     * @param userID
     */
    public int delete(Integer userID) throws TripinException {
        logger.info("insert() param:" + userID.getClass().getName() + " = " + userID.toString());
        int affectedRows = userInfoMapper.delete(userID);
        if (affectedRows != 1) {
            throw new TripinException(ErrorCode.DELETION_ERROR);
        }
        return affectedRows;
    }
}
