package com.feng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.view.foodDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * food--dish Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-04-17
 */
@Repository
@Mapper
public interface FoodDtoMapper extends BaseMapper<foodDto> {
}
