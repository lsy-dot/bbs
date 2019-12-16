package com.ncu.bbs.services;

import com.ncu.bbs.bean.Follow;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 8:41
 */
@Service("FollowService")
@ContextConfiguration("classpath:applicationContext.xml")
public interface FollowService {
    List<Follow> getFollowPostByMainId(Integer mainId);
}
