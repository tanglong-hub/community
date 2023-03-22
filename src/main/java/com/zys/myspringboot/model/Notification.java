package com.zys.myspringboot.model;

public class Notification {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.id
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.notifier
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private Long notifier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.receiver
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private Long receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.outerid
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private Long outerid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.type
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.gmt_create
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.status
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.notifier_name
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private String notifierName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.outer_title
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    private String outerTitle;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.id
     *
     * @return the value of NOTIFICATION.id
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.id
     *
     * @param id the value for NOTIFICATION.id
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.notifier
     *
     * @return the value of NOTIFICATION.notifier
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public Long getNotifier() {
        return notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.notifier
     *
     * @param notifier the value for NOTIFICATION.notifier
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.receiver
     *
     * @return the value of NOTIFICATION.receiver
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.receiver
     *
     * @param receiver the value for NOTIFICATION.receiver
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.outerid
     *
     * @return the value of NOTIFICATION.outerid
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public Long getOuterid() {
        return outerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.outerid
     *
     * @param outerid the value for NOTIFICATION.outerid
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setOuterid(Long outerid) {
        this.outerid = outerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.type
     *
     * @return the value of NOTIFICATION.type
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.type
     *
     * @param type the value for NOTIFICATION.type
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.gmt_create
     *
     * @return the value of NOTIFICATION.gmt_create
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.gmt_create
     *
     * @param gmtCreate the value for NOTIFICATION.gmt_create
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.status
     *
     * @return the value of NOTIFICATION.status
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.status
     *
     * @param status the value for NOTIFICATION.status
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.notifier_name
     *
     * @return the value of NOTIFICATION.notifier_name
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public String getNotifierName() {
        return notifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.notifier_name
     *
     * @param notifierName the value for NOTIFICATION.notifier_name
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName == null ? null : notifierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.outer_title
     *
     * @return the value of NOTIFICATION.outer_title
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public String getOuterTitle() {
        return outerTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.outer_title
     *
     * @param outerTitle the value for NOTIFICATION.outer_title
     *
     * @mbg.generated Wed Mar 22 03:44:57 CST 2023
     */
    public void setOuterTitle(String outerTitle) {
        this.outerTitle = outerTitle == null ? null : outerTitle.trim();
    }
}