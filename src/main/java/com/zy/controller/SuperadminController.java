package com.zy.controller;

import com.zy.common.utils.JSONResult;
import com.zy.entity.Superadmin;
import com.zy.service.SuperadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * (Superadmin)表控制层
 *
 * @author makejava
 * @since 2020-11-14 13:26:01
 */
@RestController
@RequestMapping("superadmin")
public class SuperadminController {
    /**
     * 服务对象
     */
    @Autowired
    private SuperadminService superadminService;

    @RequestMapping(value = "/loginAdmins.do",method = RequestMethod.POST)
    public JSONResult loginAdmins(@RequestBody Superadmin superadmin, HttpServletRequest request){
        HttpSession session = request.getSession();

        Map<String, Object> login = superadminService.login(superadmin.getUsername(),superadmin.getPwd());
        System.err.println(login);
        if(!login.isEmpty()){
            session.setAttribute("login",login);
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("账号或者密码错误");
    }

}