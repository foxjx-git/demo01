package com.my.mydemo_01.dto;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class UserTokenDTO {
    private String userId;
    private String userToken;

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
}
