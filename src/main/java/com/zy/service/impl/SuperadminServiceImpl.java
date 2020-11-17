package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.entity.Superadmin;
import com.zy.dao.SuperadminDao;
import com.zy.service.SuperadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Superadmin)表服务实现类
 *
 * @author makejava
 * @since 2020-11-14 13:26:01
 */
@Service("superadminService")
public class SuperadminServiceImpl implements SuperadminService {
    @Autowired
    private SuperadminDao superadminDao;


    @Override
    public Map<String, Object> login(String username, String pwd) {
        return superadminDao.login(username, pwd);
    }
}