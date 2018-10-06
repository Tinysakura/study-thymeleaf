package com.cfh.study.studythymeleaf.controller;

import com.cfh.study.studythymeleaf.pojo.User;
import com.cfh.study.studythymeleaf.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: cfh
 * @Date: 2018/10/6 15:56
 * @Description:
 */
@Controller
@RequestMapping("/user")
@Slf4j
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

    @RequestMapping("/detail")
    public String showDetail(int userId, Model model) {
        log.info("userId:{}", userId);

        User user = userService.findOneUser();
        model.addAttribute("user", user);

        return "showOneUser";
    }

    @RequestMapping("/add/form")
    public String addForm() {
        return "form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addUser(User user) {
        log.info("user:{}", user.toString());

        return "add success";
    }
}
