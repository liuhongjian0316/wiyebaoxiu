package com.zy.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Manager;
import com.zy.entity.Woktype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (Manager)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-05 14:26:36
 */
public interface ManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param managerid 主键
     * @return 实例对象
     */
    Manager queryById(Integer managerid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Manager> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param manager 实例对象
     * @return 对象列表
     */
    List<Manager> queryAll(Manager manager);

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int insert(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param managerid 主键
     * @return 影响行数
     */
    int deleteById(Integer managerid);

    /**
     * 经理登录
     * @param username
     * @param pwd
     * @return
     */
    @Select("select * from manager where username = #{username} and pwd = #{pwd}")
    public Map<String,Object> findByUsernameAndPwd(@Param("username") String username,@Param("pwd") String pwd);

    /**
     * 待处理的订单
     * @param page
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE m.state = 1 " +
            "ORDER BY m.work_order_id DESC")
    public IPage<Map<String,Object>> pendIng(Page<Map<String,Object>> page);

    /**
     * 维修类型下拉框
     * @return
     */
    @Select("select * from woktype")
    public List<Woktype> allWorkType();


    @Select("select * from merchantorder where work_order_id = #{id}")
    public List<Map<String,Object>> findMtById(String id);

    @Select("SELECT r.*,rt.repairtypename,d.departname FROM repair r  " +
            "INNER JOIN repairtype rt ON r.typeid = rt.repairtypeid  " +
            "INNER JOIN depart d on r.departid = d.departid  " +
            "where r.state = 1")
    public IPage<Map<String,Object>> allRepair(IPage<Map<String,Object>> page);

}