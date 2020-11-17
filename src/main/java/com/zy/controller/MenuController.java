package com.zy.controller;

import com.github.qcloudsms.httpclient.HTTPRequest;
import com.zy.common.utils.JSONResult;
import com.zy.common.utils.TreeData;
import com.zy.entity.Menu;
import com.zy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2020-11-07 12:30:42
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Autowired
    private MenuService menuService;

    /**
     * 加载菜单
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loadMenu",method = RequestMethod.GET)
    public List<Menu> loadMenu(HttpServletRequest request){

        //获取session
        HttpSession session   =   request.getSession();
        Map<String, Object> login = (Map<String, Object>)session.getAttribute("login");
        String id = login.get("roleid").toString();


        return menuService.loadMenuByRoleId(id) ;
    }

    /**
     * 加载全部菜单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public TreeData selAll(){
        return new TreeData(0,"", menuService.selAll());
    }

    @ResponseBody
    @RequestMapping(value = "/alllist",method = RequestMethod.GET)
    public List<Menu> selAllList(){
        return menuService.selAll();
    }
    /**
     * 增加菜单
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JSONResult add(@RequestBody Menu menu){
        System.err.println(menu);
        if(menuService.insertMenu(menu)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public JSONResult delMneu(@PathVariable("id")Integer id){
        if(menuService.delMenu(id)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    /**
     * 根据id 查询菜单详情
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Menu getById(@PathVariable("id")Integer id){
       return menuService.getById(id);
    }


    /**
     * 更新菜单
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public JSONResult getById(@RequestBody Menu menu){
        if(menuService.updateMenu(menu)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    /**
     * 根据角色查询菜单
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public TreeData getMenuByRoelId(@PathVariable("id") String id){
        return new TreeData(0,"", menuService.loadMenuByRoleId(id));
    }


}