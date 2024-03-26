package com.dlut.pojo;

public class Recover {
    private Integer recoverId;

    private String recoverDescribe;

    private Integer recoverMetalId;

    private String recoverMetalName;

    public Integer getRecoverId() {
        return recoverId;
    }

    public void setRecoverId(Integer recoverId) {
        this.recoverId = recoverId;
    }

    public String getRecoverDescribe() {
        return recoverDescribe;
    }

    public void setRecoverDescribe(String recoverDescribe) {
        this.recoverDescribe = recoverDescribe == null ? null : recoverDescribe.trim();
    }

    public Integer getRecoverMetalId() {
        return recoverMetalId;
    }

    public void setRecoverMetalId(Integer recoverMetalId) {
        this.recoverMetalId = recoverMetalId;
    }

    public String getRecoverMetalName() {
        return recoverMetalName;
    }

    public void setRecoverMetalName(String recoverMetalName) {
        this.recoverMetalName = recoverMetalName == null ? null : recoverMetalName.trim();
    }
}