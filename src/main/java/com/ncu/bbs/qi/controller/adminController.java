package com.ncu.bbs.qi.controller;

import com.ncu.bbs.bean.Administrator;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.qi.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class adminController {
    @Autowired
    AdministratorService administratorService;


    @RequestMapping("/checkaAdminname")
    @ResponseBody
    public Msg checkaAdminname(HttpServletRequest request){
        String aAdminname = request.getParameter("aAdminname");
        System.out.print(aAdminname);
        boolean b = administratorService.checkaAdminname(aAdminname);
        //没有返回true,已经存在返回false
        if(b){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping("/checkaPassword")
    @ResponseBody
    public Msg checkaPassword(HttpServletRequest request, HttpSession session){
        String aPassword = request.getParameter("aPassword");
        String aAdminname=request.getParameter("aAdminname");

        System.out.print(aPassword);
        boolean b = administratorService.checkaPassword(aAdminname,aPassword);
        if(b){
            return Msg.success();
        }else{
            Administrator administrator=new Administrator();
            administrator=administratorService.getAdminByAdminname(aAdminname);
            session.setAttribute("adminid",administrator.getaId());
            session.setAttribute("adminname",administrator.getaAdminname());
            session.setAttribute("admin",administrator);
            return Msg.fail();
        }
    }

    @RequestMapping("/adminExit")
    public String adminExit(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("adminid");
        session.removeAttribute("admin");
        session.removeAttribute("adminname");
        return "login";
    }
}
