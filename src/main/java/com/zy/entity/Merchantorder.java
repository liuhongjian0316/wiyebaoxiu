package com.zy.entity;

import java.io.Serializable;

/**
 * (Merchantorder)实体类
 *
 * @author makejava
 * @since 2020-11-11 15:08:14
 */
public class Merchantorder implements Serializable {
    private static final long serialVersionUID = 178671851172598824L;
    /**
    * 报单id
    */
    private Integer workOrderId;
    /**
    * 报单种类(0普通,1悬赏)
    */
    private String workstate;
    /**
    * 报单类型
    */
    private String worktypeid;
    /**
    * 商户名称
    */
    private String shopName;
    /**
    * 申请人id
    */
    private Integer merchantid;
    /**
    * 报修人
    */
    private String applyName;
    /**
    * 电话
    */
    private String tel;
    /**
    * 预约时间
    */
    private String reserveTime;
    /**
    * 详细位置
    */
    private String address;
    /**
    * 申请状态
    */
    private String state;
    /**
    * 支付状态
    */
    private String payState;
    /**
    * 总价金额
    */
    private String totalMoney;
    /**
    * 故障描述
    */
    private Object faultDescription;
    /**
    * 维修员id
    */
    private Integer repairid;
    /**
    * 维修员
    */
    private String worker;
    /**
    * 拒绝原因
    */
    private String cause;
    /**
    * 负责人
    */
    private String chargePerson;
    /**
    * 拒单说明
    */
    private String faultCause;
    /**
    * 反应速度
    */
    private String reactSpeed;
    /**
    * 专业水平
    */
    private String professionLevel;
    /**
    * 服务态度
    */
    private String serviceAttitude;
    /**
    * 评价内容
    */
    private String contentEvaluation;


    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate;
    }

    public String getWorktypeid() {
        return worktypeid;
    }

    public void setWorktypeid(String worktypeid) {
        this.worktypeid = worktypeid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Object getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(Object faultDescription) {
        this.faultDescription = faultDescription;
    }

    public Integer getRepairid() {
        return repairid;
    }

    public void setRepairid(Integer repairid) {
        this.repairid = repairid;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getFaultCause() {
        return faultCause;
    }

    public void setFaultCause(String faultCause) {
        this.faultCause = faultCause;
    }

    public String getReactSpeed() {
        return reactSpeed;
    }

    public void setReactSpeed(String reactSpeed) {
        this.reactSpeed = reactSpeed;
    }

    public String getProfessionLevel() {
        return professionLevel;
    }

    public void setProfessionLevel(String professionLevel) {
        this.professionLevel = professionLevel;
    }

    public String getServiceAttitude() {
        return serviceAttitude;
    }

    public void setServiceAttitude(String serviceAttitude) {
        this.serviceAttitude = serviceAttitude;
    }

    public String getContentEvaluation() {
        return contentEvaluation;
    }

    public void setContentEvaluation(String contentEvaluation) {
        this.contentEvaluation = contentEvaluation;
    }

}