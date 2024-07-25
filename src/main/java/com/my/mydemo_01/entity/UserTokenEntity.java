package com.my.mydemo_01.entity;

import java.time.LocalDateTime;

public class UserTokenEntity {
    private String userId;
    private String userToken;
    private LocalDateTime validTime;
    private LocalDateTime createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public LocalDateTime getValidTime() {
        return validTime;
    }

    public void setValidTime(LocalDateTime validTime) {
        this.validTime = validTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserTokenEntity{" +
                "userId='" + userId + '\'' +
                ", userToken='" + userToken + '\'' +
                ", validTime=" + validTime +
                ", createTime=" + createTime +
                '}';
    }
}
