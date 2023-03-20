package com.feng.controller;


import com.feng.pojo.Msg;
import com.feng.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String adminLogin(@RequestParam("adminId")String adminId,@RequestParam("adminPwd")String adminPwd){
        Msg msg = new Msg();
        msg.setResult("false");
        String pwd = systemAdminService.queryAdminPwdByAid(adminId);
        if(pwd.equals(adminPwd)){
            msg.setResult("true");
        }
        return msg.getResult().toString();
    }

}

