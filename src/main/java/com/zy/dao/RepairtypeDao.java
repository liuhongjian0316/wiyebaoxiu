package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.entity.Repairtype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (Repairtype)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 11:26:16
 */
public interface RepairtypeDao extends BaseMapper<Repairtype> {

    /**
     * 管理员统计工种类型
     * @return
     */
    @Select("SELECT  repairtypename as name,count(*) as value  from repairtype GROUP BY repairtypename")
    List<Map<String,Object>> countByName();

}