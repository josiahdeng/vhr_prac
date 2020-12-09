package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (EmployeeTrain)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:22
 */
public class EmployeeTrain implements Serializable {
    private static final long serialVersionUID = -88298041095469609L;

    private Integer id;
    /**
     * 员工编号
     */
    private Integer eId;
    /**
     * 培训日期
     */
    private Date trainDate;
    /**
     * 培训内容
     */
    private String trainContent;
    /**
     * 备注
     */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEId() {
        return eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}