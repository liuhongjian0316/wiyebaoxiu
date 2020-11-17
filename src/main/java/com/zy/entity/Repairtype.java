package com.zy.entity;

import java.io.Serializable;

/**
 * (Repairtype)实体类
 *
 * @author makejava
 * @since 2020-10-22 11:26:15
 */
public class Repairtype implements Serializable {
    private static final long serialVersionUID = 871069918256214623L;
    /**
    * id
    */
    private Integer repairtypeid;
    /**
    * 维修员类型名称
    */
    private String repairtypename;


    public Integer getRepairtypeid() {
        return repairtypeid;
    }

    public void setRepairtypeid(Integer repairtypeid) {
        this.repairtypeid = repairtypeid;
    }

    public String getRepairtypename() {
        return repairtypename;
    }

    public void setRepairtypename(String repairtypename) {
        this.repairtypename = repairtypename;
    }

}