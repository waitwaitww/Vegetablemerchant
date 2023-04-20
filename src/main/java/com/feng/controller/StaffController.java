package com.feng.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.pojo.Msg;
import com.feng.pojo.Staff;
import com.feng.service.StaffService;
import com.feng.util.jsonUtil;
import com.feng.view.pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SAAJResult;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //分页查询
    @RequestMapping(value = "/findStaffPage", produces = "application/json;charset=utf-8")
    public  IPage<Staff> findStaffPage(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize,
                                @RequestParam("staffName")String staffName){
        IPage<Staff> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.like("waiter_name",staffName);
        wrapper.orderByDesc("employment_date");
        IPage page1 = staffService.page(page, wrapper);
        return page1;
    }

    //分页查询
    @RequestMapping(value = "/findStaffPageforType", produces = "application/json;charset=utf-8")
    public  IPage<Staff> findStaffPageforType(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize,
                                       @RequestParam("staffName")String staffName,@RequestParam("workTypeId")String workTypeId){
        IPage<Staff> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("work_type_id",workTypeId).like("waiter_name",staffName);
        wrapper.orderByDesc("employment_date");
        IPage page1 = staffService.page(page, wrapper);
        return page1;

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
    public String statementAllStaff() throws Exception {
        List<pay> pays = staffService.queryAllPay();
        ExcelWriter writer = ExcelUtil.getWriter("c:/Users/杨/Desktop/桌面文件/毕设/Vegetablemerchant/export/test.xlsx");
        writer.addHeaderAlias("waiterName","员工姓名");
        writer.addHeaderAlias("orderQuantity","完成订单");
        writer.addHeaderAlias("complain","投诉");
        writer.addHeaderAlias("basePay","底薪");
        writer.addHeaderAlias("salary","总工资");

//        writer.write(pays,true);

//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
//        String fileName = URLEncoder.encode("薪资信息","UTF-8");
//        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

//        ServletOutputStream outputStream = response.getOutputStream();
//        writer.flush(outputStream,true);
//        outputStream.close();

        writer.merge(4,"员工薪资");
        writer.write(pays,true);
        writer.close();

        Msg msg = new Msg();
        int i = staffService.clearAllStaffOrder();
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/statementBatchStaff",produces = "application/json;charset=utf-8")
    public String statementBatchStaff(@RequestBody List<String > staffIds){
        Msg msg = new Msg();
        int i = 0;
        for (String staffId: staffIds) {
            staffService.clearStaffOrderById(staffId);
            i++;
        }
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/statementOneStaff",produces = "application/json;charset=utf-8")
    public String statementOneStaff(@RequestParam("waiterId")String staffId){
        Msg msg = new Msg();
        int i = staffService.clearStaffOrderById(staffId);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

//    @RequestMapping(value = "/findStaffPage",produces = "application/json;charset=utf-8")
//    public IPage<Staff> findStaffPage(@RequestParam("pageSize")int pageSize,
//                                @RequestParam("pageNum")int pageNum,
//                                @RequestParam("staffName")String waiterName){
//        IPage<Staff> page = new Page<>();
//        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
//        wrapper.like("waiter_name",waiterName);
//        IPage<Staff> staffIPage = staffService.page(page, wrapper);
//        return staffIPage;
//    }

    @RequestMapping(value = "/addStaff",produces = "application/json;charset=utf-8")
    public String addStaff(@RequestBody()Staff staff1){
        Staff staff = new Staff();

        staff.setBasePay(staff1.getBasePay());
        staff.setOrderQuantity(0);
        staff.setComplain(0);
        staff.setEmploymentDate(DateUtil.date());
        staff.setSex(staff1.getSex());
        staff.setStaffPwd("12345678");
        staff.setStaffTelephone(staff1.getStaffTelephone());
        staff.setWaiterName(staff1.getWaiterName());
        staff.setWorkTypeId(staff1.getWorkTypeId());
        staff.setStaffId(staff.getStaffTelephone());

        Msg msg = new Msg();
        int i = staffService.addStaff(staff);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/updateStaff",produces = "application/json;charset=utf-8")
    public String updateStaff(@RequestBody()Staff staff1){
        Staff staff = new Staff();

        staff.setBasePay(staff1.getBasePay());
        staff.setOrderQuantity(0);
        staff.setComplain(0);
        staff.setEmploymentDate(DateUtil.date());
        staff.setSex(staff1.getSex());
        staff.setStaffPwd("12345678");
        staff.setStaffTelephone(staff1.getStaffTelephone());
        staff.setWaiterName(staff1.getWaiterName());
        staff.setWorkTypeId(staff1.getWorkTypeId());
        staff.setStaffId(staff.getStaffTelephone());

        Msg msg = new Msg();
        int i = staffService.updateStaff(staff);
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
    public String login(@RequestBody Map<String,Object> param){
        Msg msg = new Msg();
        String pwd = staffService.queryPwdById((String) param.get("staffId"));
        if (pwd != null && param.get("staffPwd").equals(pwd)){
            msg.setResult("登陆成功");
        }else {
            msg.setResult("用户名或密码错误！");
        }
        return jsonUtil.getJson(msg);
    }
}

