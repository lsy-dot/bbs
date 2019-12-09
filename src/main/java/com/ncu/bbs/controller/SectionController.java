package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.services.MainService;
import com.ncu.bbs.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {

    @Autowired
    SectionService sectionService;
    @Autowired
    MainService mainService;
    @RequestMapping("/thesecion")
    public String toOneSection(@RequestParam("sectionId")Integer sectionId, Model model){
        List<Main> list=new ArrayList<Main>();
        list=mainService.getMainBySectionId(sectionId);
        //return Msg.success().add("mainlist",list);
        model.addAttribute("mainlist",list);
        System.out.println(list);
        return "section";
    }
}
