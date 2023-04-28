package com.feng.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Food;
import com.feng.pojo.FoodDish;
import com.feng.pojo.Msg;
import com.feng.service.FoodDishService;
import com.feng.service.FoodService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * food--dish 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/food-dish")
public class FoodDishController {

    @Autowired
    @Qualifier("FoodDishServiceImpl")
    private FoodDishService foodDishService;

    @Autowired
    @Qualifier("FoodServiceImpl")
    private FoodService foodService;

    @RequestMapping(value = "/queryFoodDish", produces = "application/json;charset=utf-8")
    public String queryFoodDish(@RequestParam("dishId")String dishId){
        Msg msg = new Msg();

        QueryWrapper<FoodDish> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("dish_id",dishId);
        List<FoodDish> foodDishes = foodDishService.list(wrapper1);
        List<String> foods = new LinkedList<String >();
        for (FoodDish foodDish : foodDishes) {
            String food = foodService.queryFoodName(foodDish.getFoodId());
            System.out.println(food);
            foods.add(food);

        }
        msg.setResult(foods);
        return jsonUtil.getJson(msg);
    }


}

