package com.tripin.application.entity;

import com.tripin.application.enums.*;
import java.util.Date;
import java.util.Objects;

/**
 * Title:  UserProfile
 * Description: 数据库表实例化 UserProfile
 *
 * @Author: Felix
 * @Date: 2018/5/29 19:54
 * @Version: 1.0
 **/

public class UserProfile {

    private static final long serialVersionUID = 1L;

    private int userID;
    private String realName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return getUserID() == that.getUserID() &&
                getLoginTimes() == that.getLoginTimes() &&
                Objects.equals(getRealName(), that.getRealName()) &&
                Objects.equals(getNickName(), that.getNickName()) &&
                getGender() == that.getGender() &&
                Objects.equals(getAvatar(), that.getAvatar()) &&
                Objects.equals(getBirthday(), that.getBirthday()) &&
                Objects.equals(getLanguage(), that.getLanguage()) &&
                Objects.equals(getRegistIP(), that.getRegistIP()) &&
                Objects.equals(getRegistTime(), that.getRegistTime()) &&
                Objects.equals(getLoginIP(), that.getLoginIP()) &&
                Objects.equals(getLoginTime(), that.getLoginTime());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserID(), getRealName(), getNickName(), getGender(), getAvatar(), getBirthday(), getLanguage(), getRegistIP(), getRegistTime(), getLoginIP(), getLoginTime(), getLoginTimes());
    }

    private String nickName;
    private Gender gender;
    private String avatar;
    private Date birthday;
    private String language;
    private String registIP;
    private Date registTime;
    private String loginIP;
    private Date loginTime;
    private int loginTimes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegistIP() {
        return registIP;
    }

    public void setRegistIP(String registIP) {
        this.registIP = registIP;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public int getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(int loginTimes) {
        this.loginTimes = loginTimes;
    }

    public UserProfile(int userID, String realName, String nickName, Gender gender, String avatar, Date birthday, String language, String registIP, Date registTime, String loginIP, Date loginTime, int loginTimes) {
        this.userID = userID;
        this.realName = realName;
        this.nickName = nickName;
        this.gender = gender;
        this.avatar = avatar;
        this.birthday = birthday;
        this.language = language;
        this.registIP = registIP;
        this.registTime = registTime;
        this.loginIP = loginIP;
        this.loginTime = loginTime;
        this.loginTimes = loginTimes;
    }

    public UserProfile() {
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userID=" + userID +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", birthday=" + birthday +
                ", language='" + language + '\'' +
                ", registIP='" + registIP + '\'' +
                ", registTime=" + registTime +
                ", loginIP='" + loginIP + '\'' +
                ", loginTime=" + loginTime +
                ", loginTimes=" + loginTimes +
                '}';
    }
}
