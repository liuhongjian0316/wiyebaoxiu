package com.zy.controller;

import com.zy.entity.Woktype;
import com.zy.service.WoktypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Woktype)表控制层
 *
 * @author makejava
 * @since 2020-10-28 15:19:35
 */
@RestController
@RequestMapping("woktype")
public class WoktypeController {
    /**
     * 服务对象
     */
    @Resource
    private WoktypeService woktypeService;


}