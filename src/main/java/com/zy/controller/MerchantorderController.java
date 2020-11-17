package com.zy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.common.utils.JSONResult;
import com.zy.common.utils.LayuiPageResult;
import com.zy.common.utils.TiimeUtils;
import com.zy.entity.Merchantorder;
import com.zy.entity.Woktype;
import com.zy.service.MerchantorderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Merchantorder)表控制层
 *
 * @author makejava
 * @since 2020-10-28 15:14:04
 */
@RestController
@RequestMapping("merchantorder")
public class MerchantorderController {
    /**
     * 服务对象
     */
    @Resource
    private MerchantorderService merchantorderService;


    /**
     * 维修类型下拉框
     * @return
     */
    @RequestMapping(value = "/allWorktype.do",method = RequestMethod.POST)
    public List<Woktype> allWorktype(){
        List<Woktype> workType = merchantorderService.findWorkType();
        return workType;
    }

    /**
     * 维修申请普通
     * @param merchantorder
     * @return
     */
    @RequestMapping(value = "/applymt.do",method = RequestMethod.POST)
    public JSONResult applymt(@RequestBody Merchantorder merchantorder,HttpServletRequest request){
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String id = login.get("merchantid").toString();

        merchantorder.setMerchantid(Integer.valueOf(id));
        merchantorder.setState("1");
        merchantorder.setWorkstate("0");

        int i = merchantorderService.applyMt(merchantorder);
        if (i>0){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("提交失败,请重新提交!!!");
    }

    /**
     * 维修申请悬赏
     * @param merchantorder
     * @return
     */
    @RequestMapping(value = "/applymtx.do",method = RequestMethod.POST)
    public JSONResult applymtx(@RequestBody Merchantorder merchantorder,HttpServletRequest request){
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String id = login.get("merchantid").toString();

        merchantorder.setMerchantid(Integer.valueOf(id));
        merchantorder.setState("8");
        merchantorder.setWorkstate("1");

        int i = merchantorderService.applyMt(merchantorder);
        if (i>0){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("提交失败,请重新提交!!!");
    }

    /**
     * 查看已提交申请详细信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/repairIng.do",method = RequestMethod.POST)
    public LayuiPageResult repairIng(@RequestParam("page") Integer page,
                                     @RequestParam("limit") Integer limit,
                                     HttpServletRequest request){
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String id = login.get("merchantid").toString();


        IPage<Map<String, Object>> mapIPage = merchantorderService.repairIng(page,limit,id);
        return new LayuiPageResult(mapIPage.getTotal(),mapIPage.getRecords());
    }


    @RequestMapping(value = "/findMtByid.do/{id}",method = RequestMethod.POST)
    public List<Map<String,Object>> findMtByid(@PathVariable String id){
        List<Map<String, Object>> mtById = merchantorderService.findMtById(id);

        return mtById;
    }

    @RequestMapping(value = "/managerYes.do/{workorderid}/{repairid}",method = RequestMethod.POST)
    public JSONResult managerYes(@PathVariable int workorderid,@PathVariable int repairid){
        int i = merchantorderService.updateRepairById(repairid);
        int i1 = merchantorderService.updateMerchantOrderById(workorderid, repairid);
        if ( i>0 && i1>0){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("网络不佳,请稍后重试");
    }

    @RequestMapping(value = "/updateRepairState.do/{id}",method = RequestMethod.POST)
    public JSONResult updateRepairState(@PathVariable int id){
        int i = merchantorderService.updateMerchantOrderByIdRepair(id);
        if (i>0){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("网络不佳,请稍后重试");
    }

    /**
     * 结束订单
     * @param id
     * @param request
     * @return
     */

    @RequestMapping(value = "/updateMerchantOrderOk.do/{id}",method = RequestMethod.POST)
    public JSONResult updateMerchantOrderOk(@PathVariable int id,HttpServletRequest request){
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String repairname = login.get("repairname").toString();
        String repairid = login.get("repairid").toString();
        int i = merchantorderService.updateMerchantOrderByIdRepairOk(id, repairname);
        int i1 = merchantorderService.updateRepairByIdOk(Integer.valueOf(repairid));
        if (i>0 && i1>0 ){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("网络不佳,请稍后重试");
    }


    @RequestMapping(value = "/robOrder.do/{id}",method = RequestMethod.POST)
    public JSONResult robOrder(@PathVariable("id") int id,HttpServletRequest request){
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        Integer repairid = (Integer) login.get("repairid");
        if( merchantorderService.mtorderXs(repairid,id)>0 &&
                merchantorderService.repairUpdateXsState(repairid)>0){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("服务器故障,请联系管理员");
    }

    @RequestMapping(value = "/countByTime",method = RequestMethod.GET)
    public  List<Map<String,Object>> countByTime(@RequestParam("time") String time){
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
            map.put("count",merchantorderService.orderByTime(intervalTimeList.get(i)));
            list.add(map);
        }
        return list;
    }

    /**
     * 根据类型统计订单数量
     * @return
     */
    @RequestMapping(value = "/numOfBorrow",method = RequestMethod.GET)
    public  List<Map<String,Object>> numOfBorrow(){
        return merchantorderService.selByType();
    }


    @RequestMapping(value = "/countOrderNum",method = RequestMethod.POST)
    public int countOrderNum(){
        return merchantorderService.countOrderNum();
    }
    @RequestMapping(value = "/countRwNum",method = RequestMethod.POST)
    public int countRwNum(){
        return merchantorderService.countRwNum();
    }
    @RequestMapping(value = "/counthandling",method = RequestMethod.POST)
    public int counthandling(){
        return merchantorderService.counthandling();
    }
    @RequestMapping(value = "/countfinsihed",method = RequestMethod.POST)
    public int countfinsihed(){
        return merchantorderService.countfinsihed();
    }


}