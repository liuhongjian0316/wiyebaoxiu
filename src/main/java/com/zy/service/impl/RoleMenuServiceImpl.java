package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zy.entity.RoleMenu;
import com.zy.dao.RoleMenuDao;
import com.zy.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-11-07 12:31:38
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;


    @Override
    public boolean add(RoleMenu roleMenu) {
        return roleMenuDao.insert(roleMenu)>0;
    }

    @Override
    public boolean delRm(String roleid, String menuid) {
        UpdateWrapper<RoleMenu> wrapper = new UpdateWrapper<>();
        wrapper.eq("role_id",roleid).eq("menu_id",menuid);
        return roleMenuDao.delete(wrapper)>0;
    }
}