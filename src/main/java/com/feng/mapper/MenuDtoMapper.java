package com.feng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.view.foodDto;
import com.feng.view.menuDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MenuDtoMapper extends BaseMapper<menuDto> {
}
