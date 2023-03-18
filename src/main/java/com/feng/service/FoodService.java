package com.feng.service;

import com.feng.pojo.Food;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * food 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface FoodService extends IService<Food> {

    //添加菜品
    int addFood(Food food);

    //删除菜品
    int deleteFoodByFoodId(String foodId);

    //修改菜品
    int updateFood(Food food);

    //将该菜品设置为应季
    int updateFoodSeasonal(String foodId);

    //将该菜品设置为不应季
    int updateFoodNotSeasonal(String foodId);

    //下架菜品
    int undercarriageFood(String foodId);

    //上架菜品
    int groundingFood(String foodId);

    //查找全部菜品
    List<Food> queryAllFood();

    //查询所有已上架的菜品
    List<Food> queryAllGrFood();

    //查询某类菜品
    List<Food> queryFoodByType(String typeId);

    //查询某类已上架的菜品
    List<Food> queryGrFoodByType(String typeId);

    //根据菜品名查询菜品
    List<Food> queryFoodByName(String foodName);

    //根据菜品名查询已上架的菜品
    List<Food> queryGrFooodByName(String foodName);

}
