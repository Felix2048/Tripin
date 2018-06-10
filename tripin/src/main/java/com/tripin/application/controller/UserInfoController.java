package com.tripin.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tripin.application.annotation.Logged;
import com.tripin.application.domain.Result;
import com.tripin.application.domain.Token;
import com.tripin.application.entity.MyUserInfo;
import com.tripin.application.entity.UserInfo;
import com.tripin.application.exception.TripinException;
import com.tripin.application.mapper.UserInfoMapper;
import com.tripin.application.service.UserInfoService;
import com.tripin.application.utils.JsonUtil;
import com.tripin.application.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: UserInfoController
 * @Description: 接收请求并处理 UserInfo
 * @Author: Felix
 * @Date: 6/1/2018 13:05
 * @Version: 1.0
 **/

@RestController
@RequestMapping("/user")
public class UserInfoController {


    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * @return 封装了token的result
     * @throws TripinException
     * @Description: 使用userName、phone、email和password进行登陆
     */
    @Logged({"account", "password"})
    @PostMapping("/login")
    public Result userLogin(@RequestParam("account") String account, @RequestParam("password") String password) throws TripinException {
        // 将获取到的account和password给Service进行验证，将token返回给用户
        Token token = userInfoService.userLogin(account, password);
        return ResultUtil.success(token);
    }

    /**
     * @return null
     * @throws TripinException
     * @Description: 用户提供Token进行注销
     */
    @Logged({"tokenString", "userID"})
    @PostMapping("/logout")
    public Result userLogin(@RequestParam("tokenString") String tokenString, @RequestParam("userID") int userID) {
        Token token = new Token(tokenString, userID);
        userInfoService.userLogout(token);
        return ResultUtil.success();
    }

    /**
     * @return null
     * @throws TripinException
     * @Description: 用户提供Token获取其用户信息
     */
    @Logged({"tokenString", "userID"})
    @GetMapping("/info")
    public Result getMyUserInfo(@RequestParam("tokenString") String tokenString, @RequestParam("userID") int userID) {
        Token token = new Token(tokenString, userID);
        MyUserInfo myUserInfo = userInfoService.getMyUserInfo(token);
        return ResultUtil.success(myUserInfo);
    }

    /**
     * @return null
     * @throws TripinException
     * @Description: 用户提供Token获取修改其密码
     */
    @Logged({"tokenString", "userID", "newPassword"})
    @PostMapping("/set/password")
    public Result updateUserPassword(@RequestParam("tokenString") String tokenString, @RequestParam("userID") int userID,
                                     @RequestParam("newPassword") String newPassword) {
        Token token = new Token(tokenString, userID);
        userInfoService.updateUserPassword(token, newPassword);
        return ResultUtil.success();
    }

//    ---- 下面是测试函数 ----

    @GetMapping("all")
    public Result testGetAllUser() {
        return userInfoService.getAllUsers();
    }
}

