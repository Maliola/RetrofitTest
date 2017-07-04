package com.example.ios007.retrofittest.model.entry;

/**
 * Created by ios007 on 2017/7/4.
 */

public class User {
    /**
     *      "birthday": "string,生日",
     "gender": "string,性别",
     "user_id": "string,用户id",
     "district": "string,地区",
     "nickname": "string,昵称",
     "avatar": "string,头像"
     "is_vip": "boolean,是否是vip",
     "vip_level": "integer,vip等级",
     "lighted": "boolean,是否已点亮"
     "token": "string,用户token"

     */

    String birthday;
    String gender;
    String userId;
    String district;
    String nickName;
    String avatar;
    boolean isVip;
    String token;
    int vipLevel;
    boolean lighted;
    String loginType;
    String password;
    String userAccount;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public boolean isLighted() {
        return lighted;
    }

    public void setLighted(boolean lighted) {
        this.lighted = lighted;
    }
}
