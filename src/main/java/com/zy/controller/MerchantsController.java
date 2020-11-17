package com.zy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.common.utils.JSONResult;
import com.zy.common.utils.LayuiPageResult;
import com.zy.entity.Merchants;
import com.zy.entity.Repair;
import com.zy.service.MerchantsService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * (Merchants)表控制层
 *
 * @author makejava
 * @since 2020-10-20 10:01:50
 */
@Controller
@RequestMapping("merchants")
public class MerchantsController {
    /**
     * 服务对象
     */
    @Autowired
    private MerchantsService merchantsService;



    @ResponseBody
    @RequestMapping("/login")
    public JSONResult Login(@RequestBody Merchants merchants,HttpServletRequest request){
        Map<String, Object> login = merchantsService.login(merchants.getUsername(),merchants.getPwd());
        HttpSession session = request.getSession();
        if(!login.isEmpty()){
            session.setAttribute("login",login);
            return JSONResult.ok(login);

        }
            return JSONResult.errorMsg("账号或密码错误");


    }

    /**
     * 商户分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page" , method = RequestMethod.GET)
    public LayuiPageResult queryPage(@RequestParam("page")Integer page,
                                     @RequestParam("limit")Integer limit,
                                     @RequestParam("all") String all){
        IPage<Map<String, Object>> mapIPage = merchantsService.queryPage(page, limit, all);
        /**
         * @parm1 总条数
         * @parm2 List<Merchants> 数据
         */
        return new LayuiPageResult(mapIPage.getTotal(),mapIPage.getRecords());
    }

    /**
     * 增加商户
     * @param merchants
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public JSONResult queryPage(@RequestBody Merchants merchants){
        if(merchantsService.addMerchants(merchants)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    @ResponseBody
    @RequestMapping(value = "/checkTel.do", method = RequestMethod.GET)
    public JSONResult checkTel(@RequestParam("tel") String tel) {
        boolean b = merchantsService.checkTel(tel);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }

    @ResponseBody
    @RequestMapping(value = "/checkUsername.do", method = RequestMethod.GET)
    public JSONResult checkUsername(@RequestParam("username") String username) {
        boolean b = merchantsService.checkUsername(username);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }

    @ResponseBody
    @RequestMapping(value = "/checkUsernames.do", method = RequestMethod.GET)
    public JSONResult checkUsernames(@RequestParam("id") int id, @RequestParam("username") String username) {
        boolean b = merchantsService.checkUsernames(id, username);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }

    @ResponseBody
    @RequestMapping(value = "/checkTels.do", method = RequestMethod.GET)
    public JSONResult checkTels(@RequestParam("id") int id, @RequestParam("tel") String tel) {
        boolean b = merchantsService.checkTels(id, tel);
        if (b == true) {
            return JSONResult.ok(true);
        }
        return JSONResult.ok(false);
    }
    /**
     * 删除商户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    public JSONResult delete(@PathVariable("id") int id){
        if(merchantsService.deleteById(id)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }
    @ResponseBody
    @RequestMapping(value = "/findMtById.do/{id}", method = RequestMethod.POST)
    public List<Map<String, Object>> findMtById(@PathVariable("id") int id) {
        List<Map<String, Object>> mtById = merchantsService.findMtById(id);
        return mtById;
    }
    @ResponseBody
    @RequestMapping(value = "/updateMt.do", method = RequestMethod.POST)
    public JSONResult updateMt(@RequestBody Merchants merchants) {

        if (merchantsService.update(merchants)) {
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    @ResponseBody
    @RequestMapping(value = "/countNum", method = RequestMethod.POST)
    public int countNum() {
        return merchantsService.countNum();
    }
    @RequestMapping(value = "/cdFind.do/{id}",method = RequestMethod.POST)
    public JSONResult cdFind(@PathVariable("id") int id){
        //标记
        List<Map<String, Object>> maps = merchantsService.cdFind(id);
        if(maps.size()>0){
            int i1 = merchantsService.mtCdNoToRepair(id);
            if(i1 > 0){
                return JSONResult.ok();
            }else {
                return JSONResult.errorMsg("操作失败");
            }
        }else{
            int i2 = merchantsService.mtCdOk(id);
            if(i2>0){
                return JSONResult.ok();
            }else{
                return JSONResult.errorMsg("操作失败");
            }
        }
    }

    @RequestMapping(value = "/mtCdOk.do/{id}",method = RequestMethod.POST)
    public JSONResult mtCdOk(@PathVariable("id") int id){

        int i = merchantsService.mtCdOk(id);
        if(i>0){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("网络不佳,稍后重试");
    }
    @RequestMapping(value = "/mtToRepair.do/{id}",method = RequestMethod.POST)
    public JSONResult mtToRepair(@PathVariable("id") int id){

        int i = merchantsService.mtCdNoToRepair(id);
        if(i==0){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("网络不佳,稍后重试");
    }
}