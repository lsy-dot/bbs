package com.ncu.bbs.controller;

import com.ncu.bbs.bean.Follow;
import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.bean.Section;
import com.ncu.bbs.services.FollowService;
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
    @Autowired
    FollowService followService;
    //返回某一个版块的所有主贴数量
    private int findAllMainNumsInSection(Integer sectionId){
        return mainService.getMainBySectionId(sectionId).size();
    }
    //返回某一个版块的所有主贴数量
    private int findAllFollowNumsInSection(Integer sectionId){
        List<Main>list= mainService.getMainBySectionId(sectionId);
        int follow=0;
        for(int i=0;i<list.size();i++){

            follow+=followService.getFollowPostByMainId(list.get(i).getmMainid()).size();
        }
        return follow;
    }

    /**
     * 获取版块的信息
     * @param sectionId
     * @return
     */
    private Section getSessionBySessionId(Integer sectionId){
        Section section=sectionService.findSectionBySectionId(sectionId);
        int mainsInSection=findAllMainNumsInSection(sectionId);
        int followsInSection=findAllFollowNumsInSection(sectionId);
        section.setMainNums(mainsInSection);
        section.setFollowNums(followsInSection);
        //System.out.println(section.getMainNums());
        return section;
    }
    /**
     * 返回指定的一个版块的所有帖子
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/thesection")
    public String toOneSection(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
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
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "perfect";
    }
    /**
     * 根据版块id找到需求帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/needs")
    public String getNeedMains(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "need";
    }

    /**
     * 根据版块id找到热门帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/hots")
    public String gethotMains(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "hot";
    }

    /**
     * 根据版块id找到最新帖
     * @param sectionId
     * @param model
     * @return
     */
    @RequestMapping("/news")
    public String getNewMains(@RequestParam("sectionId")Integer sectionId, Model model){
        model.addAttribute("section",getSessionBySessionId(sectionId));
        return "new";
    }
}
