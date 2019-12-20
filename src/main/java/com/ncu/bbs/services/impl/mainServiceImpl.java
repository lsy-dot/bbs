package com.ncu.bbs.services.impl;

import com.ncu.bbs.bean.Main;
import com.ncu.bbs.bean.MainExample;
import com.ncu.bbs.dao.MainMapper;
import com.ncu.bbs.services.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class mainServiceImpl implements mainService {
    @Autowired
    MainMapper mainMapper;
    public Main getMainById(int mainid) {
        MainExample mainExample=new MainExample();
        mainExample.or();
        mainExample.or().andMMainidEqualTo(mainid);
        List<Main> list= mainMapper.selectByExample(mainExample);
        if (list.size()==0)
            return null;
        else
           return list.get(0);

    }

    public void deleteMainById(int mainid) {
        MainExample mainExample=new MainExample();
        mainExample.or();
        mainExample.or().andMMainidEqualTo(mainid);
        mainMapper.deleteByExample(mainExample);
    }
    @Override
    public void modifyMainContentById(String content, int mainid) {
        MainExample mainExample=new MainExample();
        mainExample.or();
        mainExample.or().andMMainidEqualTo(mainid);
        Main main=new Main();
        main.setmContent(content);
        main.setmMainid(mainid);
        mainMapper.updateByExampleSelective(main,mainExample);
    }


}
