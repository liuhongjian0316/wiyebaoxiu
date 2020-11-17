package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Merchants;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Merchants)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-20 10:01:46
 */
public interface MerchantsDao extends BaseMapper<Merchants> {



    /**
     * 登录用的查询
     * @param username
     * @param pwd
     * @return
     */
    @Select("select * from merchants where username = #{username} and pwd = #{pwd} ")
    public Map<String,Object> FindByUsernameAndPwd( @Param("username") String username,@Param("pwd")String pwd);

    /**
     * 全字段查询
     * @param page
     * @param all
     * @return
     */
    @Select("SELECT m.*,r.rolename from merchants m \n" +
            "INNER JOIN role r on r.roleid = m.roleid \n" +
            "WHERE CONCAT(IFNULL(m.merchantname,''),\n" +
            "IFNULL(m.mtname,''),\n" +
            "IFNULL(m.tel,''),\n" +
            "IFNULL(m.position,''),\n" +
            "IFNULL(r.rolename,''),\n" +
            "IFNULL(m.username,'')\n" +
            ") like '%${all}%' ORDER BY m.merchantid DESC")
    public IPage<Map<String,Object>> AllMt(Page<Map<String,Object>> page, @Param("all") String all);

    @Select("select count(*) from merchants " +
            "where tel = #{tel} and merchantid != #{id}")
    public int checkTels(@Param("id") int id,@Param("tel")String tel);

    @Select("select count(*) from merchants " +
            "where username = #{username} and merchantid != #{id}")
    public int checkUsernames(@Param("id")int id,@Param("username")String username);

    @Select("SELECT m.*,r.rolename from merchants m " +
            "INNER JOIN role r on r.roleid = m.roleid " +
            "WHERE m.merchantid= #{id}")
    public List<Map<String,Object>> findMtById(@Param("id") int id);

    /**
     * 商户撤单查询该订单状态
     * @return
     */
    @Select("select * from merchantorder " +
            "where work_order_id = #{id} and (state = 3 OR state = 9)")
    public List<Map<String,Object>> cdFind(@Param("id") int id);

    /**
     * 商户直接撤单成功
     * @param id
     * @return
     */
    @Update("update merchantorder set state = 11 " +
            "where work_order_id = #{id}")
    public int mtCdOk(@Param("id") int id);

    /**
     * 订单已被接单移置维修员
     * @param id
     * @return
     */
    @Update("update merchantorder set state = 7 " +
            "where work_order_id = #{id}")
    public int mtCdNoToRepair(@Param("id") int id);
}