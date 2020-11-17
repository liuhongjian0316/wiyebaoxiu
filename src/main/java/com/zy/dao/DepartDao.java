package com.zy.dao;

import com.zy.entity.Depart;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Depart)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 10:43:41
 */
public interface DepartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param departid 主键
     * @return 实例对象
     */
    Depart queryById(Integer departid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Depart> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param depart 实例对象
     * @return 对象列表
     */
    List<Depart> queryAll(Depart depart);

    /**
     * 新增数据
     *
     * @param depart 实例对象
     * @return 影响行数
     */
    int insert(Depart depart);

    /**
     * 修改数据
     *
     * @param depart 实例对象
     * @return 影响行数
     */
    int update(Depart depart);

    /**
     * 通过主键删除数据
     *
     * @param departid 主键
     * @return 影响行数
     */
    int deleteById(Integer departid);

}