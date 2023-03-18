package com.feng.mapper;

import com.feng.pojo.MuneFood;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * menu--food Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface MuneFoodMapper extends BaseMapper<MuneFood> {

    @Update("updete mune_food set count = #{count} where menu_id = #{menuId} and food_id = #{foodId} and iscomplete = 0")
    int updateCountByIds(@Param("menuId") String menuId,@Param("foodId") String foodId,@Param("count")float count);

}
