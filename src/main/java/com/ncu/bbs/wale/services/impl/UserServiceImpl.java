package com.ncu.bbs.wale.services.impl;

import com.ncu.bbs.bean.User;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.wale.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 11:58
 */
@Service("UserService")
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUserId(Integer latestuserid) {

        return userMapper.selectByPrimaryKey(latestuserid);
    }
}
