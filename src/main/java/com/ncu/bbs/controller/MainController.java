package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.dao.MainMapper;
import com.ncu.bbs.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    MainService mainService;
    @Autowired
    MainMapper mainMapper;

    @ResponseBody
    @RequestMapping("/publish")
    public Msg publishMain(Integer mMainerid, Integer mSectionid, String mTitle, String mContent,Integer mPoint){
        System.out.println(mMainerid+" "+mSectionid+" "+mTitle+" "+mContent+" "+mPoint);
        Main main=new Main();
        main.setmSectionid(mSectionid);
        main.setmMaindate(new Date());
        main.setmPoint(mPoint);
        main.setmMainerid(mMainerid);
        main.setmIsperfect(0);
        main.setmIsontop(0);
        main.setmContent(mContent);
        main.setmTitle(mTitle);
        mainService.addMainPost(main);
        //return "forward:/section/thesection?sectionId="+mSectionid;
       return Msg.success().add("content",mContent);
    }
}
