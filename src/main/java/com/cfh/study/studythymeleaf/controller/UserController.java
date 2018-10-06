package com.cfh.study.studythymeleaf.controller;

import com.cfh.study.studythymeleaf.pojo.User;
import com.cfh.study.studythymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: cfh
 * @Date: 2018/10/6 15:56
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/one")
    public String findOne(Model model) {
        User user = userService.findOneUser();
        model.addAttribute("user", user);

        return "showOneUser";
    }

    @RequestMapping("/all")
    public String findAll(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("users", userList);

        return "showAllUser";
    }
}
