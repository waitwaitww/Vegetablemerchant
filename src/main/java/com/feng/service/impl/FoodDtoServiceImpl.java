package com.feng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.mapper.FoodDtoMapper;
import com.feng.mapper.FoodMapper;
import com.feng.pojo.Food;
import com.feng.service.FoodDtoService;
import com.feng.service.FoodService;
import com.feng.view.foodDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * food 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-04-17
 */
@Service
@Qualifier("FoodDtoServiceImpl")
public class FoodDtoServiceImpl extends ServiceImpl<FoodDtoMapper, foodDto> implements FoodDtoService {
}
