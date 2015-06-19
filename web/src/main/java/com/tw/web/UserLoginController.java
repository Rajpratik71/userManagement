package com.tw.web;

import com.tw.core.User;
import com.tw.core.service.UserService;
import com.tw.core.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by twer on 7/16/14.
 */
@RestController
@RequestMapping("/login")
public class UserLoginController {

    private UserService userService;
    private PasswordService passwordService;

    @Autowired
    public UserLoginController(UserService userService, PasswordService passwordService) {
        this.userService = userService;
        this.passwordService = passwordService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPageDefault() {
        return new ModelAndView("redirect:/login/");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, HttpSession sessionObj) {
        ModelAndView loginSucess = new ModelAndView("redirect:/user/");
        ModelAndView loginFailed = new ModelAndView("login");

        if (validateLogin(user)) {
            sessionObj.setAttribute("username", user.getName());
            return loginSucess;
        } else {
            return loginFailed;
        }
    }

    private boolean validateLogin(User user) {
        String userName = user.getName();
        String userPasswordEncrypted = passwordService.encrypt(user.getPassword());
        List<User> userList = userService.validateUser(userName, userPasswordEncrypted);
        return userList.size() != 0;
    }
}

