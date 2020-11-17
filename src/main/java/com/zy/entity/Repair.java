package com.zy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Repair)实体类
 *
 * @author makejava
 * @since 2020-10-26 09:51:09
 */
@Data
public class Repair implements Serializable {
    private static final long serialVersionUID = 282433447121289533L;
    /**
    * 维修员id
    */
    private Integer repairid;
    /**
    * 维修员姓名
    */
    private String repairname;
    /**
    * 电话
    */
    private String tel;
    /**
    * 性别
    */
    private String sex;
    /**
    * 部门id
    */
    private Integer departid;
    /**
    * 维修员类型
    */
    private Integer typeid;
    /**
    * 账号
    */
    private String username;
    /**
    * 密码
    */
    private String pwd;
    /**
    * 角色id
    */
    private String roleid;
    /**
    * 状态
    */
    private String state;


    public Integer getRepairid() {
        return repairid;
    }

    public void setRepairid(Integer repairid) {
        this.repairid = repairid;
    }

    public String getRepairname() {
        return repairname;
    }

    public void setRepairname(String repairname) {
        this.repairname = repairname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getDepartid() {
        return departid;
    }

    public void setDepartid(Integer departid) {
        this.departid = departid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}