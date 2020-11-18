package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Depart;
import com.zy.entity.Merchants;
import com.zy.entity.Repair;
import com.zy.entity.Repairtype;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * (Repair)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-20 15:31:33
 */
public interface RepairDao extends BaseMapper<Repair> {


    /**
     * 维修员登录
     * @param username
     * @param pwd
     * @return
     */
    @Select("select * from repair where username = #{username} and pwd = #{pwd}")
    public Map<String,Object> loginByUsernameAndPwd(@Param("username") String username,@Param("pwd") String pwd);
    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from repair where repairid = #{id}")
    public int deleteByid(@Param("id") int id);

    /**
     * 查询维修员详细信息
     * @return
     */
    @Select("SELECT r.*,rt.repairtypename,d.departname FROM repair r " +
            "INNER JOIN repairtype rt ON r.typeid = rt.repairtypeid " +
            "INNER JOIN depart d on r.departid = d.departid " +
            "WHERE CONCAT(IFNULL(r.repairname,'')," +
            "IFNULL(r.tel,'')," +
            "IFNULL(r.sex,'')," +
            "IFNULL(d.departname,'')," +
            "IFNULL(rt.repairtypename,'')," +
            "IFNULL(r.username,'')," +
            "IFNULL(r.pwd,'')" +
            ") like '%${all}%' ORDER BY r.repairid DESC")
    public IPage<Map<String,Object>> Allrepair(Page<Map<String,Object>> page,@Param("all") String all);

    /**
     * 部门下拉框查询
     * @return
     */
    @Select("select * from depart")
    public List<Depart> findAllDepart();

    /**
     * 类型下拉框查询
     * @return
     */
    @Select("select * from repairtype")
    public List<Repairtype> findAllType();

    @Select("SELECT r.*,rt.repairtypename,d.departname FROM repair r " +
            "INNER JOIN repairtype rt ON r.typeid = rt.repairtypeid " +
            "INNER JOIN depart d on r.departid = d.departid " +
            "WHERE r.repairid= #{id}")
    public List<Map<String,Object>> findRepairById(@Param("id") int id);

    @Select("select count(*) from repair " +
            "where tel = #{tel} and repairid != #{id}")
    public int checkTels(@Param("id") int id,@Param("tel")String tel);

    @Select("select count(*) from repair " +
            "where username = #{username} and repairid != #{id}")
    public int checkUsernames(@Param("id")int id,@Param("username")String username);

    /**
     * 维修员查看普通订单
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE m.repairid = #{id} AND m.state = 2 ")
    public IPage<Map<String,Object>> repairDispatch(Page<Map<String,Object>> page,@Param("id") int id);

    /**
     * 维修员查看悬赏订单
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE m.workstate = 1 AND m.state = 8 ")
    public IPage<Map<String,Object>> repairDispatchXs(Page<Map<String,Object>> page);
    /**
     * 维修员正在维修订单
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE m.repairid = #{id} AND (m.state = 3 or m.state = 9) ")
    public IPage<Map<String,Object>> repairPending(Page<Map<String,Object>> page,@Param("id") int id);

    /**
     * 拒单
     * @param cause
     * @param id
     * @param repairname
     * @return
     */
    @Update("update merchantorder set worker = #{repairname}," +
            "cause=#{cause}," +
            "state = 5 " +
            "where work_order_id = #{id}")
    public int repairDispatchNo(@Param("cause") String cause,@Param("id") int id,@Param("repairname") String repairname);

    /**
     * 经理查看拒单维修员
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE  m.state = 5 ")
    public IPage<Map<String,Object>> repairNoJ(Page<Map<String,Object>> page);

    /**
     * 经理拒绝维修员拒单
     * @param id
     * @return
     */
    @Update("update merchantorder set state = 3 " +
            "where work_order_id = #{id}")
    public int jingliNo(@Param("id") int id);

    /**
     *
     * @param id
     * @param jname
     * @param fcause
     * @return
     */

    @Update("update merchantorder set charge_person = #{jname}," +
            "fault_cause=#{fcause}," +
            "state = 10 " +
            "where work_order_id = #{id}")
    public int jingliOk(@Param("id") int id,@Param("jname") String jname,@Param("fcause") String fcause);


    @Update("update repair set state = 1 " +
            "where repairid = #{repairid}")
    public int jingliOkUpdateRepairStateByid(@Param("repairid") int repairid);

    /**
     *维修员查看撤单申请
     * @param page
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE  m.state = 7" )
    public IPage<Map<String,Object>> repairFindCd(Page<Map<String,Object>> page);

    /**
     * 同意撤单更改状态流程结束
     * @param id
     * @return
     */
    @Update("update merchantorder set state = 11 " +
            "where work_order_id = #{id}")
    public int repairOkCd(@Param("id") int id);

    /**
     * 同意撤单后状态改为空闲
     * @param repairid
     * @return
     */
    @Update("update repair set state = 1 " +
            "where repairid = #{repairid}")
    public int updateRepairState(@Param("repairid") int repairid);

    /**
     * 查看该订单类型
     * @param id
     * @return
     */
   @Select("select * from merchantorder where work_order_id = #{id} and workstate = 1")
    public List<Map<String,Object>> findCdType(@Param("id") int id);

   @Update("update merchantorder set state = 3 " +
           "where work_order_id = #{id}")
   public int repairNoCd(@Param("id") int id);

    @Update("update merchantorder set state = 9 " +
            "where work_order_id = #{id}")
    public int repairNoCds(@Param("id") int id);


    /**
     * 管理员按类型统计维修员人数
     * @return
     */
    @Select("select rt.repairtypename as type, count(*) as count from repair r, repairtype rt where r.typeid = rt.repairtypeid GROUP BY r.typeid")
    List<Map<String,Object>> countByType();

    /**
     * 查看已结束订单
     * @param page
     * @return
     */
    @Select("SELECT m.*,w.workname FROM merchantorder m " +
            "INNER JOIN woktype w ON w.worktypeid = m.worktypeid " +
            "WHERE m.merchantid = #{merchantid} and (m.state = 4 or m.state = 10 or m.state = 11 or m.state = 12)" )
    public IPage<Map<String,Object>> allOKOrder(Page<Map<String,Object>> page,@Param("merchantid") int merchantid);

    /**
     * 管理员按性别统计维修员人数
     * @return
     */
    @Select("select if(r.sex=1 ,'男','女') as name,count(*) as value from repair r GROUP BY r.sex")
    List<Map<String,Object>> countBySex();

    /**
     * 查看是否已经评价过
     * @param id
     * @return
     */
    @Select("select content_evaluation from merchantorder " +
            "where work_order_id = #{id}")
    public List<Map<String,Object>> findEvaluation(@Param("id") int id);
    /**
     * 商户评价
     * @param id
     * @param reactspeed
     * @param professionlevel
     * @param serviceattitude
     * @return
     */
    @Update("update merchantorder set react_speed = #{reactspeed}," +
            "profession_level = #{professionlevel}," +
            "service_attitude = #{serviceattitude}," +
            "content_evaluation = #{contentevaluation}," +
            "state = 12 " +
            "where work_order_id = #{id}")
    public int mtEvaluate(@Param("id") int id,
                          @Param("reactspeed") String reactspeed,
                          @Param("professionlevel") String professionlevel,
                          @Param("serviceattitude") String serviceattitude,
                          @Param("contentevaluation") String contentevaluation);

}