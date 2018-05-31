package com.tripin.application.entity;

import com.tripin.application.enums.UserStatus;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: User
 * @Description: User表的实例
 * @Author: Felix
 * @Date: 5/31/2018 16:31
 * @Version: 1.0
 **/

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userID;

    private String userName;

    private String password;

    private String phone;

    private String email;

    private UserStatus userStatus;

    private String nickName;

    public User() {

    }

    public User(int userID, String userName, String password, String phone, String email, UserStatus userStatus, String nickName) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userStatus = userStatus;
        this.nickName = nickName;
    }

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                getUserStatus() == user.getUserStatus() &&
                Objects.equals(getNickName(), user.getNickName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserID(), getUserName(), getPassword(), getPhone(), getEmail(), getUserStatus(), getNickName());
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
