package com.zy.entity;

import java.io.Serializable;

/**
 * (Depart)实体类
 *
 * @author makejava
 * @since 2020-10-22 10:43:41
 */
public class Depart implements Serializable {
    private static final long serialVersionUID = -96886494390301705L;
    /**
    * id
    */
    private Integer departid;
    /**
    * 名称
    */
    private String departname;


    public Integer getDepartid() {
        return departid;
    }

    public void setDepartid(Integer departid) {
        this.departid = departid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

}