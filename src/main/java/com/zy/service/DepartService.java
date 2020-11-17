package com.zy.service;

import com.zy.entity.Depart;
import java.util.List;

/**
 * (Depart)表服务接口
 *
 * @author makejava
 * @since 2020-10-22 10:43:41
 */
public interface DepartService {

    /**
     * 通过ID查询单条数据
     *
     * @param departid 主键
     * @return 实例对象
     */
    Depart queryById(Integer departid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Depart> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param depart 实例对象
     * @return 实例对象
     */
    Depart insert(Depart depart);

    /**
     * 修改数据
     *
     * @param depart 实例对象
     * @return 实例对象
     */
    Depart update(Depart depart);

    /**
     * 通过主键删除数据
     *
     * @param departid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer departid);

}