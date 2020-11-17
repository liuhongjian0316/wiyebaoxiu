package com.zy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.common.utils.JSONResult;
import com.zy.common.utils.LayuiPageResult;
import com.zy.entity.Manager;
import com.zy.entity.Woktype;
import com.zy.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * (Manager)表控制层
 *
 * @author makejava
 * @since 2020-11-05 14:26:36
 */
@RestController
@RequestMapping("managerss")
public class ManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Manager selectOne(Integer id) {
        return this.managerService.queryById(id);
    }


    @ResponseBody
    @RequestMapping(value = "/loginByUAndP.do",method = RequestMethod.POST)
    public JSONResult loginByUAndP(@RequestBody Manager manager, HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String, Object> login = managerService.loginByUsernameAndPwd(manager.getUsername(), manager.getPwd());
        if (!login.isEmpty()){
            session.setAttribute("login",login);
            return JSONResult.ok(login);
        }
            return JSONResult.errorMsg("账号或者密码错误");
    }
    /**
     * 查看待处理订单详细信息
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/applicationIng.do",method = RequestMethod.POST)
    public LayuiPageResult applicationIng(@RequestParam("page") Integer page,
                                     @RequestParam("limit") Integer limit){

        IPage<Map<String, Object>> mapIPage = managerService.applicationPenIng(page, limit);
        return new LayuiPageResult(mapIPage.getTotal(),mapIPage.getRecords());
    }

    /**
     * 维修类型下拉框
     * @return
     */
    @RequestMapping(value = "/allWorktype.do",method = RequestMethod.POST)
    public List<Woktype> allWorktype(){
        List<Woktype> workType = managerService.findWorkType();
        return workType;
    }
    @ResponseBody
    @RequestMapping(value = "/findMtByid.do/{id}",method = RequestMethod.POST)
    public List<Map<String,Object>> findMtByid(@PathVariable String id){
        List<Map<String, Object>> mtById = managerService.findMtById(id);

        return mtById;

    }
    @ResponseBody
    @RequestMapping(value = "/allRpairState.do",method = RequestMethod.POST)
    public LayuiPageResult allRpairState(@RequestParam("page") Integer page,
                                         @RequestParam("limit") Integer limit){

        IPage<Map<String, Object>> mapIPage = managerService.allPair(page, limit);

        return new LayuiPageResult(mapIPage.getTotal(),mapIPage.getRecords());
    }
}