package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Appraise)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:09
 */
public class Appraise implements Serializable {
    private static final long serialVersionUID = -78556826178546747L;

    private Integer id;

    private Integer eId;
    /**
     * 考评日期
     */
    private Date appDate;
    /**
     * 考评结果
     */
    private String appResult;
    /**
     * 考评内容
     */
    private String appContent;
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

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getAppResult() {
        return appResult;
    }

    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}