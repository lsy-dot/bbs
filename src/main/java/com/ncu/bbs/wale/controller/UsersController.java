package com.ncu.bbs.wale.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Msg;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.wale.services.MainService;
import com.ncu.bbs.wale.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WaleGarrett
 * @Date 2019/12/18 14:19
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;
    @Autowired
    MainService mainService;

    @RequestMapping("/searchUsers")
    @ResponseBody
    public Msg searchUsers(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @RequestParam("keyword")String keyword){
        List<User> list=new ArrayList<>();
        //引入分页插件,在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,3);
        list=userService.searchUsersByKeyWord(keyword);
        //查找找出来的用户的信息，加上发帖的总数
        for(int i=0;i<list.size();i++){
            User user=list.get(i);
            int userid=user.getuId();
            List<Main> mainlist=mainService.getMainByMainerId(userid);
            int mainPostNums=mainlist.size();
            user.setMainPostNums(mainPostNums);//发帖的数量
            list.set(i,user);
        }
        PageInfo page=new PageInfo(list,3);
        return Msg.success().add("pageInfo",page);
    }
}
