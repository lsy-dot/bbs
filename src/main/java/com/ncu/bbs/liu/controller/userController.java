package com.ncu.bbs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncu.bbs.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    private com.ncu.bbs.services.userService userService;

    @RequestMapping(value = "/userLogin",  produces="text/html;charset=UTF-8")
    @ResponseBody
    public ModelAndView login(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        String userName= request.getParameter("username");
        String passWord= request.getParameter("password");
        String code = request.getParameter("code");
        String sessionCode = "";
        try {
            sessionCode = request.getSession().getAttribute("code").toString();
        } catch (NullPointerException e) {
            sessionCode = "";
        }

        if (userName==null||"".equals(userName)||passWord==null||"".equals(passWord)||sessionCode==null||"".equals(sessionCode)) {
            mav.setViewName("login");
            return mav;
        }else {
            if (code.equalsIgnoreCase(sessionCode)) {
                User user= userService.login(userName, passWord);
                if (user!=null) {
                   session.setAttribute("username",userName);
                   session.setAttribute("userid",user.getuId());
                   session.setAttribute("user",user);
                    mav.setViewName("index");//跳转到主页面
                    return mav;
                }else {
                    mav.setViewName("login");//
                    mav.addObject("message", "密码错误，请重新登录！");
                    return mav;
                }

            }else {
                mav.setViewName("login");
                mav.addObject("message", "验证码错误，请重新登录！");
                return mav;
            }
        }
    }

    public String modelAndViewToJson(ModelAndView modelAndView) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(modelAndView);
        return jsonStr;
    }
    @PostMapping(value = "/checkUserName")
    @ResponseBody
    public String checkUserName(String username) throws JsonProcessingException {
        HashMap<String,Boolean> hashMap = new HashMap();
        User user = userService.getUserByname(username);
        if (user != null ) {
            hashMap.put("valid",true);

        } else {
            hashMap.put("valid",false);
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(hashMap);
        return jsonStr;
    }
    @RequestMapping(value = "/getUserById",  produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getUserById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String suserid=request.getParameter("userid");
        int userid=Integer.parseInt(suserid);
        User user=userService.getUserById(userid);
        HashMap<String, User> hashMap = new HashMap();
        hashMap.put("user",user);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(hashMap);
        return jsonStr;
    }
}
