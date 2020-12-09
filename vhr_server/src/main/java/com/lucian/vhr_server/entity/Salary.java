package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Salary)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:39
 */
public class Salary implements Serializable {
    private static final long serialVersionUID = 435566947591700183L;

    private Integer id;
    /**
     * 基本工资
     */
    private Integer basicSalary;
    /**
     * 奖金
     */
    private Integer bonus;
    /**
     * 午餐补助
     */
    private Integer lunchSalary;
    /**
     * 交通补助
     */
    private Integer trafficSalary;
    /**
     * 应发工资
     */
    private Integer allSalary;
    /**
     * 养老金基数
     */
    private Integer pensionBase;
    /**
     * 养老金比率
     */
    private String pensionPer;
    /**
     * 启用时间
     */
    private Date createDate;
    /**
     * 医疗基数
     */
    private Integer medicalBase;
    /**
     * 医疗保险比率
     */
    private String medicalPer;
    /**
     * 公积金基数
     */
    private Integer accumulationFundBase;
    /**
     * 公积金比率
     */
    private String accumulationFundPer;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getLunchSalary() {
        return lunchSalary;
    }

    public void setLunchSalary(Integer lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public Integer getTrafficSalary() {
        return trafficSalary;
    }

    public void setTrafficSalary(Integer trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public Integer getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(Integer allSalary) {
        this.allSalary = allSalary;
    }

    public Integer getPensionBase() {
        return pensionBase;
    }

    public void setPensionBase(Integer pensionBase) {
        this.pensionBase = pensionBase;
    }

    public String getPensionPer() {
        return pensionPer;
    }

    public void setPensionPer(String pensionPer) {
        this.pensionPer = pensionPer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalBase(Integer medicalBase) {
        this.medicalBase = medicalBase;
    }

    public String getMedicalPer() {
        return medicalPer;
    }

    public void setMedicalPer(String medicalPer) {
        this.medicalPer = medicalPer;
    }

    public Integer getAccumulationFundBase() {
        return accumulationFundBase;
    }

    public void setAccumulationFundBase(Integer accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }

    public String getAccumulationFundPer() {
        return accumulationFundPer;
    }

    public void setAccumulationFundPer(String accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}