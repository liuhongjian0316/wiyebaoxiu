package com.zy.entity;

import java.io.Serializable;

/**
 * (Woktype)实体类
 *
 * @author makejava
 * @since 2020-10-28 15:19:35
 */
public class Woktype implements Serializable {
    private static final long serialVersionUID = -97399254615381150L;
    /**
    * id
    */
    private Integer worktypeid;
    
    private String workname;


    public Integer getWorktypeid() {
        return worktypeid;
    }

    public void setWorktypeid(Integer worktypeid) {
        this.worktypeid = worktypeid;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

}