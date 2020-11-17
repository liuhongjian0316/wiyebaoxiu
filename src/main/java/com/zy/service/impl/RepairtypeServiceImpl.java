package com.zy.service.impl;

import com.zy.entity.Repairtype;
import com.zy.dao.RepairtypeDao;
import com.zy.service.RepairtypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Repairtype)表服务实现类
 *
 * @author makejava
 * @since 2020-10-22 11:26:17
 */
@Service("repairtypeService")
public class RepairtypeServiceImpl implements RepairtypeService {
    @Resource
    private RepairtypeDao repairtypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param repairtypeid 主键
     * @return 实例对象
     */
    @Override
    public Repairtype queryById(Integer repairtypeid) {
        return this.repairtypeDao.queryById(repairtypeid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Repairtype> queryAllByLimit(int offset, int limit) {
        return this.repairtypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param repairtype 实例对象
     * @return 实例对象
     */
    @Override
    public Repairtype insert(Repairtype repairtype) {
        this.repairtypeDao.insert(repairtype);
        return repairtype;
    }

    /**
     * 修改数据
     *
     * @param repairtype 实例对象
     * @return 实例对象
     */
    @Override
    public Repairtype update(Repairtype repairtype) {
        this.repairtypeDao.update(repairtype);
        return this.queryById(repairtype.getRepairtypeid());
    }

    /**
     * 通过主键删除数据
     *
     * @param repairtypeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer repairtypeid) {
        return this.repairtypeDao.deleteById(repairtypeid) > 0;
    }
}