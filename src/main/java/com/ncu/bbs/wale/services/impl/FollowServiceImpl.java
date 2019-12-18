package com.ncu.bbs.wale.services.impl;

import com.ncu.bbs.bean.Follow;
import com.ncu.bbs.bean.FollowExample;
import com.ncu.bbs.dao.FollowMapper;
import com.ncu.bbs.wale.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 8:44
 */
@Service("FollowService")
@ContextConfiguration("classpath:applicationContext.xml")
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowMapper followMapper;

    @Override
    public List<Follow> getFollowPostByMainId(Integer mainId) {
        FollowExample followExample=new FollowExample();
        FollowExample.Criteria criteria=followExample.createCriteria();
        criteria.andFMainidEqualTo(mainId);
        return followMapper.selectByExample(followExample);
    }
}
