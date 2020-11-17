package com.zy.controller;

import com.zy.entity.RoleMenu;
import com.zy.service.RoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-11-07 12:31:38
 */
@RestController
@RequestMapping("roleMenu")
public class RoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RoleMenu selectOne(Integer id) {
        return this.roleMenuService.queryById(id);
    }

}