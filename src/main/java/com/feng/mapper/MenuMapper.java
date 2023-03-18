package com.feng.mapper;

import com.feng.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * menu Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    @Update("update menu set staff_id = #{staffId},menu_state = 1 where menu_id = #{menu_id}")
    int dispatchStaff(@Param("menuId") String menuId,@Param("staffId") String staffId);

    @Update("update menu set menu_state = 1 where menu_id = #{menu_id}")
    int updateMenuGo(@Param("menu_id") String menuId);

    @Update("update menu set menu_state = 2 where menu_id = #{menu_id}")
    int updateMenuEnd(@Param("menu_id") String menuId);

    @Update("update menu set order_id = #{orderId} where menu_id = #{menu_id}")
    int bindOrder(@Param("menuID") String menuID, @Param("orderId") String orderId);

}
