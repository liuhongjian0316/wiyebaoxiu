package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.entity.Woktype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (Woktype)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-28 15:19:35
 */
public interface WoktypeDao extends BaseMapper<Woktype> {

    /**
     * 管理员统计 根据工单类型统计
     * @return
     */
    @Select("SELECT workname as name , count(*) as value from woktype GROUP BY workname")
    List<Map<String,Object>> countByName();
}