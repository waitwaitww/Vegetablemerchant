package com.feng;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.pojo.Food;
import com.feng.pojo.Staff;
import com.feng.pojo.WorkType;
import com.feng.service.*;
import com.feng.view.carDto;
import com.feng.view.foodDto;
import com.feng.view.menuDto;
import com.feng.view.pay;
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
        staff.setWaiterName("路人丙");
        staff.setWorkTypeId("90003");
        staff.setStaffId(staff.getStaffTelephone());
        int i = staffService.addStaff(staff);
        System.out.println(i);
        List<Staff> staff1 = staffService.queryAllStaff();
        staff1.forEach(System.out::println);

    }


    @Autowired
    @Qualifier("WorkTypeServiceImpl")
    private WorkTypeService workTypeService;

    @Test
    void test1(){
        WorkType workType = new WorkType();
        workType.setWorkTypeName("经理");
        workTypeService.addWorkType(workType);
        List<WorkType> workTypes = workTypeService.queryAllWorkType();
        workTypes.forEach(System.out::println);
    }


    @Test
    void test2(){
        List<pay> pays = staffService.queryAllPay();
        pays.forEach(System.out::println);
    }

    @Autowired
    @Qualifier("FoodServiceImpl")
    private FoodService foodService;
    @Autowired
    @Qualifier("FoodDtoServiceImpl")
    private FoodDtoService FoodDtoService;

    @Test
    void test3(){
        IPage<foodDto> page = new Page<>(0,2);
        QueryWrapper<foodDto> wrapper = new QueryWrapper<>();
        wrapper.like("food_name","");
        IPage page1 = FoodDtoService.page(page, wrapper);
        System.out.println(page1.toString());

    }

    @Autowired
    @Qualifier("MenuDtoServiceImpl")
    private MenuDtoService menuDtoService;

    @Test
    void test4(){
        List<menuDto> list = menuDtoService.list();
        list.forEach(System.out::println);
    }


    @Autowired
    @Qualifier("CarDtoServiceImpl")
    private CarDtoService carDtoService;

    @Test
    void test5(){
        List<carDto> list = carDtoService.list();
        list.forEach(System.out::println);
    }

}
