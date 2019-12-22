package com.ncu.bbs.wale.services.impl;

import com.ncu.bbs.bean.User;
import com.ncu.bbs.bean.UserExample;
import com.ncu.bbs.dao.UserMapper;
import com.ncu.bbs.wale.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Author WaleGarrett
 * @Date 2019/12/16 11:58
 */
@Service("UserService")
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUserId(Integer latestuserid) {

        return userMapper.selectByPrimaryKey(latestuserid);
    }

    /**
     * 根据关键词查找符合条件的用户，这里只匹配账号
     * @param keyword
     * @return
     */
    @Override
    public List<User> searchUsersByKeyWord(String keyword) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUUseridLike("%"+keyword+"%");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public void changeHeadPic(int uid,String headpic) {
        UserExample userExample=new UserExample();
        userExample.or();
        userExample.or().andUIdEqualTo(uid);
        User user=new User();
        user.setuId(uid);
        user.setuHeadpic("/bbs/statics/images/upload/"+headpic);
        userMapper.updateByExampleSelective(user,userExample);
    }

    /**
     * 根据用户名获取用户的积分
     * @param userid
     * @return
     */
    @Override
    public int getPointByUId(int userid) {
        User user= userMapper.selectByPrimaryKey(userid);
        if(user!=null)
            return user.getuPoints();
        else return 0;
    }

    /**
     * 根据用户名进行积分删减功能
     * @param userid
     * @param finalPoints
     */
    @Override
    public void changePointByUserid(int userid, int finalPoints) {
        User user=new User();
        user.setuId(userid);
        user.setuPoints(finalPoints);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
