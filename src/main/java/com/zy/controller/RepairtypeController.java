package com.zy.controller;

import com.zy.entity.Repairtype;
import com.zy.service.RepairtypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Repairtype)表控制层
 *
 * @author makejava
 * @since 2020-10-22 11:26:18
 */
@RestController
@RequestMapping("repairtype")
public class RepairtypeController {
    /**
     * 服务对象
     */
    @Resource
    private RepairtypeService repairtypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Repairtype selectOne(Integer id) {
        return this.repairtypeService.queryById(id);
    }

}