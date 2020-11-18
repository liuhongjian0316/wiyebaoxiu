package com.zy.service;

import com.zy.entity.Repairtype;
import java.util.List;
import java.util.Map;

/**
 * (Repairtype)表服务接口
 *
 * @author makejava
 * @since 2020-10-22 11:26:17
 */
public interface RepairtypeService {

    /**
     * 管理员统计工种类型
     * @return
     */
    List<Map<String,Object>> countByName();

    /**
     * 维修员列表
     * @return
     */
    List<Map<String,Object>> queryList();
}