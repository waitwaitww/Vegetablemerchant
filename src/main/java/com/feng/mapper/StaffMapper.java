package com.feng.mapper;

import com.feng.pojo.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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

    @Update("update `staff` set `order_quantity` = 0 where order_quantity != 0")
    int clearAllStaffOrder();

    @Update("update `staff` set `order_quantity` = 0 where staff_id = #{staffId}")
    int clearStaffOrderByid(@Param("staffId") String staffId);

}
