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
 * 商户统计
 */
@RestController
@RequestMapping("shopStatistical")
public class ShopStatisticalController {

    @Autowired
    private MerchantorderService merchantorderService;

    /**
     * 商户统计各种订单类型
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/countTypeOfType",method = RequestMethod.GET)
    public List<Map<String,Object>> selTypeOfType(HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> login = (Map<String,Object>)session.getAttribute("login");
        return merchantorderService.selTypeOfType(login.get("merchantid").toString());
    }

    @ResponseBody
    @RequestMapping(value = "/countTypeOfType2",method = RequestMethod.GET)
    public List<Map<String,Object>> selTypeOfType2(HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> login = (Map<String,Object>)session.getAttribute("login");
        return merchantorderService.selTypeOfType2(login.get("merchantid").toString());
    }

    /**
     * 商户统计自己的订单
     * @param time
     * @return
     */
    /**
     * 商户统计 按时间统计
     * @param time
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shopCountByTime",method = RequestMethod.GET)
    public  List<Map<String,Object>> shopCountByTime(@RequestParam("time") String time,HttpServletRequest request){
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
            map.put("count",merchantorderService.shopSelByTime(intervalTimeList.get(i),login.get("merchantid").toString()));
            list.add(map);
        }
        return list;
    }




}
