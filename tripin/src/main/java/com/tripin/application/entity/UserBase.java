package com.tripin.application.entity;

import com.tripin.application.enums.*;
import java.util.Objects;

/**
 * Title:  UserBase
 * Description: 数据库表实例化 UserBase
 *
 * @Author: Felix
 * @Date: 2018/5/29 18:54
 * @Version: 1.0
 **/

public class UserBase {

    private static final long serialVersionUID = 1L;

    private int userID;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private UserStatus userStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UserBase(int userID, String userName, String password, String phone, String email, UserStatus userStatus) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBase userBase = (UserBase) o;
        return getUserID() == userBase.getUserID() &&
                Objects.equals(getUserName(), userBase.getUserName()) &&
                Objects.equals(getPassword(), userBase.getPassword()) &&
                Objects.equals(getPhone(), userBase.getPhone()) &&
                Objects.equals(getEmail(), userBase.getEmail()) &&
                getUserStatus() == userBase.getUserStatus();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserID(), getUserName(), getPassword(), getPhone(), getEmail(), getUserStatus());
    }

    @Override
    public String toString() {
        return "UserBase{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }

    public UserBase() {

    }

}

