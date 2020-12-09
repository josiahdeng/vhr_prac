package com.lucian.vhr_server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:13
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 284968819643661522L;
    /**
     * 员工编号
     */
    private Integer id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 婚姻状况
     */
    private String wedLock;
    /**
     * 民族
     */
    private Integer nationId;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 政治面貌
     */
    private Integer politicId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 所属部门
     */
    private Integer departmentId;
    /**
     * 职称ID
     */
    private Integer jobLevelId;
    /**
     * 职位ID
     */
    private Integer posId;
    /**
     * 聘用形式
     */
    private String engageForm;
    /**
     * 最高学历
     */
    private String tiptopDegree;
    /**
     * 所属专业
     */
    private String specialty;
    /**
     * 毕业院校
     */
    private String school;
    /**
     * 入职日期
     */
    private Date beginDate;
    /**
     * 在职状态
     */
    private String workState;
    /**
     * 工号
     */
    private String workId;
    /**
     * 合同期限
     */
    private Double contractTerm;
    /**
     * 转正日期
     */
    private Date conversionTime;
    /**
     * 离职日期
     */
    private Date notworkDate;
    /**
     * 合同起始日期
     */
    private Date beginContract;
    /**
     * 合同终止日期
     */
    private Date endContract;
    /**
     * 工龄
     */
    private Integer workAge;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWedLock() {
        return wedLock;
    }

    public void setWedLock(String wedLock) {
        this.wedLock = wedLock;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getPoliticId() {
        return politicId;
    }

    public void setPoliticId(Integer politicId) {
        this.politicId = politicId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(Integer jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Double getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Double contractTerm) {
        this.contractTerm = contractTerm;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Date getNotworkDate() {
        return notworkDate;
    }

    public void setNotworkDate(Date notworkDate) {
        this.notworkDate = notworkDate;
    }

    public Date getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

}