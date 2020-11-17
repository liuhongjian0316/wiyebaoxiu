package com.zy.entity;

import java.io.Serializable;

/**
 * (Superadmin)实体类
 *
 * @author makejava
 * @since 2020-11-14 14:40:01
 */
public class Superadmin implements Serializable {
    private static final long serialVersionUID = 870334390199990206L;
    
    private Integer id;
    /**
    * 账号
    */
    private String username;
    /**
    * 密码
    */
    private String pwd;
    /**
    * 角色
    */
    private String roleid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}