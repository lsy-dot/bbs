package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.bean.Section;
import com.ncu.bbs.services.MainService;
import com.ncu.bbs.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @Autowired
    MainService mainService;

    /**
     * 返回指定的一个版块的所有帖子
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/thesection")
    public String toOneSection(@RequestParam("sectionId")Integer sectionId, Model model){
        List<Main> list=new ArrayList<Main>();
        List<Main> toplist=new ArrayList<Main>();
        list=mainService.getNotTopMainBySectionId(sectionId);//根据版块id查找该版块的所有非置顶帖的帖子
        toplist=mainService.getTopMain(sectionId);
        //这里需要对找出来的帖子进行排序---------------------置顶帖在最前面
        List<Main> finals=new ArrayList<Main>();//最终的数组
        for(Main main:toplist){
            finals.add(main);
        }
        for (Main main:list) {
            finals.add(main);
            //System.out.println(main);
        }
        Section section=sectionService.findSectionBySectionId(sectionId);
        model.addAttribute("section",section);
        model.addAttribute("mainlist",finals);
        //System.out.println(list);
        return "section";
    }

    /**
     * 查找所有的版块，另外附加板块中最多数量为4的帖子的一些信息
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody//记得一定要加上这个注解
    public Msg findAll(){
        List<Section> list=new ArrayList<Section>();
        list=sectionService.findAllSections();
        return Msg.success().add("sectionslist",list);
    }

    /**
     * 根据版块id找到精华帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/perfects")
    public String getPerfectMains(@RequestParam("sectionId")Integer sectionId, Model model){
        List<Main> perfectlist=new ArrayList<Main>();
        perfectlist=mainService.getPerfectBySectionId(sectionId);
        model.addAttribute("perfectlist",perfectlist);

        Section section=sectionService.findSectionBySectionId(sectionId);
        model.addAttribute("section",section);
        return "perfect";
    }
}
