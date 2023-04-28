package com.feng.controller;


import cn.hutool.core.img.ScaleType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.pojo.Dish;
import com.feng.pojo.FoodDish;
import com.feng.pojo.Msg;
import com.feng.service.DishService;
import com.feng.service.FoodDishService;
import com.feng.util.jsonUtil;
import com.feng.view.dishForm;
import com.feng.view.foodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * dish 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    @Qualifier("DishServiceImpl")
    private DishService dishService;

    @Autowired
    @Qualifier("FoodDishServiceImpl")
    private FoodDishService foodDishService;

    @RequestMapping(value = "/queryAllDish",produces = "application/json;charset=utf-8")
    public String queryAllDish(){
        Msg msg = new Msg();
        List<Dish> dishes = dishService.queryAllDish();
        msg.setResult(dishes);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/addDish",produces = "application/json;charset=utf-8")
    public String addDish(@RequestBody()dishForm dishForm){
        Msg msg = new Msg();
        Dish dish = new Dish();

        dish.setDishName(dishForm.getDishName());
        dish.setDishDefaultImage(dishForm.getDefaultImage());
        QueryWrapper<Dish> wrapper = new QueryWrapper<>();
        wrapper.eq("dish_name",dishForm.getDishName());
        if (dishService.count(wrapper)>0){
            msg.setM("该菜品已存在");
        }
        else {
            boolean res = dishService.save(dish);

            String dishId = dishService.getOne(wrapper).getDishId();
            String[] foodsId = dishForm.getFoods();

            FoodDish foodDish = new FoodDish();
            foodDish.setDishId(dishId);
            for (String food : foodsId) {
                foodDish.setFoodId(food);
                System.out.println(foodDish.toString());
                res = foodDishService.save(foodDish);
            }

            msg.setResult(res);
        }


        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/findDishPage", produces = "application/json;charset=utf-8")
    public IPage<Dish> findDishPage(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize,
                                       @RequestParam("dishName")String dishName){
        IPage<Dish> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Dish> wrapper = new QueryWrapper<>();
        wrapper.like("dish_name",dishName);
        wrapper.orderByDesc("dish_id");
        IPage page1 = dishService.page(page, wrapper);
        return page1;
    }


    @RequestMapping(value = "/deleteDishByDishId",produces = "application/json;charset=utf-8")
    public String deleteDishByDishId(@RequestParam("dishId")String dishId){
        Msg msg = new Msg();
        int food = dishService.deleteDish(dishId);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }



}

