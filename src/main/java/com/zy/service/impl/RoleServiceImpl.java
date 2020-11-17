package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Merchants;
import com.zy.entity.Role;
import com.zy.dao.RoleDao;
import com.zy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2020-11-14 16:29:40
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;


    @Override
    public IPage<Role> queryPage(Integer offset, Integer limit) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        return roleDao.selectPage(new Page<Role>(offset,limit),wrapper);
    }

    @Override
    public List<Role> allList() {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        return roleDao.selectList(wrapper);
    }

    @Override
    public boolean addRole(Role role) {
        return roleDao.insert(role)>0;
    }

    @Override
    public boolean delRoleById(Integer id) {
        UpdateWrapper<Role> wrapper = new UpdateWrapper<>();
        wrapper.eq("roleid",id);
        return roleDao.delete(wrapper)>0;
    }
}