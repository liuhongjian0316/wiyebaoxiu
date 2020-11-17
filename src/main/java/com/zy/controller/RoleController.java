package com.zy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.zy.common.utils.JSONResult;
import com.zy.common.utils.LayuiPageResult;
import com.zy.entity.Merchants;
import com.zy.entity.Role;
import com.zy.entity.RoleMenu;
import com.zy.service.RoleMenuService;
import com.zy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-11-14 16:29:40
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page" , method = RequestMethod.GET)
    public LayuiPageResult queryPage(@RequestParam("page")Integer page,
                                     @RequestParam("limit")Integer limit){
        IPage<Role> roleIPage = roleService.queryPage(page,limit);
        /**
         * @parm1 总条数
         * @parm2 List<Merchants> 数据
         */
        return new LayuiPageResult(roleIPage.getTotal(),roleIPage.getRecords());
    }

    /**
     * 角色列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public List<Role> selList(){
        return roleService.allList();
    }


    /**
     * 添加角色
     * @param rolename
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public JSONResult addRole(@RequestParam("role") String rolename){
        Role role = new Role();
        role.setRolename(rolename);
        if(roleService.addRole(role)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del" , method = RequestMethod.GET)
    public JSONResult delRole(@RequestParam("id") Integer id){
        if(roleService.delRoleById(id)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    /**
     * 给角色添加菜单
     * @param roleMenu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addrm" , method = RequestMethod.POST)
    public JSONResult addRm(@RequestBody RoleMenu roleMenu){
        if(roleMenuService.add(roleMenu)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

    /**
     * 给角色删除菜单
     * @param roleid
     * @param menuid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delrm" , method = RequestMethod.GET)
    public JSONResult delRm(@RequestParam("roleid")String roleid,@RequestParam("menuid")String menuid){
        if(roleMenuService.delRm(roleid,menuid)){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败");
    }

}