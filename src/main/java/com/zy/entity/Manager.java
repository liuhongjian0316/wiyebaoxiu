package com.zy.entity;

import java.io.Serializable;

/**
 * (Manager)实体类
 *
 * @author makejava
 * @since 2020-11-05 14:26:36
 */
public class Manager implements Serializable {
    private static final long serialVersionUID = 437406288087466844L;
    /**
    * id
    */
    private Integer managerid;
    /**
    * 经理姓名
    */
    private String managername;
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
    private Integer roleid;


    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

}