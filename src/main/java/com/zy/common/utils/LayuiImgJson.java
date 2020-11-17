package com.zy.common.utils;

public class LayuiImgJson {

    public int code;
    public String msg;
    public Object data;

    public LayuiImgJson(Object data) {
        this.code = 0;
        this.msg = "";
        this.data = data;
    }

    public LayuiImgJson() {
    }
}
