package com.zy.controller;

import com.zy.entity.RoleMenu;
import com.zy.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RoleMenuService roleMenuService;


}