package com.zy.controller;

import com.zy.entity.Depart;
import com.zy.service.DepartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Depart)表控制层
 *
 * @author makejava
 * @since 2020-10-22 10:43:41
 */
@RestController
@RequestMapping("depart")
public class DepartController {
    /**
     * 服务对象
     */
    @Resource
    private DepartService departService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Depart selectOne(Integer id) {
        return this.departService.queryById(id);
    }

}