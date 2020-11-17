package com.zy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-11-14 16:29:40
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 428482681786155137L;
    /**
    * id
    */
    private Integer roleid;
    /**
    * 角色名
    */
    private String rolename;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}