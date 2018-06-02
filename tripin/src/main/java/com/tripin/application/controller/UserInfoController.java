package com.tripin.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tripin.application.domain.Result;
import com.tripin.application.domain.Token;
import com.tripin.application.exception.TripinException;
import com.tripin.application.service.UserInfoService;
import com.tripin.application.utils.JsonUtil;
import com.tripin.application.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserInfoController(UserInfoService userInfoService, JsonUtil jsonUtil) {
        this.userInfoService = userInfoService;
    }

    /**
     * @return 封装了token的result
     * @throws TripinException, JsonProcessingException
     * @Description: 使用userName、phone、email和password进行登陆
     */
    @PostMapping("/login")
    public Result userLogin(@RequestParam("account") String account, @RequestParam("password") String password) throws TripinException {
        // 将获取到的account和password给Service进行验证，将token返回给用户
        Token token = userInfoService.userLogin(account, password);
        return ResultUtil.success(token);
    }
}
