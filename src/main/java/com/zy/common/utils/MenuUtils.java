package com.zy.common.utils;

import com.zy.entity.Menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * 菜单处理工具
 */
public class MenuUtils {
    /**
     * 处理菜单
     * @param menuList
     * @return
     */
    public static List<Menu> buildTree(List<Menu> menuList) {
        Map<Integer, List<Menu>> zoneByParentIdMap = menuList.stream().collect(Collectors.groupingBy(Menu::getPid));
        menuList.forEach(menu->menu.subs = zoneByParentIdMap.get(menu.id));
        return menuList.stream().filter(v -> v.pid==0).collect(Collectors.toList());
    }
}



