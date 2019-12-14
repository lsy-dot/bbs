package com.ncu.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/jumpToLogin")
public class jumpToLoginController {
    @RequestMapping(value = "/login")//跳转到登陆页面
//    public  String login(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
////        request.setCharacterEncoding("utf-8");
////        ModelAndView mav = new ModelAndView();
////        mav.setViewName("login");
//        return "login";
//    }
    public  String login() throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");
        return "login";
    }
}
