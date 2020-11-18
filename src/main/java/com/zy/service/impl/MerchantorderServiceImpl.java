package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Merchantorder;
import com.zy.dao.MerchantorderDao;
import com.zy.entity.Woktype;
import com.zy.service.MerchantorderService;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Merchantorder)表服务实现类
 *
 * @author makejava
 * @since 2020-10-28 15:14:04
 */
@Service("merchantorderService")
public class MerchantorderServiceImpl implements MerchantorderService {
    @Resource
    private MerchantorderDao merchantorderDao;


    @Override
    public List<Woktype> findWorkType() {
        List<Woktype> woktypes = merchantorderDao.allWorkType();
        return woktypes;
    }

    @Override
    public int applyMt(Merchantorder merchantorder) {
        return merchantorderDao.insert(merchantorder);
    }

    @Override
    public IPage<Map<String, Object>> repairIng(Integer pageNum, Integer pageSize,String id) {
        return merchantorderDao.repairIng(new Page<>(pageNum,pageSize),id);
    }

    @Override
    public List<Map<String, Object>> findMtById(String id) {
        return merchantorderDao.findMtById(id);
    }

    @Override
    public int updateRepairById(int repairid) {
        return merchantorderDao.updateRepairById(repairid);
    }

    @Override
    public int updateRepairByIdOk(int repairid) {
        return merchantorderDao.updateRepairByIdOk(repairid);
    }

    @Override
    public int updateMerchantOrderById(int workorderid, int repairid) {
        return merchantorderDao.updateMerchantOrderById(workorderid, repairid);
    }

    @Override
    public int updateMerchantOrderByIdRepair(int id) {
        return merchantorderDao.updateMerchantOrderByIdRepair(id);
    }

    @Override
    public int updateMerchantOrderByIdRepairOk(int id, String repairname) {
        return merchantorderDao.updateMerchantOrderByIdRepairOk(id,repairname);
    }
    @Override
    public int repairUpdateXsState(int repairid) {
        return merchantorderDao.repairUpdateXsState(repairid);
    }

    @Override
    public int mtorderXs(int repairid, int id) {

        return merchantorderDao.mtorderXs(repairid, id);
    }

    @Override
    public int orderByTime(String time) {
        return merchantorderDao.selByTime(time);
    }

    @Override
    public List<Map<String, Object>> selByType() {
        return merchantorderDao.selByType();
    }

    @Override
    public int countRwNum() {
        QueryWrapper<Merchantorder> wrapper = new QueryWrapper<>();
        wrapper.eq("workstate","1");
        return merchantorderDao.selectCount(wrapper);
    }

    @Override
    public int countOrderNum() {
        QueryWrapper<Merchantorder> wrapper = new QueryWrapper<>();
        wrapper.eq("workstate","0");
        return merchantorderDao.selectCount(wrapper);
    }

    @Override
    public int counthandling() {
        QueryWrapper<Merchantorder> wrapper = new QueryWrapper<>();
        wrapper.eq("state","3").or().eq("state","9");
        return merchantorderDao.selectCount(wrapper);
    }

    @Override
    public int countfinsihed() {
        QueryWrapper<Merchantorder> wrapper = new QueryWrapper<>();
        wrapper.eq("state","4");
        return merchantorderDao.selectCount(wrapper);
    }

    @Override
    public List<Map<String, Object>> repairQdFindState(int repairid) {
        return merchantorderDao.repairQdFindState(repairid);
    }

    @Override
    public List<Map<String, Object>> selTypeOfType(String shopId) {
        //途径订单
        List<Map<String, Object>> list = merchantorderDao.selCountMethodByShopId(shopId);
        List<Map<String, Object>> list2 = new ArrayList<>();
        list.forEach(i->{
            Map<String,Object> map = new HashMap<>();
            map.put(i.get("type").toString(),i.get("count"));
            map.put("数量","数量");
            list2.add(map);
        });
        return list2;
    }

    @Override
    public List<Map<String, Object>> selTypeOfType2(String shopId) {
        //途径订单
        List<Map<String, Object>> list = merchantorderDao.selCountTypeByShopId(shopId);
        List<Map<String, Object>> list2 = new ArrayList<>();
        list.forEach(i->{
            Map<String,Object> map = new HashMap<>();
            map.put(i.get("type2").toString(),i.get("count2"));
            map.put("数量","数量");
            list2.add(map);
        });
        return list2;
    }

    @Override
    public int shopSelByTime(String time, String id) {
        return merchantorderDao.shopSelByTime(time,id);
    }

    @Override
    public int repairSelByTime(String time, String id) {
        return merchantorderDao.repairSelByTime(time,id);
    }


}