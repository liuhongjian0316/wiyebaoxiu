package com.zy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Depart;
import com.zy.entity.Repair;
import com.zy.entity.Repairtype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * (Repair)表服务接口
 *
 * @author makejava
 * @since 2020-10-20 15:31:33
 */
public interface RepairService {

    /**
     * 通过ID查询单条数据
     *
     * @param repairid 主键
     * @return 实例对象
     */
    Repair queryById(Integer repairid);

    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Repair insert(Repair repair);

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Boolean update(Repair repair);

    /**
     * 通过主键删除数据
     *
     * @param repairid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer repairid);

    /**
     * 查看维修员详细信息
     * @return
     */
    public IPage<Map<String,Object>> allrepair(Integer pageNum,Integer pageSize,String all);

    /**
     * 下拉框查询部门
     * @return
     */
    public  List<Depart> findAlldepart();

    /**
     * 下拉框查询类型
     * @return
     */
    public List<Repairtype> findAlltype();

    /**
     * 添加
     * @param repair
     * @return
     */
    public int insertRepair(Repair repair);

    /**
     * 删除
     * @return
     */
    public int deleteByIdRepair(int id);

    /**
     * 根据id查询修改模态框赋值
     * @return
     */
    public List<Map<String,Object>> findRepairById(int id);

    /**
     * 查重 电话
     * @param tel
     * @return
     */
    public boolean checkTel(String tel);

    /**
     * 查重账号
     * @param username
     * @return
     */
    public boolean checkUsername(String username);


    public boolean checkTels(int id,String tel);


    public boolean checkUsernames(int id,String username);

    /**
     * 登录
     * @param username
     * @param pwd
     * @return
     */
    public Map<String,Object> login(String username,String pwd);

    /**
     * 维修员查看普通订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<Map<String,Object>> repairDispatch(Integer pageNum,Integer pageSize,int id);

    /**
     * 维修员查看悬赏订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<Map<String,Object>> repairDispatchXs(Integer pageNum,Integer pageSize);

    /**
     * 维修员正在维修订单订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<Map<String,Object>> repairPending(Integer pageNum,Integer pageSize,int id);

    /**
     * 统计维修员
     * @return
     */
    public int countNums();

    /**
     * 有效维修员
     * @return
     */
    public int countAlbleNums();

    /**
     * 拒单
     * @param cause
     * @param id
     * @param repairname
     * @return
     */
    public int repairDispatchNo(String cause,int id,String repairname);

    /**
     * 经理查看
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<Map<String,Object>> repairNoJ(Integer pageNum,Integer pageSize);

    /**
     * 经理拒绝维修员拒单
     * @param id
     * @return
     */
    public int jingliNo( int id);

    /**
     * 经理同意维修员拒单
     * @param id
     * @param jname
     * @param fcause
     * @return
     */
    public int jingliOk(int id,String jname,String fcause);

    /**
     * 经理同意拒单后更改维修员状态为空闲
     * @param id
     * @return
     */
    public int jingliOkUpdateRepairStateByid(int id);

    /**
     *维修员查看撤单申请
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<Map<String,Object>> repairFindCd(Integer pageNum,Integer pageSize);

    /**
     * 同意撤单更改状态流程结束
     * @param id
     * @return
     */
    public int repairOkCd(int id);

    /**
     * 同意撤单后状态改为空闲
     * @param repairid
     * @return
     */
    public int updateRepairState(int repairid);

    /**
     * 查看该订单类型
     * @param id
     * @return
     */
    public List<Map<String,Object>> findCdType( int id);

    public int repairNoCd(int id);


    public int repairNoCds(int id);
}