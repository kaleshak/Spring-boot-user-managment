package com.esquare.login.service.repository;

import com.esquare.login.service.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {

    Login findByUserName(String userName);
    boolean existsByEmail(String email);
}

