package com.zy.controller;

import com.zy.common.utils.JSONResult;
import com.zy.entity.Merchants;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * session
 */
@RestController
public class SessionController {

    /**
     * 获取session
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping( value = "/getSession/{id}",method = RequestMethod.GET)
    public JSONResult getSession(HttpSession session){
        Merchants merchants = (Merchants)session.getAttribute("login");
        return JSONResult.ok(merchants);
    }
}
