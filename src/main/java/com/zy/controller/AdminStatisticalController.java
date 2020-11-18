package com.zy.controller;

import com.zy.common.utils.LayuiPageResult;
import com.zy.entity.Woktype;
import com.zy.service.RepairService;
import com.zy.service.RepairtypeService;
import com.zy.service.WoktypeService;
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
    @Autowired
    private WoktypeService woktypeService;
    @Autowired
    private RepairtypeService repairtypeService;

    /**
     * 管理员统计 按类型统计维修员人数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repair/countByType",method = RequestMethod.GET )
    public List<Map<String,Object>> repairCountByType(){
        return repairService.countByType();
    }

    /**
     * 管理员统计 按性别统计维修员人数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repair/countBySex",method = RequestMethod.GET )
    public List<Map<String,Object>> repairCountBySex(){
        return repairService.countBySex();
    }

    /**
     * 管理员统计 工单类型（饼形统计图）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/workType/countNames",method = RequestMethod.GET )
    public List<Map<String,Object>> countNames(){
        return woktypeService.countByName();
    }

    /**
     * 管理员统计 工单类型数据表格
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/workType/list",method = RequestMethod.GET )
    public LayuiPageResult workTypeList(){
        return new LayuiPageResult(0,woktypeService.queryList());
    }

    /**
     * 管理员统计维修员类型名称
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repairType/countNames",method = RequestMethod.GET )
    public List<Map<String,Object>> countByRepairTypeNames(){
        return repairtypeService.countByName();
    }

    /**
     * 管理员 统计工种类型（数据表格）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repairType/list",method = RequestMethod.GET )
    public LayuiPageResult repairTypeList(){
        return new LayuiPageResult(0,repairtypeService.queryList());
    }
}
