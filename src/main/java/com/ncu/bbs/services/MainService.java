package com.ncu.bbs.services;

import com.ncu.bbs.bean.Main;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service("MainService")
@ContextConfiguration("classpath:applicationContext.xml")
public interface MainService {
    public List<Main> getMainBySectionId(Integer sectionId);

    public List<Main> getMainBySectionIdAndNum(Integer sectionId, int num);

    public List<Main> getTopMain(Integer sectionId);
    public List<Main> getNotTopMainBySectionId(Integer sectionId);

    List<Main> getPerfectBySectionId(Integer sectionId);

    void addMainPost(Main main);

    void addTopBatch(List<Integer> del_ids);

    void addTop(Integer id);

    List<Main> getNotPerfectMainBySectionId(Integer sectionId);

    void addPerfectBatch(List<Integer> del_ids);

    void addPerfect(Integer id);

    int getSectionIdByMainId(Integer mainId);

    void cancelTopByMainId(Integer mainId);

    void cancelPerfectBatch(List<Integer> del_ids);

    void cancelPerfect(Integer id);

    Main getMainByMainId(Integer mainId);
}
