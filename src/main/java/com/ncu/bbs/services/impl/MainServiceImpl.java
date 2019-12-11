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

    /**
     * 根据版块id查找某一个版块的所有帖子
     * @param sectionId
     * @return
     */
    public List<Main> getMainBySectionId(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);//带有发布者信息的查询
        return mainlist;
    }

    /**
     * 根据版块id和符合条件的数量num查找某个版块的num个帖子
     * @param sectionId
     * @param num
     * @return
     */
    public List<Main> getMainBySectionIdAndNum(Integer sectionId, int num) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMIsperfectEqualTo(1);//查找某一个版块的所有精华帖
        mainlist=mainMapper.selectByExample(mainExample);
        List<Main> finals=new ArrayList<Main>();
        for(int i=0;i<mainlist.size();i++){
            if(i<num){
                finals.add(mainlist.get(i));
            }
        }
        return finals;
    }

    /**
     * 根据版块id查找该板块的所有置顶帖
     * @param sectionId
     * @return
     */
    public List<Main> getTopMain(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMIsontopEqualTo(1);//查找置顶帖
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);//带有发布者信息的查询
        return mainlist;
    }

    /**
     * 根据版块id查找所有的不是置顶帖的帖子
     * @param sectionId
     * @return
     */
    public List<Main> getNotTopMainBySectionId(Integer sectionId) {
        List<Main> mainlist=new ArrayList<Main>();
        MainExample mainExample=new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        criteria.andMSectionidEqualTo(sectionId);
        criteria.andMIsontopEqualTo(0);//查找置顶帖
        mainExample.setOrderByClause("m_maindate desc");//按照时间进行排序
        mainlist=mainMapper.selectByExampleWithMainer(mainExample);//带有发布者信息的查询
        return mainlist;
    }

    /**
     * 根据版块id来查找该版块的所有精华帖
     * @param sectionId
     * @return
     */
    public List<Main> getPerfectBySectionId(Integer sectionId) {
        List<Main> perfectlist=new ArrayList<Main>();
        MainExample example=new MainExample();
        MainExample.Criteria criteria=example.createCriteria();
        criteria.andMIsperfectEqualTo(1);
        criteria.andMSectionidEqualTo(sectionId);
        perfectlist=mainMapper.selectByExampleWithMainer(example);
        return perfectlist;
    }

    /**
     * 根据main增加一个主贴记录
     * @param main
     */
    public void addMainPost(Main main) {
        mainMapper.insertSelective(main);
    }
}
