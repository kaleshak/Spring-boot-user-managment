package com.esquare.login.service.controller;

import com.esquare.login.service.model.Login;
import com.esquare.login.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    public static final String URL ="http://localhost:9191";

    @GetMapping("/")
    public String home() {
        return "register";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            Model model
    ) {
        Login login = loginService.findByUserName(userName);

        if (login != null && login.getPassword().equals(password)) {
            if (login.getRole().equals("admin")) {
                return "redirect:"+URL+"/admin";
            } else if (login.getRole().equals("employee")) {
                return "redirect:"+URL+"/employee";
            }
            model.addAttribute("error1", "Choose the correct user level");
            return "login";
        }
        model.addAttribute("error2", "Invalid username or password");
        return "login";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute Login user, HttpSession session) {

        boolean isEmailPresent = loginService.checkEmail(user.getEmail());
        if (isEmailPresent) {
            session.setAttribute("msg", "Email Id already Exist");
        } else {
            Login savedUser = loginService.createUser(user);
            if (Objects.nonNull(savedUser)) {
                session.setAttribute("msg", "Registration successful");
            } else {
                session.setAttribute("msg", "Internal Server Error");
            }
        }
        return "redirect:/register";
    }
}

