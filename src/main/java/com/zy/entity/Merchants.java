package com.zy.entity;

import java.io.Serializable;

/**
 * (Merchants)实体类
 *
 * @author makejava
 * @since 2020-11-02 14:29:14
 */
public class Merchants implements Serializable {
    private static final long serialVersionUID = 790399481191152778L;
    /**
    * 商户id
    */
    private Integer merchantid;
    /**
    * 商户名称
    */
    private String merchantname;
    /**
    * 电话
    */
    private String tel;
    /**
    * 商户位置
    */
    private String position;
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
    /**
    * 姓名
    */
    private String mtname;


    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getMtname() {
        return mtname;
    }

    public void setMtname(String mtname) {
        this.mtname = mtname;
    }

}