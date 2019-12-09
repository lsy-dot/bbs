package com.ncu.bbs.bean;

import java.util.Date;
import java.util.List;

public class Main {
    private Integer mMainid;

    private String mContent;

    private Integer mMainerid;

    private Integer mSectionid;

    private Integer mIsontop;

    private Integer mIsperfect;

    private Date mMaindate;

    private Integer mPoint;

    private User user;//新增加一个该帖子的发布者的信息字段

    private List<Follow> follows;//新增一个所有跟帖者的信息字段

    public Integer getmMainid() {
        return mMainid;
    }

    public void setmMainid(Integer mMainid) {
        this.mMainid = mMainid;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Integer getmMainerid() {
        return mMainerid;
    }

    public void setmMainerid(Integer mMainerid) {
        this.mMainerid = mMainerid;
    }

    public Integer getmSectionid() {
        return mSectionid;
    }

    public void setmSectionid(Integer mSectionid) {
        this.mSectionid = mSectionid;
    }

    public Integer getmIsontop() {
        return mIsontop;
    }

    public void setmIsontop(Integer mIsontop) {
        this.mIsontop = mIsontop;
    }

    public Integer getmIsperfect() {
        return mIsperfect;
    }

    public void setmIsperfect(Integer mIsperfect) {
        this.mIsperfect = mIsperfect;
    }

    public Date getmMaindate() {
        return mMaindate;
    }

    public void setmMaindate(Date mMaindate) {
        this.mMaindate = mMaindate;
    }

    public Integer getmPoint() {
        return mPoint;
    }

    public void setmPoint(Integer mPoint) {
        this.mPoint = mPoint;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public List<Follow> getFollows() {
        return follows;
    }

    public void setFollows(List<Follow> follows) {
        this.follows = follows;
    }
}