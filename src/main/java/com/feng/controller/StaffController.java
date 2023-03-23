package com.feng.controller;


import cn.hutool.core.date.DateUtil;
import com.feng.pojo.Msg;
import com.feng.pojo.Staff;
import com.feng.service.StaffService;
import com.feng.util.jsonUtil;
import org.apache.naming.factory.MailSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * emp 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    @Qualifier("StaffServiceImpl")
    private StaffService staffService;

    @RequestMapping(value = "/queryAllStaff", produces = "application/json;charset=utf-8")
    public String queryAllStaff(){
        Msg msg = new Msg();
        List<Staff> staffList = staffService.queryAllStaff();
        msg.setResult(staffList);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/querySomeStaff",produces = "application/json;charset=utf-8")
    public String querySomeStaff(@RequestParam("waiterName")String waiterName){
        Msg msg = new Msg();
        List<Staff> staff = staffService.queryStafflike(waiterName);
        msg.setResult(staff);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/querySomeByType",produces = "application/json;charset=utf-8")
    public String querySomeByType(@RequestParam("workTypeId")String workTypeId){
        Msg msg = new Msg();
        List<Staff> staff = staffService.queryStaffByType(workTypeId);
        msg.setResult(staff);
        return jsonUtil.getJson(msg);
    }


    @RequestMapping(value = "/statementAllStaff",produces = "application/json;charset=utf-8")
    public String statementAllStaff(){
        Msg msg = new Msg();
        int i = staffService.clearAllStaffOrder();
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/statementOneStaff",produces = "application/json;charset=utf-8")
    public String statementOneStaff(@RequestParam("waiterId")String waiterId){
        Msg msg = new Msg();
        int i = staffService.clearStaffOrderById(waiterId);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/addStaff",produces = "application/json;charset=utf-8")
    public String addStaff(@RequestParam("staffTelephone")String staffTelephone,@RequestParam("basePay") float basePay,
                           @RequestParam("sex")String sex,@RequestParam("waiterName")String waiterName,
                           @RequestParam("workTypeId")String workTypeId,@RequestParam("staffPwd")String staffPwd){
        Staff staff = new Staff();

        staff.setBasePay(basePay);
        staff.setOrderQuantity(0);
        staff.setComplain(0);
        staff.setEmploymentDate(DateUtil.date());
        staff.setSex(sex);
        staff.setStaffPwd(staffPwd);
        staff.setStaffTelephone(staffTelephone);
        staff.setWaiterName(waiterName);
        staff.setWorkTypeId(workTypeId);
        staff.setStaffId(staff.getStaffTelephone());

        Msg msg = new Msg();
        int i = staffService.addStaff(staff);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/deleteStaff",produces = "application/json;charset=utf-8")
    public String deleteStaff(@RequestParam("staffId")String staffId){
        Msg msg = new Msg();
        int i = staffService.deleteStaff(staffId);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login(@RequestParam("staffId")String staffId,@RequestParam("staffPwd")String staffPwd){
        Msg msg = new Msg();
        String pwd = staffService.queryPwdById(staffId);
        if (staffPwd.equals(pwd)){
            msg.setResult("登陆成功");
        }else {
            msg.setResult("用户名或密码错误！");
        }
        return jsonUtil.getJson(msg);
    }
}

