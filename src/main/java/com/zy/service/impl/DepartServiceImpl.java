package com.zy.service.impl;

import com.zy.entity.Depart;
import com.zy.dao.DepartDao;
import com.zy.service.DepartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Depart)表服务实现类
 *
 * @author makejava
 * @since 2020-10-22 10:43:41
 */
@Service("departService")
public class DepartServiceImpl implements DepartService {
    @Resource
    private DepartDao departDao;

    /**
     * 通过ID查询单条数据
     *
     * @param departid 主键
     * @return 实例对象
     */
    @Override
    public Depart queryById(Integer departid) {
        return this.departDao.queryById(departid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Depart> queryAllByLimit(int offset, int limit) {
        return this.departDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param depart 实例对象
     * @return 实例对象
     */
    @Override
    public Depart insert(Depart depart) {
        this.departDao.insert(depart);
        return depart;
    }

    /**
     * 修改数据
     *
     * @param depart 实例对象
     * @return 实例对象
     */
    @Override
    public Depart update(Depart depart) {
        this.departDao.update(depart);
        return this.queryById(depart.getDepartid());
    }

    /**
     * 通过主键删除数据
     *
     * @param departid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer departid) {
        return this.departDao.deleteById(departid) > 0;
    }
}