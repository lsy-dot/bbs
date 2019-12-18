package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Administrator;
import com.ncu.bbs.dao.AdministratorMapper;
import com.ncu.bbs.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
@ContextConfiguration("classpath:applicationContext.xml")
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    AdministratorMapper administratorMapper;
    public void insertAdministrator(Administrator administrator) {
        administratorMapper.insert(administrator);
    }

    public List<Administrator> selectAllAdministrator() {
        List<Administrator> list=administratorMapper.selectByExample(null);
        return list;
    }
}
