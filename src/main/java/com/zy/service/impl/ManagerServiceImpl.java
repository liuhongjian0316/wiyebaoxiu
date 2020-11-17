package com.zy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.entity.Manager;
import com.zy.dao.ManagerDao;
import com.zy.entity.Woktype;
import com.zy.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Manager)表服务实现类
 *
 * @author makejava
 * @since 2020-11-05 14:26:36
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerDao managerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param managerid 主键
     * @return 实例对象
     */
    @Override
    public Manager queryById(Integer managerid) {
        return this.managerDao.queryById(managerid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Manager> queryAllByLimit(int offset, int limit) {
        return this.managerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager insert(Manager manager) {
        this.managerDao.insert(manager);
        return manager;
    }

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager update(Manager manager) {
        this.managerDao.update(manager);
        return this.queryById(manager.getManagerid());
    }

    /**
     * 通过主键删除数据
     *
     * @param managerid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer managerid) {
        return this.managerDao.deleteById(managerid) > 0;
    }

    @Override
    public Map<String, Object> loginByUsernameAndPwd(String username, String pwd) {

        Map<String, Object> byUsernameAndPwd = managerDao.findByUsernameAndPwd(username, pwd);
        return byUsernameAndPwd;
    }
    @Override
    public IPage<Map<String, Object>> applicationPenIng(Integer pageNum, Integer pageSize) {
        return managerDao.pendIng(new Page<>(pageNum,pageSize));
    }

    @Override
    public List<Woktype> findWorkType() {
        List<Woktype> woktypes = managerDao.allWorkType();
        return woktypes;
    }
    @Override
    public List<Map<String, Object>> findMtById(String id) {
        return managerDao.findMtById(id);
    }

    @Override
    public IPage<Map<String, Object>> allPair(Integer pageNum, Integer pageSize) {
        IPage<Map<String, Object>> mapIPage = managerDao.allRepair(new Page<>(pageNum, pageSize));

        return mapIPage;
    }

}