package com.dlut.pojo;

public class Class {
    private Integer classId;

    private String className;

    private Integer classType;

    private String classDescribe;

    public Class() {
    }

    public Class(String className, Integer classType, String classDescribe) {
        this.className = className;
        this.classType = classType;
        this.classDescribe = classDescribe;
    }

    public Class(Integer classId, String className, Integer classType, String classDescribe) {
        this.classId = classId;
        this.className = className;
        this.classType = classType;
        this.classDescribe = classDescribe;
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

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    public String getClassDescribe() {
        return classDescribe;
    }

    public void setClassDescribe(String classDescribe) {
        this.classDescribe = classDescribe == null ? null : classDescribe.trim();
    }
}