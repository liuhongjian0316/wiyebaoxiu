package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Merchantorder;
import com.zy.entity.Woktype;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * (Merchantorder)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-28 15:14:04
 */
public interface MerchantorderDao extends BaseMapper<Merchantorder> {


    /**
     * 维修类型下拉框
     * @return
     */
    @Select("select * from woktype")
    public List<Woktype> allWorkType();


    /**
     * 已经提交的订单
     * @param page
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE  m.merchantid = #{id} and( m.state = 1 or m.state = 2 OR m.state = 3 or m.state = 8)   " +
            "ORDER BY m.work_order_id DESC")
    public IPage<Map<String,Object>> repairIng(Page<Map<String,Object>> page,@Param("id") String id);


    @Select("select * from merchantorder where work_order_id = #{id}")
    public List<Map<String,Object>> findMtById(String id);

    /**
     * 修改维修员状态为外出
     * @param repairid
     * @return
     */
    @Update("update repair set state = 0 " +
            "where repairid = #{repairid}")
    public int updateRepairById(@Param("repairid") int repairid);

    @Update("update merchantorder set repairid = #{repairid},state = 2 " +
            "where work_order_id = #{workorderid}")
    public int updateMerchantOrderById(@Param("workorderid") int workorderid,@Param("repairid") int repairid);

    @Update("update merchantorder set state  = 3 " +
            "where work_order_id = #{id}")
    public int updateMerchantOrderByIdRepair(@Param("id") int id);

    @Update("update merchantorder set worker = #{repairname},state = 4 " +
            "where work_order_id = #{id}")
    public int updateMerchantOrderByIdRepairOk(@Param("id") int id,@Param("repairname") String repairname);

    /**
     * 修改维修员状态为空闲
     * @param repairid
     * @return
     */
    @Update("update repair set state = 1 " +
            "where repairid = #{repairid}")
    public int updateRepairByIdOk(@Param("repairid") int repairid);

    /**
     * 悬赏订单抢单后修改维修员状态为外出
     * @return
     */
    @Update("update repair set state = 0 " +
            "where repairid = #{repairid}")
    public int repairUpdateXsState(@Param("repairid") int repairid);

    /**
     * 抢单成功后维修员信息插入该订单
     * @param repairid
     * @param id
     * @return
     */

    @Update("update merchantorder set repairid = #{repairid}," +
            "state = 9 " +
            "where work_order_id = #{id}")
    public int mtorderXs(@Param("repairid") int repairid,@Param("id") int id);

    /**
     * 根据时间查询订单
     * @param time
     * @return
     */
    @Select("select count(*) from merchantorder where DATE_FORMAT(reserve_time, '%Y-%m-%d') = #{time}")
    public int selByTime(@Param("time") String time);

    /**
     * 根据类型查询订单数量
     * @return
     */
    @Select("select workstate as type ,count(*) count from merchantorder GROUP BY workstate ")
    public List<Map<String,Object>> selByType();
}