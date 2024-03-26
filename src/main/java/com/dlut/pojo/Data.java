package com.dlut.pojo;

import java.util.Date;

public class Data {
    private Integer dataId;

    private String dataName;

    private String dataFilename;

    private String dataCity;

    private String dataDescribe;

    private Date dataCreatetime;

    private String dataCreateuser;

    private Integer classId;

    private String className;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getDataFilename() {
        return dataFilename;
    }

    public void setDataFilename(String dataFilename) {
        this.dataFilename = dataFilename == null ? null : dataFilename.trim();
    }

    public String getDataCity() {
        return dataCity;
    }

    public void setDataCity(String dataCity) {
        this.dataCity = dataCity == null ? null : dataCity.trim();
    }

    public String getDataDescribe() {
        return dataDescribe;
    }

    public void setDataDescribe(String dataDescribe) {
        this.dataDescribe = dataDescribe == null ? null : dataDescribe.trim();
    }

    public Date getDataCreatetime() {
        return dataCreatetime;
    }

    public void setDataCreatetime(Date dataCreatetime) {
        this.dataCreatetime = dataCreatetime;
    }

    public String getDataCreateuser() {
        return dataCreateuser;
    }

    public void setDataCreateuser(String dataCreateuser) {
        this.dataCreateuser = dataCreateuser == null ? null : dataCreateuser.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}