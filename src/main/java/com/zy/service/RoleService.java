package com.zy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.entity.Role;
import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2020-11-14 16:29:40
 */
public interface RoleService {

    /**
     * 分页
     * @param offset
     * @param limit
     * @return
     */
    IPage<Role> queryPage(Integer offset,Integer limit);

    /**
     * 角色列表
     * @return
     */
    List<Role> allList();

    /**
     * 添加角色
     * @param role
     * @return
     */
    boolean addRole(Role role);

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    boolean delRoleById(Integer id);
}