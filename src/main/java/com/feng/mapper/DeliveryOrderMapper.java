package com.feng.mapper;

import com.feng.pojo.DeliveryOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * order Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface DeliveryOrderMapper extends BaseMapper<DeliveryOrder> {

    @Select("select * from delivery_order where order_state = 1 and menu_id = (select menu_id from menu where consumer_id = #{consumerId} and order_id is Not Null)")
    List<DeliveryOrder> queryGoOrderByConsumerId(@Param("consumerId") String consumrId);

    @Select("select * from delivery_order where order_state = 0 and menu_id = (select menu_id from menu where consumer_id = #{consumerId} and order_id is Not Null)")
    List<DeliveryOrder> queryBeOrderByConsumerId(@Param("consumerId") String consumrId);

    @Select("select * from delivery_order where order_state = 2 and menu_id = (select menu_id from menu where consumer_id = #{consumerId} and order_id is Not Null)")
    List<DeliveryOrder> queryEndOrderByConsumerId(@Param("consumerId") String consumrId);

    @Select("select staff_id from delivery_order group by staff_id having count(staff_id) = (select min(mycount) from (select staff_id, count(staff_id) mycount from delivery_order where order_state = 1 group by staff_id) as a) limit 1")
    String findStaffIdByCount();

}
