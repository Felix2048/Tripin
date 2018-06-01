package com.tripin.application.service;

import com.tripin.application.entity.UserInfo;
import com.tripin.application.enums.ErrorCode;
import com.tripin.application.enums.UserStatus;
import com.tripin.application.exception.TripinException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {
    @Autowired
    private UserInfoService userService;

    @Test
    public void userLogin() {
    }

    @Test
    public void updatePassword() {
        System.out.println(userService.userLogin("felix", "miao123"));
        System.out.println(userService.userLogin("12345678901", "miao123"));
        System.out.println(userService.userLogin("felix@miao.com", "miao123"));
    }

//    @Test
//    public void getAll() {
//        List<UserInfo> userInfoList = userService.getAll();
//        for(UserInfo userInfo : userInfoList) {
//            System.out.println(userInfo.toString());
//        }
//        Assert.assertEquals(2, userInfoList.size());
//    }
//
//    @Test
//    public void getOne() {
//        UserInfo userInfo = userService.getOne(7);
//        System.out.println(userInfo);
//        Assert.assertEquals(7,userInfo.getUserID());
//        Assert.assertEquals("felix", userInfo.getUserName());
//    }
//
//    @Test
//    public void getOneByUserName() {
//        UserInfo userInfo = userService.getOneByUserName("felix");
//        System.out.println(userInfo);
//        Assert.assertEquals("felix", userInfo.getUserName());
//    }
//
//    @Test
//    public void getOneByPhone() {
//        UserInfo userInfo = userService.getOneByPhone("12345678901");
//        System.out.println(userInfo);
//        Assert.assertEquals("felix", userInfo.getUserName());
//        Assert.assertEquals("12345678901", userInfo.getPhone());
//    }
//
//    @Test
//    public void getOneByEmail() {
//        UserInfo userInfo = userService.getOneByEmail("felix@miao.com");
//        System.out.println(userInfo);
//        Assert.assertEquals("felix", userInfo.getUserName());
//        Assert.assertEquals("felix@miao.com", userInfo.getEmail());
//    }
//
//    @Test
//    public void insert() {
//        int affectedRows = userService.insert(new UserInfo("one_how",
//                    "wfvafaweg", "92345093901",
//                    "wh@miao.com", UserStatus.NORMAL,
//                    "Hao Wang"));
//        Assert.assertEquals(1, affectedRows);
//    }
//
//    @Test
//    public void updatePassword() {
//        UserInfo userInfo = userService.getOne(7);
//        System.out.println(userInfo);
//        boolean caughtException = false;
//        int affectedRows = 0;
//        try {
//            affectedRows = userService.updatePassword(1, "miao123");
//        }
//        catch (TripinException e) {
//            caughtException = true;
//            Assert.assertEquals(0, affectedRows);
//            System.out.println(e);
//            Assert.assertEquals(ErrorCode.UPDATE_ERROR.getCode(), e.getErrorCode().getCode());
//        }
//        if(!caughtException) {
//            Assert.assertEquals(1, affectedRows);
//            userInfo = userService.getOne(7);
//            System.out.println(userInfo);
//            Assert.assertEquals("miao123", userInfo.getPassword());
//        }
//    }
//
//    @Test
//    public void delete() {
////        Assert.assertEquals(1,
////                userService.insert(new UserInfo("song_ming",
////                        "jflakjfwa'ef", "90945091321",
////                        "sm@miao.com", UserStatus.NORMAL,
////                        "Song Ming")));
////        UserInfo userInfo = userService.getOneByUserName("song_ming");
////        List<UserInfo> userInfoList = userService.getAll();
////        for(UserInfo aUserInfo : userInfoList) {
////            System.out.println(aUserInfo.toString());
////        }
////        int previousSize = userInfoList.size();
//        int affectedRows = 0;
//        boolean caughtException = false;
//        try {
//            affectedRows = userService.delete(1);
//        }
//        catch (TripinException e) {
//            caughtException = true;
//            Assert.assertEquals(0, affectedRows);
//            System.out.println(e);
//            Assert.assertEquals(ErrorCode.DELETION_ERROR.getCode(), e.getErrorCode().getCode());
//        }
////        if (!caughtException) {
////            Assert.assertEquals(1, );
////            userInfoList = userService.getAll();
////            Assert.assertEquals(1, previousSize - userInfoList.size());
////        }
//    }
}