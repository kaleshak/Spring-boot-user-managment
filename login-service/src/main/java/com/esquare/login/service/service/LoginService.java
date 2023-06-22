package com.esquare.login.service.service;

import com.esquare.login.service.model.Login;

public interface LoginService {
    Login findByUserName(String userName);

    Login createUser(Login user);

    boolean checkEmail(String email);
}
