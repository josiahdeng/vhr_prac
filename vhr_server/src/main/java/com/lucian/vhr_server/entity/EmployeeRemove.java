package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (EmployeeRemove)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:20
 */
public class EmployeeRemove implements Serializable {
    private static final long serialVersionUID = -56419272014003587L;

    private Integer id;

    private Integer eId;
    /**
     * 调动后部门
     */
    private Integer afterDepId;
    /**
     * 调动后职位
     */
    private Integer afterJobId;
    /**
     * 调动日期
     */
    private Date removeDate;
    /**
     * 调动原因
     */
    private String reason;

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

    public Integer getAfterDepId() {
        return afterDepId;
    }

    public void setAfterDepId(Integer afterDepId) {
        this.afterDepId = afterDepId;
    }

    public Integer getAfterJobId() {
        return afterJobId;
    }

    public void setAfterJobId(Integer afterJobId) {
        this.afterJobId = afterJobId;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}