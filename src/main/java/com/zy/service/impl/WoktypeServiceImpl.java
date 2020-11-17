package com.zy.service.impl;

import com.zy.entity.Woktype;
import com.zy.dao.WoktypeDao;
import com.zy.service.WoktypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Woktype)表服务实现类
 *
 * @author makejava
 * @since 2020-10-28 15:19:35
 */
@Service("woktypeService")
public class WoktypeServiceImpl implements WoktypeService {
    @Resource
    private WoktypeDao woktypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param worktypeid 主键
     * @return 实例对象
     */
    @Override
    public Woktype queryById(Integer worktypeid) {
        return this.woktypeDao.queryById(worktypeid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Woktype> queryAllByLimit(int offset, int limit) {
        return this.woktypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param woktype 实例对象
     * @return 实例对象
     */
    @Override
    public Woktype insert(Woktype woktype) {
        this.woktypeDao.insert(woktype);
        return woktype;
    }

    /**
     * 修改数据
     *
     * @param woktype 实例对象
     * @return 实例对象
     */
    @Override
    public Woktype update(Woktype woktype) {
        this.woktypeDao.update(woktype);
        return this.queryById(woktype.getWorktypeid());
    }

    /**
     * 通过主键删除数据
     *
     * @param worktypeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer worktypeid) {
        return this.woktypeDao.deleteById(worktypeid) > 0;
    }
}