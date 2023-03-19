package com.feng.mapper;

import com.feng.pojo.Images;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * image Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface ImagesMapper extends BaseMapper<Images> {


    @Select("select url from images where image_id = (select image_id from dish_image where dish_id = #{dishId})")
    List<String> queryUrlByDishId(@Param("dishId") String dishId);

    @Select("select url from images where image_id = (select image_id from food_image where food_id = #{foodId})")
    List<String> queryUrlByFoodId(@Param("foodId") String foodId);

}
