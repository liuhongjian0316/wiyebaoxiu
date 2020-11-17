package com.zy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.entity.Merchantorder;
import com.zy.entity.Woktype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Merchantorder)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 15:14:04
 */
public interface MerchantorderService {



    /**
     * 查询维修类型下拉框
     * @return
     */
    public List<Woktype> findWorkType();

    /**
     * 提交申请
     * @param merchantorder
     * @return
     */
    public int applyMt(Merchantorder merchantorder);
    /**
     * 查看申请后详细信息
     * @return
     */
    public IPage<Map<String,Object>> repairIng(Integer pageNum, Integer pageSize,String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public List<Map<String,Object>> findMtById(String id);


    /**
     * 更改派出维修员状态为外出
     * @param repairid
     * @return
     */
    public int updateRepairById(int repairid);
    /**
     * 更改派出维修员状态为空闲
     * @param repairid
     * @return
     */
    public int updateRepairByIdOk( int repairid);
    /**
     * 派遣维修员id插入订单表
     * @param workorderid
     * @param repairid
     * @return
     */
    public int updateMerchantOrderById(int workorderid,int repairid);

    /**
     * 维修员接单
     * @param id
     * @return
     */
    public int updateMerchantOrderByIdRepair(int id);

    /**
     * 维修订单完成
     * @param id
     * @param repairname
     * @return
     */
    public int updateMerchantOrderByIdRepairOk(int id,String repairname);

    /**
     * 抢单成功后维修员状态改为外出
     * @param repairid
     * @return
     */
    public int repairUpdateXsState(int repairid);

    /**
     * 抢单成功后维修员信息插入该订单
     * @param repairid
     * @param id
     * @return
     */
    public int mtorderXs(int repairid ,int id);

    /**
     * 根据时间查询订单
     * @param time
     * @return
     */
    public int orderByTime(String time);

    /**
     * 根据类型查询订单
     * @return
     */
    public List<Map<String,Object>> selByType();


    int countRwNum();
    int countOrderNum();
    int counthandling();
    int countfinsihed();

    /**
     * 抢单前查询维修员是否有其他订单
     * @param repairid
     * @return
     */
    public List<Map<String,Object>> repairQdFindState(int repairid);
}