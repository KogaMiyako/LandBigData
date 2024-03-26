package com.dlut.pojo;

public class Laws {
    private Integer lawsId;

    private String lawsName;

    private String lawsDescribe;

    private String lawsFilepath;

    public Integer getLawsId() {
        return lawsId;
    }

    public void setLawsId(Integer lawsId) {
        this.lawsId = lawsId;
    }

    public String getLawsName() {
        return lawsName;
    }

    public void setLawsName(String lawsName) {
        this.lawsName = lawsName == null ? null : lawsName.trim();
    }

    public String getLawsDescribe() {
        return lawsDescribe;
    }

    public void setLawsDescribe(String lawsDescribe) {
        this.lawsDescribe = lawsDescribe == null ? null : lawsDescribe.trim();
    }

    public String getLawsFilepath() {
        return lawsFilepath;
    }

    public void setLawsFilepath(String lawsFilepath) {
        this.lawsFilepath = lawsFilepath == null ? null : lawsFilepath.trim();
    }
}