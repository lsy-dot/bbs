package com.ncu.bbs.services;

import com.ncu.bbs.bean.Main;

public interface mainService {
    Main getMainById(int mainid);
    void deleteMainById(int mainid);
    void modifyMainContentById(String content, int mainid);
}
