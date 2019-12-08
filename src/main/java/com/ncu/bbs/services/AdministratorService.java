package com.ncu.bbs.services;

import com.ncu.bbs.bean.Administrator;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
@Service
@ContextConfiguration("classpath:applicationContext.xml")
public interface AdministratorService {
    public void insertAdministrator(Administrator administrator);
    public List<Administrator> selectAllAdministrator();
}
