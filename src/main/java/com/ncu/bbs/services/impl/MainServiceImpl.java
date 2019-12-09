package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.MainExample;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.MainMapper;
import com.ncu.bbs.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@Service("MainService")
@ContextConfiguration("classpath:applicationContext.xml")
public class MainServiceImpl implements MainService {

    @Autowired
    MainMapper mainMapper;

    public List<Main> getMainBySectionId(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);
        return mainlist;
    }
}
