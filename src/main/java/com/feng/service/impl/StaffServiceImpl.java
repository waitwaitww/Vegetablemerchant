package com.feng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Staff;
import com.feng.mapper.StaffMapper;
import com.feng.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * emp 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("StaffServiceImpl")
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public int isStaffExistByid(String  staffId) {
        if(staffMapper.selectById(staffId) != null)
            return 1;
        return 0;
    }

    @Override
    public int addStaff(Staff staff) {
        if(isStaffExistByid(staff.getStaffId()) == 1)
            return 0;
        return staffMapper.insert(staff);
    }

    @Override
    public int deleteStaff(String staffId) {
        if(isStaffExistByid(staffId) == 1)
            return staffMapper.deleteById(staffId);
        return 0;
    }

    @Override
    public int updateStaff(Staff staff) {
        if(isStaffExistByid(staff.getStaffId()) == 1)
            return staffMapper.updateById(staff);
        return 0;
    }

    @Override
    public List<Staff> queryAllStaff() {
        return staffMapper.selectList(null);
    }

    @Override
    public List<Staff> queryStaffByType(String typeId) {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("work_type_id",typeId);
        return staffMapper.selectList(wrapper);
    }

    @Override
    public Staff queryStaffByName(String name) {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("waiter_name",name);
        return staffMapper.selectOne(wrapper);
    }

    @Override
    public List<Staff> queryStafflike(String name) {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.like("waiter_name",name);
        return staffMapper.selectList(wrapper);
    }

    @Override
    public int clearAllStaffOrder() {
        return staffMapper.clearAllStaffOrder();
    }

    @Override
    public int clearStaffOrderById(String staffId) {
        return staffMapper.clearStaffOrderByid(staffId);
    }
}
