package com.dlut.pojo;

public class Inorganinc {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inorganinc.elemID
     *
     * @mbggenerated
     */
    private Integer elemid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inorganinc.timeStemp
     *
     * @mbggenerated
     */
    private String timestemp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inorganinc.data
     *
     * @mbggenerated
     */
    private Float data;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inorganinc
     *
     * @mbggenerated
     */
    public Inorganinc(Integer elemid, String timestemp, Float data) {
        this.elemid = elemid;
        this.timestemp = timestemp;
        this.data = data;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inorganinc.elemID
     *
     * @return the value of inorganinc.elemID
     *
     * @mbggenerated
     */
    public Integer getElemid() {
        return elemid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inorganinc.timeStemp
     *
     * @return the value of inorganinc.timeStemp
     *
     * @mbggenerated
     */
    public String getTimestemp() {
        return timestemp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inorganinc.data
     *
     * @return the value of inorganinc.data
     *
     * @mbggenerated
     */
    public Float getData() {
        return data;
    }
}