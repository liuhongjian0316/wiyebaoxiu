package com.zy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.common.utils.JSONResult;
import com.zy.common.utils.LayuiPageResult;
import com.zy.entity.Depart;
import com.zy.entity.Merchantorder;
import com.zy.entity.Repair;
import com.zy.entity.Repairtype;
import com.zy.service.RepairService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * (Repair)表控制层
 *
 * @author makejava
 * @since 2020-10-20 15:31:33
 */
@RestController
@RequestMapping("repair")
public class RepairController {
    /**
     * 服务对象
     */
    @Resource
    private RepairService repairService;


    /**
     * 查询维修员分页
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectallrepair", method = RequestMethod.POST)
    public LayuiPageResult selectallrepair(@RequestParam("page") Integer page,
                                           @RequestParam("limit") Integer limit,
                                           @RequestParam("all") String all) {

        IPage<Map<String, Object>> allrepair = repairService.allrepair(page, limit, all);
        return new LayuiPageResult(allrepair.getTotal(), allrepair.getRecords());


    }

    @ResponseBody
    @RequestMapping(value = "/insertAllRepair.do", method = RequestMethod.POST)
    public JSONResult insertAllRepair(@RequestBody Repair repair) {
        repair.setState("1");
        if (repairService.insertRepair(repair) > 0) {
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }


    @RequestMapping(value = "/alldepart.do", method = RequestMethod.POST)
    public List<Depart> allDepart() {
        return repairService.findAlldepart();
    }

    @RequestMapping(value = "/alltype.do", method = RequestMethod.POST)
    public List<Repairtype> alltype() {
        return repairService.findAlltype();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRepair/{id}")
    public JSONResult deleteRepair(@PathVariable("id") int id) {

        if (repairService.deleteByIdRepair(id) > 0) {
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    @ResponseBody
    @RequestMapping(value = "/findRepairByid.do/{id}", method = RequestMethod.POST)
    public List<Map<String, Object>> findRepairByid(@PathVariable("id") int id) {
        List<Map<String, Object>> repairById = repairService.findRepairById(id);
        return repairById;
    }

    @ResponseBody
    @RequestMapping(value = "/checkTel.do", method = RequestMethod.GET)
    public JSONResult checkTel(@RequestParam("tel") String tel) {
        boolean b = repairService.checkTel(tel);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }

    @ResponseBody
    @RequestMapping(value = "/checkUsername.do", method = RequestMethod.GET)
    public JSONResult checkUsername(@RequestParam("username") String username) {
        boolean b = repairService.checkUsername(username);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }

    @ResponseBody
    @RequestMapping(value = "/checkUsernames.do", method = RequestMethod.GET)
    public JSONResult checkUsernames(@RequestParam("id") int id, @RequestParam("username") String username) {
        boolean b = repairService.checkUsernames(id, username);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }

    @ResponseBody
    @RequestMapping(value = "/checkTels.do", method = RequestMethod.GET)
    public JSONResult checkTels(@RequestParam("id") int id, @RequestParam("tel") String tel) {
        boolean b = repairService.checkTels(id, tel);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAllRepair.do", method = RequestMethod.POST)
    public JSONResult updateAllRepair(@RequestBody Repair repair) {

        if (repairService.update(repair)) {
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    @ResponseBody
    @RequestMapping(value = "/loginByUsernameAndPwd.do", method = RequestMethod.POST)
    public JSONResult loginByUsernameAndPwd(@RequestBody Repair repair, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, Object> login = repairService.login(repair.getUsername(), repair.getPwd());

        if (!login.isEmpty()) {
            session.setAttribute("login", login);
            return JSONResult.ok(login);
        }
        return JSONResult.errorMsg("账号或密码错误");
    }

    /**
     * 维修员查看订单
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repairDispatch.do", method = RequestMethod.POST)
    public LayuiPageResult repairDispatch(@RequestParam("page") Integer page,
                                          @RequestParam("limit") Integer limit,
                                          HttpServletRequest request) {
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String id = login.get("repairid").toString();
        IPage<Map<String, Object>> mapIPage = repairService.repairDispatch(page,limit,Integer.valueOf(id));
        return new LayuiPageResult(mapIPage.getTotal(), mapIPage.getRecords());

    }
    /**
     * 维修员正在维修
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repairPending.do", method = RequestMethod.POST)
    public LayuiPageResult repairPending(@RequestParam("page") Integer page,
                                          @RequestParam("limit") Integer limit,
                                         HttpServletRequest request) {
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String id = login.get("repairid").toString();
        IPage<Map<String, Object>> mapIPage = repairService.repairPending(page,limit,Integer.valueOf(id));
        return new LayuiPageResult(mapIPage.getTotal(), mapIPage.getRecords());

    }
    /**
     * 维修员查看悬赏订单
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repairFindXs.do", method = RequestMethod.POST)
    public LayuiPageResult repairFindXs(@RequestParam("page") Integer page,
                                         @RequestParam("limit") Integer limit) {


        IPage<Map<String, Object>> mapIPage = repairService.repairDispatchXs(page, limit);
        return new LayuiPageResult(mapIPage.getTotal(), mapIPage.getRecords());

    }


    @ResponseBody
    @RequestMapping(value = "/countNum", method = RequestMethod.POST)
    public int countNum() {
        return  repairService.countNums();

    }

    @ResponseBody
    @RequestMapping(value = "/countAlbleNums", method = RequestMethod.POST)
    public int countAlbleNums() {
        return  repairService.countAlbleNums();

    }
    @RequestMapping(value = "/repairNo.do/{id}" ,method = RequestMethod.POST)
    public JSONResult repairNo(@RequestBody Merchantorder merchantorder,
                               @PathVariable("id") int id,
                               HttpServletRequest request){
        System.err.println(id);
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String repairname = login.get("repairname").toString();
        int i = repairService.repairDispatchNo(merchantorder.getCause(), id, repairname);
        if (i>0){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("网络不佳,请稍后重试");
    }
    @RequestMapping(value = "/repairNoJ.do",method = RequestMethod.POST)
    public LayuiPageResult repairNoJ(@RequestParam("page") Integer page,
                                @RequestParam("limit") Integer limit){
        IPage<Map<String, Object>> mapIPage = repairService.repairNoJ(page, limit);

        return new LayuiPageResult(mapIPage.getTotal(), mapIPage.getRecords());
    }
    @RequestMapping(value = "/jingliOk.do/{id}/{repairid}" ,method = RequestMethod.POST)
    public JSONResult jingliOk(@RequestBody Merchantorder merchantorder,
                               @PathVariable("id") int id,
                               @PathVariable("repairid") int repairid,
                               HttpServletRequest request){
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String jname = login.get("managername").toString();
        int i = repairService.jingliOk(id, jname, merchantorder.getFaultCause());
        int i1 = repairService.jingliOkUpdateRepairStateByid(repairid);
        if (i>0 && i1>0){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("网络不佳,请稍后重试");
    }
    @RequestMapping(value = "/jingliNo.do/{id}",method = RequestMethod.POST)
    public JSONResult jingliNo(@PathVariable("id") int id){
        int i = repairService.jingliNo(id);
        if(i>0){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("网络不佳请稍后重试");
    }

    @ResponseBody
    @RequestMapping(value = "/repairFindCd.do", method = RequestMethod.POST)
    public LayuiPageResult repairFindCd(@RequestParam("page") Integer page,
                                        @RequestParam("limit") Integer limit) {


        IPage<Map<String, Object>> mapIPage = repairService.repairFindCd(page, limit);
        return new LayuiPageResult(mapIPage.getTotal(), mapIPage.getRecords());

    }

    @ResponseBody
    @RequestMapping(value = "/repairCdOk.do/{id}",method = RequestMethod.POST)
    public JSONResult repairCdOk(@PathVariable("id") int id,HttpServletRequest request){
        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String repairid = login.get("repairid").toString();

        int i = repairService.repairOkCd(id);
        int i1 = repairService.updateRepairState(Integer.valueOf(repairid));
        if(i>0 && i1>0){
            return JSONResult.ok();
        }
            return JSONResult.errorMsg("网络不佳,请稍后重试");
    }

    @ResponseBody
    @RequestMapping(value = "/findCdType.do/{id}",method = RequestMethod.POST)
    public JSONResult findCdType(@PathVariable("id") int id,HttpServletRequest request){

        List<Map<String, Object>> cdType = repairService.findCdType(id);

        if(cdType.size()>0){
            int i = repairService.repairNoCds(id);
            if (i>0){
                return JSONResult.ok();
            }
        }else{
            int i1 = repairService.repairNoCd(id);
            if(i1>0){
                return JSONResult.ok();
            }
        }
        return JSONResult.errorMsg("网络不佳,请稍后重试");
    }
    @ResponseBody
    @RequestMapping(value = "/allOKOrder.do", method = RequestMethod.POST)
    public LayuiPageResult allOKOrder(@RequestParam("page") Integer page,
                                        @RequestParam("limit") Integer limit,
                                      HttpServletRequest request) {

        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String merchantid = login.get("merchantid").toString();

        IPage<Map<String, Object>> mapIPage = repairService.allOKOrder(page, limit,Integer.valueOf(merchantid));
        return new LayuiPageResult(mapIPage.getTotal(), mapIPage.getRecords());

    }
}