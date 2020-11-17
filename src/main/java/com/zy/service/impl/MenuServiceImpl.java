package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.common.utils.MenuUtils;
import com.zy.entity.Menu;
import com.zy.dao.MenuDao;
import com.zy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2020-11-07 12:30:42
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> loadMenuByRoleId(String roleId) {
        return menuDao.loadMenuByRoleId(roleId);
    }

    @Override
    public List<Menu> selAll() {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        return menuDao.selectList(wrapper);
    }

    @Override
    public Boolean insertMenu(Menu menu) {
        return menuDao.insert(menu)>0;
    }

    @Override
    public Boolean delMenu(Integer id) {
        return menuDao.deleteById(id)>0;
    }

    @Override
    public Menu getById(Integer id) {
        return menuDao.selectById(id);
    }

    @Override
    public Boolean updateMenu(Menu menu) {
        return menuDao.updateById(menu)>0;
    }

    @Override
    public List<Menu> selByRoleId(String id) {
        return menuDao.loadMenuByRoleId(id);
    }
}