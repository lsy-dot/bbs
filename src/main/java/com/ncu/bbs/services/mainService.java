package com.ncu.bbs.services;

import com.ncu.bbs.bean.Main;

import java.util.List;

public interface mainService {
    Main getMainById(int mainid);
    void deleteMainById(int mainid);
}
