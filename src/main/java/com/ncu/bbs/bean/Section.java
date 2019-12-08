package com.ncu.bbs.bean;

public class Section {
    private Integer sId;

    private String sSectionname;

    private String sDescription;

    private Integer sBanzhuid;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsSectionname() {
        return sSectionname;
    }

    public void setsSectionname(String sSectionname) {
        this.sSectionname = sSectionname;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public Integer getsBanzhuid() {
        return sBanzhuid;
    }

    public void setsBanzhuid(Integer sBanzhuid) {
        this.sBanzhuid = sBanzhuid;
    }
}