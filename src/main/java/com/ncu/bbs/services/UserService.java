package com.ncu.bbs.services;

import com.ncu.bbs.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 11:58
 */
@Service("UserService")
@ContextConfiguration("classpath:applicationContext.xml")
public interface UserService {
    User getUserByUserId(Integer latestuserid);
}
