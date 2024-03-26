package com.dlut.pojo;



/**
 * Created by febiven on 2019/4/30
 **/
public class GeoPoint {
    private double longitude; //经度
    private double latitude;  //纬度
    //  Cr  Ni  Cu  Zn  As  Cd  Hg  Pb
    private double[] metalArr;
    private double Cr;
    private double Ni;
    private double Cu;
    private double Zn;
    private double As;
    private double Cd;
    private double Hg;
    private double Pb;
    private String areaRank1;
    private String areaRank2;
    private String areaRank3;
    private String areaRank4;
    private String place;


    public GeoPoint(double longitude, double latitude, double[] metalArr, String[] areas) {
        this.longitude = longitude;
        this.latitude = latitude;
        setMetal(metalArr);
        setPlaceAndAreas(areas);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double[] getMetalArr() {
        return metalArr;
    }

    public void setMetalArr(double[] metalArr) {
        this.metalArr = metalArr;
    }

    public double getCr() {
        return Cr;
    }

    public void setCr(double cr) {
        Cr = cr;
    }

    public double getNi() {
        return Ni;
    }

    public void setNi(double ni) {
        Ni = ni;
    }

    public double getCu() {
        return Cu;
    }

    public void setCu(double cu) {
        Cu = cu;
    }

    public double getZn() {
        return Zn;
    }

    public void setZn(double zn) {
        Zn = zn;
    }

    public double getAs() {
        return As;
    }

    public void setAs(double as) {
        As = as;
    }

    public double getCd() {
        return Cd;
    }

    public void setCd(double cd) {
        Cd = cd;
    }

    public double getHg() {
        return Hg;
    }

    public void setHg(double hg) {
        Hg = hg;
    }

    public double getPb() {
        return Pb;
    }

    public void setPb(double pb) {
        Pb = pb;
    }

    public String getAreaRank1() {
        return areaRank1;
    }

    public void setAreaRank1(String areaRank1) {
        this.areaRank1 = areaRank1;
    }

    public String getAreaRank2() {
        return areaRank2;
    }

    public void setAreaRank2(String areaRank2) {
        this.areaRank2 = areaRank2;
    }

    public String getAreaRank3() {
        return areaRank3;
    }

    public void setAreaRank3(String areaRank3) {
        this.areaRank3 = areaRank3;
    }

    public String getAreaRank4() {
        return areaRank4;
    }

    public void setAreaRank4(String areaRank4) {
        this.areaRank4 = areaRank4;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    //  Cr  Ni  Cu  Zn  As  Cd  Hg  Pb
    public void setMetal(double[] metalArr){
        this.metalArr = metalArr;
        this.Cr = metalArr[0];
        this.Ni = metalArr[1];
        this.Cu = metalArr[2];
        this.Zn = metalArr[3];
        this.As = metalArr[4];
        this.Cd = metalArr[5];
        this.Hg = metalArr[6];
        this.Pb = metalArr[7];
    }
    public void setPlaceAndAreas(String[] areas){
        this.areaRank1 = areas[0];
        this.areaRank2 = areas[1];
        this.areaRank3 = areas[2];
        this.areaRank4 = areas[3];
        this.place = areas[0] + " " + areas[1] + " " + areas[2] + " " + areas[3];
    }
}
