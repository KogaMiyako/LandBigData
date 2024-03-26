package com.dlut.pojo;

public class Report {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.depart
     *
     * @mbggenerated
     */
    private String depart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.re_time
     *
     * @mbggenerated
     */
    private String reTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.text_name
     *
     * @mbggenerated
     */
    private String textName;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbggenerated
     */
    public Report(Integer id, String title, String depart, String reTime, String textName) {
        this.id = id;
        this.title = title;
        this.depart = depart;
        this.reTime = reTime;
        this.textName = textName;
    }

    public Report(String title, String depart, String reTime, String textName) {
        this.title = title;
        this.depart = depart;
        this.reTime = reTime;
        this.textName = textName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.id
     *
     * @return the value of report.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.title
     *
     * @return the value of report.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.depart
     *
     * @return the value of report.depart
     *
     * @mbggenerated
     */
    public String getDepart() {
        return depart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.re_time
     *
     * @return the value of report.re_time
     *
     * @mbggenerated
     */
    public String getReTime() {
        return reTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.text_name
     *
     * @return the value of report.text_name
     *
     * @mbggenerated
     */
    public String getTextName() {
        return textName;
    }
}