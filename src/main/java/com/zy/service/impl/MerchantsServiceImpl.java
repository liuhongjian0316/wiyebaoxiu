package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Merchants;
import com.zy.dao.MerchantsDao;
import com.zy.entity.Repair;
import com.zy.service.MerchantsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Merchants)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 10:01:49
 */
@Service("merchantsService")
public class MerchantsServiceImpl implements MerchantsService {
    @Autowired
    private MerchantsDao merchantsDao;

    @Override
    public Map<String,Object> login(String username, String pwd) {
        QueryWrapper<Map<String,Object>> wrapper = new QueryWrapper<>();
//        wrapper.lambda().eq(Merchants::getUsername,username)
//                .eq(Merchants::getPwd,pwd);
//        wrapper.eq("username", username)
//                .eq("pwd", pwd);
        Map<String,Object> maps = merchantsDao.FindByUsernameAndPwd(username, pwd);
        return  maps;

    }

    @Override
    public IPage<Map<String,Object>> queryPage(Integer pageNum,Integer pageSize,String all) {

        return merchantsDao.AllMt(new Page<>(pageNum,pageSize),all);
    }

    @Override
    public Boolean addMerchants(Merchants merchants) {
        return merchantsDao.insert(merchants)>0;
    }

    @Override
    public boolean checkTel(String tel) {
        QueryWrapper<Merchants> wrapper = new QueryWrapper<>();
        wrapper.eq("tel",tel);
        List<Merchants> merchants = merchantsDao.selectList(wrapper);
        if (merchants.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        QueryWrapper<Merchants> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        List<Merchants> merchants = merchantsDao.selectList(wrapper);
        if (merchants.size()>0){
            return true;
        }
        return false;
    }
    @Override
    public boolean checkTels(int id, String tel) {

        int i = merchantsDao.checkTels(id,tel);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsernames(int id, String username) {

        int i = merchantsDao.checkUsernames(id, username);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(int id) {
        UpdateWrapper<Merchants> wrapper = new UpdateWrapper<>();
        wrapper.eq("merchantid",id);
        return merchantsDao.delete(wrapper)>0;
    }
    @Override
    public List<Map<String, Object>> findMtById(int id) {

        return merchantsDao.findMtById(id);
    }
    /**
     * 修改数据
     *
     * @param merchants 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(Merchants merchants) {
        UpdateWrapper<Merchants> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(Merchants::getMerchantid,merchants.getMerchantid())
                .setEntity(merchants);
        return this.merchantsDao.update(merchants,wrapper)>0;
    }

    @Override
    public int countNum() {
        QueryWrapper<Merchants> wrapper = new QueryWrapper<>();
        return merchantsDao.selectCount(wrapper);
    }

    @Override
    public List<Map<String,Object>> cdFind(int id) {
        return merchantsDao.cdFind(id);
    }

    @Override
    public int mtCdOk(int id) {
        return merchantsDao.mtCdOk(id);
    }

    @Override
    public int mtCdNoToRepair(int id) {
        return merchantsDao.mtCdNoToRepair(id);
    }

}