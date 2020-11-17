package com.zy.controller;

import com.zy.entity.Merchants;
import com.zy.service.MerchantsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Merchants)表控制层
 *
 * @author makejava
 * @since 2020-10-20 10:01:50
 */
@Controller
public class BackController {

    @RequestMapping(value= "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value= "/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value= "/merchant/allmerchant")
    public String allmerchant(){
        return "/merchant/allmerchant";
    }


    @RequestMapping(value= "/repair/AllRepair")
    public String AllRepair(){
        return "/repair/AllRepair";
    }

    @RequestMapping(value= "/merchant/MTmaintenance")
    public String MTmaintenance(){
        return "/merchant/MTmaintenance";
    }

    @RequestMapping(value= "/merchant/Repairing")
    public String Repairing(){
        return "/merchant/Repairing";
    }

    @RequestMapping(value= "/repair/loginRp")
    public String loginRp(){
        return "/repair/loginRp";
    }

    @RequestMapping(value= "/jingli/loginMn")
    public String jingli(){
        return "/jingli/loginMn";
    }

    @RequestMapping(value= "/jingli/ApplicationPending")
    public String ApplicationPending(){
        return "/jingli/ApplicationPending";
    }

    @RequestMapping(value= "/indexjingli")
    public String indexjingli(){
        return "indexjingli";
    }

    @RequestMapping(value= "/indexRp")
    public String indexRp(){
        return "indexRp";
    }

    @RequestMapping(value= "/repair/repairDispatch")
    public String repairDispatch(){
        return "/repair/repairDispatch";
    }

    @RequestMapping(value= "/repair/repairPending")
    public String repairPending(){
        return "/repair/repairPending";
    }

    @RequestMapping(value= "/merchant/MTXmaintenance")
    public String MTXmaintenance(){
        return "/merchant/MTXmaintenance";
    }

    @RequestMapping(value= "/repair/RewardOrder")
    public String RewardOrder(){
        return "/repair/RewardOrder";
    }


    @RequestMapping(value= "/indexAdmin")
    public String indexAdmin(){
        return "/indexAdmin";
    }

    @RequestMapping(value= "/superadmin/loginAd")
    public String adminLogin(){
        return "/superadmin/loginAd";
    }

    @RequestMapping(value= "/superadmin/role-menu")
    public String roleMenu(){
        return "/superadmin/role-menu";
    }

    @RequestMapping(value= "/superadmin/addpermissions")
    public String addpermissions(){
        return "/superadmin/addpermissions";
    }


    @RequestMapping(value= "/superadmin/console")
    public String superadminconsole(){
        return "/superadmin/console";
    }


    @RequestMapping(value= "/jingli/RepairNoFind")
    public String RepairNoFind(){
        return "/jingli/RepairNoFind";
    }

    @RequestMapping(value= "/repair/XsorderNo")
    public String XsorderNo(){
        return "/repair/XsorderNo";
    }
}