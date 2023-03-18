package com.feng.service;

import com.feng.pojo.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * emp 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface StaffService extends IService<Staff> {

    //判断员工是否存在
    int isStaffExistByid(String  staffId);

    //添加员工
    int addStaff(Staff staff);

    //删除员工
    int deleteStaff(String staffId);

    //修改员工信息
    int updateStaff(Staff staff);

    //查询所有员工
    List<Staff> queryAllStaff();

    //查询某一类员工
    List<Staff> queryStaffByType(String typeId);

    //根据姓名查询员工
    Staff queryStaffByName(String name);

    //根据部分姓名模糊查询员工
    List<Staff> queryStafflike(String name);

    //将全体员工单量清零
    int clearAllStaffOrder();

    //将某个员工的订单量清零
    int clearStaffOrderById(String staffId);

}