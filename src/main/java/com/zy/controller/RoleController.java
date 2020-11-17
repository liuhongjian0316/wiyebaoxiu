package com.zy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.zy.common.utils.LayuiPageResult;
import com.zy.entity.Merchants;
import com.zy.entity.Role;
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
    @ResponseBody
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public List<Role> selList(){
        return roleService.allList();
    }
}