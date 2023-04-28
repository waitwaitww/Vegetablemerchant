package com.feng.service.impl;

import com.feng.pojo.CarFood;
import com.feng.mapper.CarFoodMapper;
import com.feng.service.CarFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-04-24
 */
@Service
@Qualifier("CarFoodServiceImpl")
public class CarFoodServiceImpl extends ServiceImpl<CarFoodMapper, CarFood> implements CarFoodService {

}
