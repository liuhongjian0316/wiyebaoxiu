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

    IPage<Role> queryPage(Integer offset,Integer limit);

    List<Role> allList();

}