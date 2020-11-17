package com.zy.entity;

import java.io.Serializable;

/**
 * (RoleMenu)实体类
 *
 * @author makejava
 * @since 2020-11-07 12:31:38
 */
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -90299432415416455L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 菜单id
    */
    private Integer menuId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

}