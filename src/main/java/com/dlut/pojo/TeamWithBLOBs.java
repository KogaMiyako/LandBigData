package com.dlut.pojo;

public class TeamWithBLOBs extends Team {
    private String teamDesc;

    private byte[] teamLeadorganization;

    public String getTeamDesc() {
        return teamDesc;
    }

    public void setTeamDesc(String teamDesc) {
        this.teamDesc = teamDesc == null ? null : teamDesc.trim();
    }

    public byte[] getTeamLeadorganization() {
        return teamLeadorganization;
    }

    public void setTeamLeadorganization(byte[] teamLeadorganization) {
        this.teamLeadorganization = teamLeadorganization;
    }
}