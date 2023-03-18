package com.feng.service.impl;

import com.feng.mapper.DishMapper;
import com.feng.mapper.FoodMapper;
import com.feng.pojo.Dish;
import com.feng.pojo.Food;
import com.feng.pojo.FoodDish;
import com.feng.mapper.FoodDishMapper;
import com.feng.service.FoodDishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * food--dish 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("FoodDishServiceImpl")
public class FoodDishServiceImpl extends ServiceImpl<FoodDishMapper, FoodDish> implements FoodDishService {

    @Autowired
    private FoodDishMapper foodDishMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private DishMapper dishMapper;

    @Override
    public List<Food> queryFoodByDish(String dishId) {
        return foodMapper.queryFoodByDish(dishId);
    }

    @Override
    public List<Dish> queryDishByFood(String foodId) {
        return dishMapper.queryDishByFood(foodId);
    }

    @Override
    public int addFoodDish(FoodDish foodDish) {
        return foodDishMapper.insert(foodDish);
    }

    @Override
    public int deleteFoodDish(FoodDish foodDish) {
        return foodDishMapper.deleteById(foodDish);
    }
}
