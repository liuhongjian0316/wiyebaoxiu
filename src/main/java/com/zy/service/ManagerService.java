package com.zy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.entity.Manager;
import com.zy.entity.Woktype;

import java.util.List;
import java.util.Map;

/**
 * (Manager)表服务接口
 *
 * @author makejava
 * @since 2020-11-05 14:26:36
 */
public interface ManagerService {

    /**
     * 通过ID查询单条数据
     *
     * @param managerid 主键
     * @return 实例对象
     */
    Manager queryById(Integer managerid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Manager> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Manager insert(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Manager update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param managerid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer managerid);

    /**
     * 经理登录
     * @param username
     * @param pwd
     * @return
     */
    public Map<String,Object> loginByUsernameAndPwd(String username,String pwd);

    /**
     * 查看待处理订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<Map<String,Object>> applicationPenIng(Integer pageNum, Integer pageSize);

    /**
     * 查询维修类型下拉框
     * @return
     */
    public List<Woktype> findWorkType();
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public List<Map<String,Object>> findMtById(String id);

    /**
     * 查看状态为空闲的维修员
     * @return
     */
    public IPage<Map<String,Object>> allPair(Integer pageNum, Integer pageSize);
}