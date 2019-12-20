package com.ncu.bbs.services;

import com.ncu.bbs.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface userService {
     public User login(String username, String pwd);
     public User getUserByname(String username);
     public User getUserById(int id);
     public void addPoint(int mainid, int followerid, int point,int mainpoint);
}