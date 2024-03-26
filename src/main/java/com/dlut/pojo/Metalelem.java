package com.dlut.pojo;

public class Metalelem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metalelem.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metalelem.timeStamp
     *
     * @mbggenerated
     */
    private String timestamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metalelem.elem1
     *
     * @mbggenerated
     */
    private Float elem1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metalelem.elem2
     *
     * @mbggenerated
     */
    private Float elem2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column metalelem.elem3
     *
     * @mbggenerated
     */
    private Float elem3;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public Metalelem(Integer id, String timestamp, Float elem1, Float elem2, Float elem3) {
        this.id = id;
        this.timestamp = timestamp;
        this.elem1 = elem1;
        this.elem2 = elem2;
        this.elem3 = elem3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metalelem.id
     *
     * @return the value of metalelem.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metalelem.timeStamp
     *
     * @return the value of metalelem.timeStamp
     *
     * @mbggenerated
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metalelem.elem1
     *
     * @return the value of metalelem.elem1
     *
     * @mbggenerated
     */
    public Float getElem1() {
        return elem1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metalelem.elem2
     *
     * @return the value of metalelem.elem2
     *
     * @mbggenerated
     */
    public Float getElem2() {
        return elem2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column metalelem.elem3
     *
     * @return the value of metalelem.elem3
     *
     * @mbggenerated
     */
    public Float getElem3() {
        return elem3;
    }
}