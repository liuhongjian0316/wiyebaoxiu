package com.zy.service;

import com.zy.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2020-11-07 12:30:42
 */
public interface MenuService {

    /**
     * 根据角色id加载商户菜单
     * @param roleId
     * @return
     */
    List<Menu> loadMenuByRoleId(String roleId);

    /**
     * 查询所有的菜单
     * @return
     */
    List<Menu> selAll();

    /**
     * 增加菜单
     * @param menu
     * @return
     */
    Boolean insertMenu(Menu menu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    Boolean delMenu(Integer id);

    /**
     * 根据id 查询菜单详情
     * @param id
     * @return
     */
    Menu getById(Integer id);

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    Boolean updateMenu(Menu menu);

    /**
     * 根据角色id 查询菜单
     * @param id
     * @return
     */
    List<Menu> selByRoleId(String id);
}