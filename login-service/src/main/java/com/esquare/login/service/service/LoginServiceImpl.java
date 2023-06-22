package com.esquare.login.service.service;

import com.esquare.login.service.model.Login;
import com.esquare.login.service.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login findByUserName(String userName) {
        return loginRepository.findByUserName(userName);
    }

    @Override
    public Login createUser(Login user) {
        return loginRepository.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return loginRepository.existsByEmail(email);
    }
}

