package com.zy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2020-11-07 12:30:42
 */
@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = -20358935329446841L;
    /**
    * 主键
    */
    @TableId(value = "id", type = IdType.AUTO)
    public Integer id;
    /**
    * 名称
    */
    public String name;
    /**
    * 路径
    */
    public String url;
    /**
    * 父id
    */
    public Integer pid;
    /**
    * 样式
    */
    public String icon;

    @TableField(exist = false)
    public List<Menu> subs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}