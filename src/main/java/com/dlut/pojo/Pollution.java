package com.dlut.pojo;

public class Pollution {
    private Integer pollutionId;

    private String pollutionName;

    private String pollutionDescribe;

    //cr  ni  cu  zn  as  cd  hg  pb

    private Integer cr;

    private Integer ni;

    private Integer cu;

    private Integer zn;

    private Integer as;

    private Integer cd;

    private Integer hg;

    private Integer pb;

    public Pollution() {
    }

    public Pollution(String pollutionName, String pollutionDescribe, Integer cr, Integer ni, Integer cu, Integer zn, Integer as, Integer cd, Integer hg, Integer pb) {
        this.pollutionName = pollutionName;
        this.pollutionDescribe = pollutionDescribe;
        this.cr = cr;
        this.ni = ni;
        this.cu = cu;
        this.zn = zn;
        this.as = as;
        this.cd = cd;
        this.hg = hg;
        this.pb = pb;
    }

    public Integer getPollutionId() {
        return pollutionId;
    }

    public void setPollutionId(Integer pollutionId) {
        this.pollutionId = pollutionId;
    }

    public String getPollutionName() {
        return pollutionName;
    }

    public void setPollutionName(String pollutionName) {
        this.pollutionName = pollutionName == null ? null : pollutionName.trim();
    }

    public String getPollutionDescribe() {
        return pollutionDescribe;
    }

    public void setPollutionDescribe(String pollutionDescribe) {
        this.pollutionDescribe = pollutionDescribe == null ? null : pollutionDescribe.trim();
    }

    public Integer getCr() {
        return cr;
    }

    public void setCr(Integer cr) {
        this.cr = cr;
    }

    public Integer getNi() {
        return ni;
    }

    public void setNi(Integer ni) {
        this.ni = ni;
    }

    public Integer getCu() {
        return cu;
    }

    public void setCu(Integer cu) {
        this.cu = cu;
    }

    public Integer getZn() {
        return zn;
    }

    public void setZn(Integer zn) {
        this.zn = zn;
    }

    public Integer getAs() {
        return as;
    }

    public void setAs(Integer as) {
        this.as = as;
    }

    public Integer getCd() {
        return cd;
    }

    public void setCd(Integer cd) {
        this.cd = cd;
    }

    public Integer getHg() {
        return hg;
    }

    public void setHg(Integer hg) {
        this.hg = hg;
    }

    public Integer getPb() {
        return pb;
    }

    public void setPb(Integer pb) {
        this.pb = pb;
    }
}