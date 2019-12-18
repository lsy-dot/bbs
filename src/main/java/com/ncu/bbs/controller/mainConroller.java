package com.ncu.bbs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncu.bbs.bean.Main;
import com.ncu.bbs.services.impl.mainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/main")
public class mainConroller {
    @Autowired
    mainServiceImpl mainService;
    @RequestMapping(value = "/getmainbyid",  produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getMainById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String smainid=request.getParameter("mainid");
        int mainid=Integer.parseInt(smainid);
        Main main=mainService.getMainById(mainid);
        HashMap<String, Main> hashMap = new HashMap();
        hashMap.put("main",main);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(hashMap);
        return jsonStr;
    }
    @RequestMapping(value = "/deletemainbyid")
    @ResponseBody
    public void deleteMainById(HttpServletRequest request, HttpSession session)throws
            UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("utf-8");
        String smainid = request.getParameter("mainid");
        int mainid = Integer.parseInt(smainid);
        mainService.deleteMainById(mainid);
    }
}
