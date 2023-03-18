package com.feng.mapper;

import com.feng.pojo.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * dish Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

    @Select("select * from dish where dish_id = (select dish_id from food_dish where food_id = #{foodId})")
    List<Dish> queryDishByFood(@Param("foodId") String foodId);

}
