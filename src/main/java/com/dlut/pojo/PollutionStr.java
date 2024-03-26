package com.dlut.pojo;

public class PollutionStr {
    private Integer pluId;
    private String pluName;
    private String pluDesc;
    private String pluMetalStr;

    public Integer getPluId() {
        return pluId;
    }

    public void setPluId(Integer pluId) {
        this.pluId = pluId;
    }

    public String getPluName() {
        return pluName;
    }

    public void setPluName(String pluName) {
        this.pluName = pluName;
    }

    public String getPluDesc() {
        return pluDesc;
    }

    public void setPluDesc(String pluDesc) {
        this.pluDesc = pluDesc;
    }

    public String getPluMetalStr() {
        return pluMetalStr;
    }

    public void setPluMetalStr(String pluMetalStr) {
        this.pluMetalStr = pluMetalStr;
    }



    public void setPluMetalStr(Pollution plu) {
        String str = "";
        if(plu.getCr() == 1){
            str += " Cr ";
        }
        else if (plu.getCr() == 2){
            str += " Cr* ";
        }
        if(plu.getNi() == 1){
            str += " Ni ";
        }
        else if (plu.getNi() == 2){
            str += " Ni* ";
        }if(plu.getCu() == 1){
            str += " Cu ";
        }
        else if (plu.getCu() == 2){
            str += " Cu* ";
        }if(plu.getZn() == 1){
            str += " Zn ";
        }
        else if (plu.getZn() == 2){
            str += " Zn* ";
        }if(plu.getAs() == 1){
            str += " As ";
        }
        else if (plu.getAs() == 2){
            str += " As* ";
        }if(plu.getCd() == 1){
            str += " Cd ";
        }
        else if (plu.getCd() == 2){
            str += " Cd* ";
        }if(plu.getHg() == 1){
            str += " Hg ";
        }
        else if (plu.getHg() == 2){
            str += " Hg* ";
        }if(plu.getPb() == 1){
            str += " Pb ";
        }
        else if (plu.getPb() == 2){
            str += " Pb* ";
        }
        this.pluMetalStr = str;
    }
}
