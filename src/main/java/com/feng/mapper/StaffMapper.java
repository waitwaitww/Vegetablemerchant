package com.feng.mapper;

import com.feng.pojo.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.view.pay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * emp Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    @Update("update `staff` set `order_quantity` = 0 ,complain = 0 where order_quantity != 0")
    int clearAllStaffOrder();

    @Update("update `staff` set `order_quantity` = 0 ,complain = 0 where staff_id = #{staffId}")
    int clearStaffOrderByid(@Param("staffId") String staffId);

    @Select("select waiter_name , base_pay, order_quantity, complain from staff")
    List<pay> queryAllPay();
}
