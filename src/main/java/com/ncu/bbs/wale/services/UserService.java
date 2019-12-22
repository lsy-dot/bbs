package com.ncu.bbs.wale.services;

import com.ncu.bbs.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 11:58
 */
@Service("UserService")
@ContextConfiguration("classpath:applicationContext.xml")
public interface UserService {
    User getUserByUserId(Integer latestuserid);

    List<User> searchUsersByKeyWord(String keyword);

    void changeHeadPic(int uid,String headpic) ;

    int getPointByUId(int userid);

    void changePointByUserid(int parseInt, int finalPoints);
}
