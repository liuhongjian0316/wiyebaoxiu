package com.zy.service;

import com.zy.entity.RoleMenu;
import java.util.List;

/**
 * (RoleMenu)表服务接口
 *
 * @author makejava
 * @since 2020-11-07 12:31:38
 */
public interface RoleMenuService {

    /**
     * 角色添加菜单
     * @param roleMenu
     * @return
     */
    boolean add(RoleMenu roleMenu);

    /**
     * 角色删除菜单
     * @param roleid
     * @param menuid
     * @return
     */
    boolean delRm(String roleid,String menuid);

}