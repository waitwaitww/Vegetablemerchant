package com.feng;


import cn.hutool.core.date.DateUtil;
import com.feng.pojo.Food;
import com.feng.pojo.Staff;
import com.feng.service.FoodService;
import com.feng.service.StaffService;
import com.feng.service.SystemAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class VegetablemerchantApplicationTests {

    @Autowired
    @Qualifier("StaffServiceImpl")
    private StaffService staffService;

    @Test
    void contextLoads() {
        Staff staff = new Staff();

        staff.setBasePay((float) 2000.00);
        staff.setOrderQuantity(0);
        staff.setComplain(0);
        staff.setEmploymentDate(DateUtil.date());
        staff.setSex("男");
        staff.setStaffPwd("33213fa");
        staff.setStaffTelephone("15756565656");
        staff.setWaiterName("路人已");
        staff.setWorkTypeId("90003");
        staff.setStaffId(staff.getStaffTelephone());
        int i = staffService.addStaff(staff);
        System.out.println(i);
        List<Staff> staff1 = staffService.queryAllStaff();
        staff1.forEach(System.out::println);

    }



}
