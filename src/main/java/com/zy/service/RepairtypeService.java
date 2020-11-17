package com.zy.service;

import com.zy.entity.Repairtype;
import java.util.List;

/**
 * (Repairtype)表服务接口
 *
 * @author makejava
 * @since 2020-10-22 11:26:17
 */
public interface RepairtypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param repairtypeid 主键
     * @return 实例对象
     */
    Repairtype queryById(Integer repairtypeid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Repairtype> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param repairtype 实例对象
     * @return 实例对象
     */
    Repairtype insert(Repairtype repairtype);

    /**
     * 修改数据
     *
     * @param repairtype 实例对象
     * @return 实例对象
     */
    Repairtype update(Repairtype repairtype);

    /**
     * 通过主键删除数据
     *
     * @param repairtypeid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer repairtypeid);

}