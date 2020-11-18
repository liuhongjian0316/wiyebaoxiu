package com.zy.service;

import com.zy.entity.Woktype;
import java.util.List;
import java.util.Map;

/**
 * (Woktype)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 15:19:35
 */
public interface WoktypeService {

    /**
     * 查询列表（管理员统计）
     * @return
     */
    List<Map<String,Object>> queryList();

    /**
     * 管理员统计根据类型名称统计
     * @return
     */
    List<Map<String,Object>> countByName();




}