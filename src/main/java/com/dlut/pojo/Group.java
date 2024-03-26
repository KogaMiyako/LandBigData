package com.dlut.pojo;

public class Group {
    private Integer gourpId;

    private String groupName;

    private Integer userId;

    private String groupLeadername;

    private String groupDescribe;

    public Integer getGourpId() {
        return gourpId;
    }

    public void setGourpId(Integer gourpId) {
        this.gourpId = gourpId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGroupLeadername() {
        return groupLeadername;
    }

    public void setGroupLeadername(String groupLeadername) {
        this.groupLeadername = groupLeadername == null ? null : groupLeadername.trim();
    }

    public String getGroupDescribe() {
        return groupDescribe;
    }

    public void setGroupDescribe(String groupDescribe) {
        this.groupDescribe = groupDescribe == null ? null : groupDescribe.trim();
    }
}