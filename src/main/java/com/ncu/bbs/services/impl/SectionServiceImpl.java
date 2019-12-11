package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.Section;
import com.ncu.bbs.bean.SectionExample;
import com.ncu.bbs.dao.SectionMapper;
import com.ncu.bbs.services.MainService;
import com.ncu.bbs.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@Service("SectionService")
@ContextConfiguration("classpath:applicationContext.xml")
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionMapper sectionMapper;

    @Autowired
    MainService mainService;
    /**
     * 查找主页显示的所有帖子,同时会查询到最多4个精华帖用于显示在主页
     * @return
     */
    public List<Section> findAllSections() {
        List<Section> finals=new ArrayList<Section>();
        List<Section>list=new ArrayList<Section>();
        SectionExample example=new SectionExample();
        SectionExample.Criteria criteria=example.createCriteria();
        criteria.andSBanzhuidIsNotNull();//只要版主id不为空就查询出来
        list=sectionMapper.selectByExample(example);
        for(int i=0;i<list.size();i++){
            Section section=list.get(i);
            List<Main> mainlist=mainService.getMainBySectionIdAndNum(section.getsId(),4);
            section.setSomeMain(mainlist);
            finals.add(section);
        }
        return finals;
    }

    /**
     * 根据版块id来查找某一个版块的基本信息
     * @param sectionId
     * @return
     */
    public Section findSectionBySectionId(Integer sectionId) {
        Section section=sectionMapper.selectByPrimaryKey(sectionId);
        return section;
    }

}
