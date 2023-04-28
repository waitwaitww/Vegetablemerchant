package com.feng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.view.carDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CarDtoMapper extends BaseMapper<carDto> {
}
