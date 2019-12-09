package com.ncu.bbs.services;

import com.ncu.bbs.bean.Main;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service("MainService")
@ContextConfiguration("classpath:applicationContext.xml")
public interface MainService {
    public List<Main> getMainBySectionId(Integer sectionId);
}
