package com.cfh.study.studythymeleaf.controller;

import com.cfh.study.studythymeleaf.pojo.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @Author: cfh
 * @Date: 2018/10/6 14:32
 * @Description:
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index(Model model) {
        ArrayList<Article> list = new ArrayList<>();
        list.add(new Article("Async：简洁优雅的异步之道","在异步处理方案中，目前最为简洁优雅的便是async函数（以下简称A函数）。","www.baidu.com"));
        list.add(new Article("H5 前端性能测试实践","H5 页面发版灵活，轻量，又具有跨平台的特性，在业务上有很多应用场景。","www.baidu.com"));
        list.add(new Article("学习Python的建议","Python是最容易入门的编程语言。","www.baidu.com"));
        model.addAttribute("articleList",list);
        return "index";
    }

    @RequestMapping("/internationalization")
    public String testInternationalization() {
        return "internationalization";
    }

    @RequestMapping("/placeholder")
    public String testPlaceholder(Model model) {
        model.addAttribute("name", "tinysakura");

        return "placeholder";
    }

    @RequestMapping("/thymeleaf/objects")
    public String testThymeleafObjects(Model model, HttpServletRequest request, HttpServletResponse response,
                                       HttpSession session) {
        WebContext ctx = new WebContext(request, response, request.getServletContext());
        ctx.setVariable("book", "白夜行");
        session.setAttribute("city", "琅琊古城");

        return "thymeleafObject";
    }

    @RequestMapping("/test/if")
    public String testIf(Model model) {
        model.addAttribute("score", 99);

        return "testIf";
    }

    @RequestMapping("/fragment")
    public String testFragment() {
        return "useFragment";
    }
}
