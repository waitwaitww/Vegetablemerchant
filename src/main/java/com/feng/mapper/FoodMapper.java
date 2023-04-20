package com.feng.mapper;

import com.feng.pojo.Food;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.view.foodDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * food Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface FoodMapper extends BaseMapper<Food> {

    @Update("update food set is_seasonal = 1 where food_id = #{foodId}")
    int updateFoodSeasonal(@Param("foodId")String foodId);

    @Update("update food set is_seasonal = 0 where food_id = #{foodId}")
    int updateFoodNotSeasonal(@Param("foodId")String foodId);

    @Update("update food set food_state = 1 where food_id = #{foodId}")
    int undercarriageFood(@Param("foodId")String foodId);

    @Update("update food set food_state = 0 where food_id = #{foodId}")
    int groundingFood(@Param("foodId")String foodId);

    @Select("select * from food where food_id = (select food_id from food_dish where dish_id = #{dishId})")
    List<Food> queryFoodByDish(@Param("dishId") String dishId);

    @Update("update food set default_image = #{imageUrl} where food_id = #{foodId}")
    int setDefualtIamge(@Param("foodId") String foodId, @Param("imageUrl") String imageUrl);

    @Select("select food_id,food_name,food_alias,food_specifications,food_state," +
            "manufacture_date,valid_date,is_seasonal,unit_price,default_image," +
            "type_name from food ,food_type where food.type_id = food_type.type_id " +
            "and food_name like concat('%',#{foodName},'%') and is_seasonal = #{isSeasonal} and food_state = #{foodState} limit #{pageSize} offset #{pageNum}")
    List<foodDto> queryALlFoodDto(@Param("foodName")String foodName, @Param("isSeasonal") int isSeasonal,
                                  @Param("foodState")int foodState,@Param("pageSize")int pageSize,
                                  @Param("pageNum")int pageNum);

    @Select("select food_id,food_name,food_alias,food_specifications,food_state," +
            "manufacture_date,valid_date,is_seasonal,unit_price,default_image," +
            "type_name from food ,food_type where food.type_id = food_type.type_id " +
            "and food_name like concat('%',#{foodName},'%') and food_state = #{foodState} limit #{pageSize} offset #{pageNum}")
    List<foodDto> queryALlFoodDtosea(@Param("foodName")String foodName,
                                  @Param("foodState")int foodState,@Param("pageSize")int pageSize,
                                  @Param("pageNum")int pageNum);

}
