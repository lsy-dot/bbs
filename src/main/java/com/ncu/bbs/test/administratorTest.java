package com.ncu.bbs.test;

import com.ncu.bbs.bean.Administrator;
import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.AdministratorMapper;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.services.impl.AdministratorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class administratorTest {
    @Autowired
    AdministratorServiceImpl administratorService;
    @Autowired
    AdministratorMapper administratorMapper;

    @Autowired
    UserMapper userMapper;
    @Test
    public void insertAdministrator(){
        Administrator administrator=new Administrator();
        administrator.setaAdminname("管理员");
        administrator.setaEmail("bbb");
        administrator.setaHeadpic("ccc");
        administrator.setaPassword("123456");
        administratorService.insertAdministrator(administrator);
}
    @Test
    public void  selectAllAdministrator(){
        List<Administrator> list=administratorService.selectAllAdministrator();
        administratorMapper.deleteByPrimaryKey(1);
        System.out.println(list.get(1));
    }

    @Test
    public void addUsers(){
        for(int i=0;i<20;i++){
            String name= UUID.randomUUID().toString().substring(0,6);
            String nickname=name;
            userMapper.insertSelective(new User(null,name,"123456",nickname,"F",name,name+"@qq.com","开朗，hello",null,"22","江西","学生",0,0));
        }
    }

    @Test
    public void deleteAllUser(){
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUIdIsNotNull();
        userMapper.deleteByExample(example);
    }
    @Test
    public void updateUsersGender(){
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUSexEqualTo("F");
        userMapper.updateByExampleSelective(new User(null,null,null,null,"男",null,null,null,null,null,null,null,null,null),example);
    }
}
