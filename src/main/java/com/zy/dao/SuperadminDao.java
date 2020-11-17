package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.entity.Superadmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (Superadmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-14 13:26:01
 */
public interface SuperadminDao extends BaseMapper<Superadmin> {


    @Select("select * from superadmin where username = #{username} and pwd = #{pwd} ")
    public Map<String,Object> login(@Param("username") String username ,@Param("pwd") String pwd);
}