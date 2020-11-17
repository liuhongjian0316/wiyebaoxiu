package com.zy.common.utils;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LayuiPageResult
 * @Description layui表格数据格式
 * @Author liuhongjian
 * @Date 2020/3/31 12:12
 * @Version 1.0
 **/
@Data
public class LayuiPageResult {

    private String code; //code
    private String msg; //msg
    private long count; //count
    private List<?> data; //每行显示的数据

    public LayuiPageResult() {
    }

    public LayuiPageResult(long count, List<?> data) {
        this.code = "0";
        this.msg = "";
        this.count = count;
        this.data = data;
    }


}
