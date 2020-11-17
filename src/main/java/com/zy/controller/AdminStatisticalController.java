package com.zy.controller;

import com.zy.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "adminStatistical")
public class AdminStatisticalController {

    @Autowired
    private RepairService repairService;

    /**
     * 管理员统计 按类型统计维修员人数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repair/countByType",method = RequestMethod.GET )
    public List<Map<String,Object>> repairCountByType(){
        return repairService.countByType();
    }
}
