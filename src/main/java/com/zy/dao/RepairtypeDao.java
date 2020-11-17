package com.zy.dao;

import com.zy.entity.Repairtype;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Repairtype)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 11:26:16
 */
public interface RepairtypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param repairtypeid 主键
     * @return 实例对象
     */
    Repairtype queryById(Integer repairtypeid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Repairtype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param repairtype 实例对象
     * @return 对象列表
     */
    List<Repairtype> queryAll(Repairtype repairtype);

    /**
     * 新增数据
     *
     * @param repairtype 实例对象
     * @return 影响行数
     */
    int insert(Repairtype repairtype);

    /**
     * 修改数据
     *
     * @param repairtype 实例对象
     * @return 影响行数
     */
    int update(Repairtype repairtype);

    /**
     * 通过主键删除数据
     *
     * @param repairtypeid 主键
     * @return 影响行数
     */
    int deleteById(Integer repairtypeid);

}