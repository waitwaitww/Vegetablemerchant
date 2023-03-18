package com.feng.service;

import com.feng.pojo.Dish;
import com.feng.pojo.Food;
import com.feng.pojo.FoodDish;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * food--dish 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface FoodDishService extends IService<FoodDish> {

    //根据成品菜查找菜品
    List<Food> queryFoodByDish(String dishId);

    //根据菜品查找成品菜
    List<Dish> queryDishByFood(String foodId);

    //添加菜品成品菜对应
    int addFoodDish(FoodDish foodDish);

    //删除菜品成品菜对应
    int deleteFoodDish(FoodDish foodDish);
}
