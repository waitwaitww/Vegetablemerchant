package com.feng.service.impl;

import com.feng.pojo.Dish;
import com.feng.mapper.DishMapper;
import com.feng.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * dish 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("DishServiceImpl")
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Override
    public int addDish(Dish dish) {
        return dishMapper.insert(dish);
    }

    @Override
    public int deleteDish(String dishId) {
        return dishMapper.deleteById(dishId);
    }

    @Override
    public int updateDish(Dish dish) {
        return dishMapper.updateById(dish);
    }

    @Override
    public String queryNameById(String dishId) {
        return dishMapper.selectById(dishId).getDishName();
    }
}
