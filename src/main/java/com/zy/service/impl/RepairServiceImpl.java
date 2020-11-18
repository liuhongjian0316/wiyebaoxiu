package com.zy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Depart;
import com.zy.entity.Merchantorder;
import com.zy.entity.Repair;
import com.zy.dao.RepairDao;
import com.zy.entity.Repairtype;
import com.zy.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Repair)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 15:31:33
 */
@Service("repairService")
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairDao repairDao;

    /**
     * 通过ID查询单条数据
     *
     * @param repairid 主键
     * @return 实例对象
     */
    @Override
    public Repair queryById(Integer repairid) {
        return this.repairDao.selectById(repairid);
    }



    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Repair insert(Repair repair) {
        this.repairDao.insert(repair);
        return repair;
    }

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(Repair repair) {
        UpdateWrapper<Repair> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(Repair::getRepairid,repair.getRepairid())
                .setEntity(repair);
        return this.repairDao.update(repair,wrapper)>0;
    }

    /**
     * 通过主键删除数据
     *
     * @param repairid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer repairid) {
        return this.repairDao.deleteById(repairid) > 0;
    }

    @Override
    public IPage<Map<String,Object>> allrepair(Integer pageNum,Integer pageSize,String all) {
        return repairDao.Allrepair(new Page<>(pageNum,pageSize),all);
    }

    @Override
    public List<Depart> findAlldepart() {
        List<Depart> allDepart = repairDao.findAllDepart();
        return allDepart;
    }

    @Override
    public List<Repairtype> findAlltype() {

        return repairDao.findAllType();
    }


    @Override
    public int insertRepair(Repair repair) {

        return this.repairDao.insert(repair);
    }

    @Override
    public int deleteByIdRepair(int id) {
        return repairDao.deleteByid(id);
    }

    @Override
    public List<Map<String, Object>> findRepairById(int id) {

        return repairDao.findRepairById(id);
    }


    @Override
    public boolean checkTel(String tel) {
        QueryWrapper<Repair> wrapper = new QueryWrapper<>();
        wrapper.eq("tel",tel);
        List<Repair> repairs = repairDao.selectList(wrapper);
        if (repairs.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        QueryWrapper<Repair> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        List<Repair> repairs = repairDao.selectList(wrapper);
        if (repairs.size()>0){
            return true;
        }
            return false;
    }

    @Override
    public boolean checkTels(int id, String tel) {

        int i = repairDao.checkTels(id,tel);
        if (i>0){
            return true;
        }
         return false;
    }

    @Override
    public boolean checkUsernames(int id, String username) {

        int i = repairDao.checkUsernames(id, username);
        if (i>0){
            return true;
        }
            return false;
    }

    @Override
    public Map<String, Object> login(String username, String pwd) {
        Map<String, Object> stringObjectMap = repairDao.loginByUsernameAndPwd(username, pwd);
        return stringObjectMap;
    }

    @Override
    public IPage<Map<String, Object>> repairDispatch(Integer pageNum, Integer pageSize,int id) {

        return repairDao.repairDispatch(new Page<>(pageNum,pageSize),id);
    }

    @Override
    public IPage<Map<String, Object>> repairDispatchXs(Integer pageNum, Integer pageSize) {
        return repairDao.repairDispatchXs(new Page<>(pageNum,pageSize));
    }


    @Override
    public IPage<Map<String, Object>> repairPending(Integer pageNum, Integer pageSize,int id) {
        return repairDao.repairPending(new Page<>(pageNum,pageSize),id);
    }

    @Override
    public int countNums() {
        QueryWrapper<Repair> wrapper = new QueryWrapper<>();
        return repairDao.selectCount(wrapper);
    }

    @Override
    public int countAlbleNums() {
        QueryWrapper<Repair> wrapper = new QueryWrapper<>();
        wrapper.eq("state","1");
        return repairDao.selectCount(wrapper);
    }

    @Override
    public int repairDispatchNo(String cause, int id, String repairname) {
        int i = repairDao.repairDispatchNo(cause, id, repairname);
        return i;
    }

    @Override
    public IPage<Map<String, Object>> repairNoJ(Integer pageNum, Integer pageSize) {
        return repairDao.repairNoJ(new Page<>(pageNum,pageSize));
    }

    @Override
    public int jingliNo(int id) {
        return repairDao.jingliNo(id);
    }

    @Override
    public int jingliOk(int id, String jname, String fcause) {
        return repairDao.jingliOk(id, jname, fcause);
    }

    @Override
    public int jingliOkUpdateRepairStateByid(int id) {
        return repairDao.jingliOkUpdateRepairStateByid(id);
    }

    @Override
    public List<Map<String, Object>> countByType() {
        return repairDao.countByType();
    }

    @Override
    public List<Map<String, Object>> countBySex() {
        return repairDao.countBySex();
    }

    @Override
    public IPage<Map<String, Object>> repairFindCd(Integer pageNum, Integer pageSize) {
        return repairDao.repairFindCd(new Page<>(pageNum,pageSize));
    }

    @Override
    public int repairOkCd(int id) {
        return repairDao.repairOkCd(id);
    }

    @Override
    public int updateRepairState(int repairid) {
        return repairDao.updateRepairState(repairid);
    }

    @Override
    public List<Map<String, Object>> findCdType(int id) {
        return repairDao.findCdType(id);
    }

    @Override
    public int repairNoCd(int id) {
        return repairDao.repairNoCd(id);
    }

    @Override
    public int repairNoCds(int id) {
        return repairDao.repairNoCds(id);
    }


}