package com.ncu.bbs.test;

import com.ncu.bbs.bean.Section;
import com.ncu.bbs.dao.SectionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SectionTest {

    @Autowired
    SectionMapper mapper;
    @Test
    public void addSomeSection(){
        for(int i=0;i<5;i++){
            Section section=new Section();
            section.setsSectionname("版块"+i);
            section.setsBanzhuid(181);
            section.setsDescription("版块介绍如下。。。");
            mapper.insertSelective(section);
        }
    }
    @Test
    public void deleteSectionById(){

        mapper.deleteByPrimaryKey(5);
    }

}
