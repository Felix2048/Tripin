package com.tripin.application.utils;

import com.tripin.application.domain.Token;
import com.tripin.application.entity.UserInfo;

/**
 * @Title: TokenUtil
 * @Description: Token生成工具类
 * @Author: Felix
 * @Date: 6/1/2018 13:43
 * @Version: 1.0
 **/

public class TokenUtil {

    public static Token create(UserInfo userInfo) {
        String tokenString = MD5Util.encrypt(String.valueOf(System.currentTimeMillis()) + userInfo.hashCode());
        return new Token(tokenString, userInfo.getUserID());
    }
}
