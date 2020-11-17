package com.zy.service;

import com.zy.entity.Woktype;
import java.util.List;

/**
 * (Woktype)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 15:19:35
 */
public interface WoktypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param worktypeid 主键
     * @return 实例对象
     */
    Woktype queryById(Integer worktypeid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Woktype> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param woktype 实例对象
     * @return 实例对象
     */
    Woktype insert(Woktype woktype);

    /**
     * 修改数据
     *
     * @param woktype 实例对象
     * @return 实例对象
     */
    Woktype update(Woktype woktype);

    /**
     * 通过主键删除数据
     *
     * @param worktypeid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer worktypeid);

}