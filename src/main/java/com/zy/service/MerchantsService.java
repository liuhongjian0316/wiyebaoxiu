package com.zy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.entity.Merchants;
import com.zy.entity.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Merchants)表服务接口
 *
 * @author makejava
 * @since 2020-10-20 10:01:48
 */
public interface MerchantsService {



    /**
     * 登录
     * @param username
     * @param pwd
     * @return
     */
    public Map<String,Object> login(String username,String pwd);

    /**
     * 商户分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<Map<String,Object>> queryPage(Integer pageNum,Integer pageSize,String all);

    /**
     * 增加商户
     * @param merchants
     * @return
     */
    Boolean addMerchants(Merchants merchants);

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

    /**
     * 根据id删除商户
     * @param id
     * @return
     */
    Boolean deleteById(int id);


    public boolean checkTels(int id,String tel);


    public boolean checkUsernames(int id,String username);

    /**
     * 根据id查询修改模态框赋值
     * @return
     */
    public List<Map<String,Object>> findMtById(int id);
    /**
     * 修改数据
     *
     * @param merchants 实例对象
     * @return 实例对象
     */
    Boolean update(Merchants merchants);

    /**
     * 商户总量
     * @return
     */
    int countNum();

    /**
     * 查询该订单是否被接
     * @param id
     * @return
     */
    public List<Map<String,Object>> cdFind( int id);


    /**
     * 直接撤单成功
     * @param id
     * @return
     */
    public int mtCdOk( int id);


    /**
     * 移置维修员
     * @param id
     * @return
     */
    public int mtCdNoToRepair( int id);
}