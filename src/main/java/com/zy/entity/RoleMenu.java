package com.zy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

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
    @TableId(value = "id",type = IdType.AUTO)
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