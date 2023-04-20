package com.feng.controller;


import com.feng.pojo.Msg;
import com.feng.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * system_admin 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/system-admin")
public class SystemAdminController {

    @Autowired
    @Qualifier("SystemAdminServiceImpl")
    private SystemAdminService systemAdminService;

    @RequestMapping(value = "/login" ,produces = "application/json;charset=utf-8" )
    public String adminLogin(@RequestBody Map<String,Object> param){
        Msg msg = new Msg();
        msg.setResult("false");

        String pwd = systemAdminService.queryAdminPwdByAid((String) param.get("adminId"));
        if (pwd != null &&pwd.equals(param.get("adminPwd"))){
            msg.setResult("true");
        }
        return msg.getResult().toString();
    }

}

