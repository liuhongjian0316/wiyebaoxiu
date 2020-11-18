package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.entity.Woktype;
import com.zy.dao.WoktypeDao;
import com.zy.service.WoktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Woktype)表服务实现类
 *
 * @author makejava
 * @since 2020-10-28 15:19:35
 */
@Service("woktypeService")
public class WoktypeServiceImpl implements WoktypeService {
    @Autowired
    private WoktypeDao woktypeDao;


    @Override
    public List<Map<String, Object>> queryList() {
        QueryWrapper<Woktype> wrapper = new QueryWrapper<>();
        return woktypeDao.selectMaps(wrapper);
    }

    @Override
    public List<Map<String, Object>> countByName() {
        return woktypeDao.countByName();
    }
}