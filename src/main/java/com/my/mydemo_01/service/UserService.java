package com.my.mydemo_01.service;



public interface UserService {
    String queryByUserName(String userName);
    String login(String password, String passwordDto);


}
