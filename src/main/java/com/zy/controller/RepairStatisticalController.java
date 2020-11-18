package com.zy.controller;

import com.zy.common.utils.TiimeUtils;
import com.zy.service.MerchantorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 维修员统计
 */
@RestController
@RequestMapping(value = "repairStatistical")
public class RepairStatisticalController {

    @Autowired
    private MerchantorderService merchantorderService;

    /**
     * 维修员 统计自己的订单
     * @param time
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repairCountByTime",method = RequestMethod.GET)
    public List<Map<String,Object>> shopCountByTime(@RequestParam("time") String time, HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> login = (Map<String,Object>)session.getAttribute("login");
        String[] split = time.split(" ~ ");
        String[] s = split[0].split(" ");
        String[] s1 = split[1].split(" ");
        //开始时间 2020-09-08
        String startdate = s[0];
        //结束时间 2020-09-15
        String enddate = s1[0];
        //按照一天时间分割 2020-09-08  2020-09-09 .... 2020-09-15
        List<String> intervalTimeList = TiimeUtils.getIntervalTimeList(startdate, enddate, 1);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //逐条查询 加入list中
        int size = intervalTimeList.size();
        for (int i = 0; i <size ; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("time",intervalTimeList.get(i));
            map.put("count",merchantorderService.repairSelByTime(intervalTimeList.get(i),login.get("repairid").toString()));
            list.add(map);
        }
        return list;
    }

}
