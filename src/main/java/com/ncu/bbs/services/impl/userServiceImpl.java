package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
@ContextConfiguration("classpath:applicationContext.xml")
public class userServiceImpl implements userService {
    @Autowired
    UserMapper userMapper;
    public User login(String username, String pwd) {
        User user=new User();
        UserExample userExample = new UserExample();
        userExample.or();
        userExample.or().andUUseridEqualTo(username).andUPasswordEqualTo(pwd);
        List<User> result=userMapper.selectByExample(userExample);
        if (result.size()>0)
        user=result.get(0);
        else
            user=null;
        return user;
    }

    public User getUserByname(String username) {
        User user=new User();
        UserExample userExample = new UserExample();
        userExample.or();
        userExample.or().andUUseridEqualTo(username);
        List<User> result=userMapper.selectByExample(userExample);
        if (result.size()>0)
            user=result.get(0);
        else
            user=null;
        return user;
    }
}
