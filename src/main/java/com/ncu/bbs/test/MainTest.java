package com.ncu.bbs.test;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.dao.MainMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {
    @Autowired
    MainMapper mainMapper;

    /**
     * 根据主贴id找到发帖人的昵称
     */
    @Test
    public void selectMainById(){
        int id=1;
        Main main=mainMapper.selectByPrimaryKeyWithMainer(id);
        System.out.println(main.getUser().getuNickname());

    }

    /**
     * 增加 一些帖子
     */
    @Test
    public void addSomeMain(){
        //userID:181----
        for(int i=0;i<30;i++){
            String content= "本帖内容为："+UUID.randomUUID().toString().substring(0,10);
            String title="本帖标题是:"+UUID.randomUUID().toString().substring(0,10);
            int sectionId=(i%4+1);
            int mainerId=(i%20)+1;
            Main main=new Main();
            main.setmTitle(title);
            main.setmContent(content);
            int a=(int)(Math.random()*2);
            int b=(int)(Math.random()*2);
            main.setmIsontop(a);
            main.setmIsperfect(b);
            main.setmMainerid(mainerId);
            main.setmPoint(0);
            main.setmMaindate(new Date());
            main.setmSectionid(sectionId);
            mainMapper.insertSelective(main);
        }
    }
}
