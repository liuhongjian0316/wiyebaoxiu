package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-07 12:30:42
 */
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 根据角色id加载菜单
     * @param roleId
     * @return
     */
    @Select("select m.* from menu m ,role_menu rm " +
            "where rm.role_id = #{roleId} and rm.menu_id =  m.id")
    List<Menu> loadMenuByRoleId(@Param("roleId") String roleId);
}