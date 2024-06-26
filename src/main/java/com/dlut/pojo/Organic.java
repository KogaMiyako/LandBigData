package com.dlut.pojo;

public class Organic {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organic.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organic.organ1
     *
     * @mbggenerated
     */
    private Float organ1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organic.organ2
     *
     * @mbggenerated
     */
    private Float organ2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organic.organ3
     *
     * @mbggenerated
     */
    private Float organ3;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organic
     *
     * @mbggenerated
     */
    public Organic(Integer id, Float organ1, Float organ2, Float organ3) {
        this.id = id;
        this.organ1 = organ1;
        this.organ2 = organ2;
        this.organ3 = organ3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organic.id
     *
     * @return the value of organic.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organic.organ1
     *
     * @return the value of organic.organ1
     *
     * @mbggenerated
     */
    public Float getOrgan1() {
        return organ1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organic.organ2
     *
     * @return the value of organic.organ2
     *
     * @mbggenerated
     */
    public Float getOrgan2() {
        return organ2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organic.organ3
     *
     * @return the value of organic.organ3
     *
     * @mbggenerated
     */
    public Float getOrgan3() {
        return organ3;
    }
}