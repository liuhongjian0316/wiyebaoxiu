package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.entity.Repairtype;
import com.zy.dao.RepairtypeDao;
import com.zy.service.RepairtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Repairtype)表服务实现类
 *
 * @author makejava
 * @since 2020-10-22 11:26:17
 */
@Service("repairtypeService")
public class RepairtypeServiceImpl implements RepairtypeService {
    @Autowired
    private RepairtypeDao repairtypeDao;

    @Override
    public List<Map<String, Object>> countByName() {
        return repairtypeDao.countByName();
    }

    @Override
    public List<Map<String, Object>> queryList() {
        QueryWrapper<Repairtype> wrapper = new QueryWrapper<>();
        return repairtypeDao.selectMaps(wrapper);
    }
}