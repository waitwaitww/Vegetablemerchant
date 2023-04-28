package com.feng.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.pojo.Food;
import com.feng.pojo.Msg;
import com.feng.pojo.Staff;
import com.feng.service.FoodDtoService;
import com.feng.service.FoodService;
import com.feng.util.jsonUtil;
import com.feng.view.foodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.MacSpi;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * food 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    @Qualifier("FoodServiceImpl")
    private FoodService foodService;

    @Autowired
    @Qualifier("FoodDtoServiceImpl")
    private FoodDtoService foodDtoService;

    @RequestMapping(value = "/queryAllFood",produces = "application/json;charset=utf-8")
    public String queryAllFood(){
        Msg msg = new Msg();
        List<foodDto> food = foodDtoService.list();
        msg.setResult(food);
        int size = food.size();
        msg.setCount(size);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/findfoodPage", produces = "application/json;charset=utf-8")
    public IPage<foodDto> findfoodPage(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize,
                                      @RequestParam("foodName")String foodName){
        IPage<foodDto> page = new Page<>(pageNum,pageSize);
        QueryWrapper<foodDto> wrapper = new QueryWrapper<>();
        wrapper.like("food_name",foodName);
        wrapper.orderByDesc("type_id");
        IPage page1 = foodDtoService.page(page, wrapper);
        return page1;
    }

    @RequestMapping(value = "/findundercarriageFoodPage", produces = "application/json;charset=utf-8")
    public IPage<foodDto> findundercarriageFoodPage(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize,
                                       @RequestParam("foodName")String foodName){
        IPage<foodDto> page = new Page<>(pageNum,pageSize);
        QueryWrapper<foodDto> wrapper = new QueryWrapper<>();
        wrapper.like("food_name",foodName).eq("food_state",1);
        wrapper.orderByDesc("type_id");
        IPage page1 = foodDtoService.page(page, wrapper);
        return page1;
    }

    @RequestMapping(value = "/queryAllGrFood",produces = "application/json;charset=utf-8")
    public String queryAllGrFood(){
        Msg msg = new Msg();
        List<Food> food = foodService.queryAllGrFood();
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryAllSeaFood",produces = "application/json;charset=utf-8")
    public String queryAllSeaFood(){
        Msg msg = new Msg();
        List<Food> food = foodService.queryAllSeaFood();
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryGrSeaFood",produces = "application/json;charset=utf-8")
    public String queryGrSeaFood(){
        Msg msg = new Msg();
        List<Food> food = foodService.queryGrSeaFood();
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryFoodByType",produces = "application/json;charset=utf-8")
    public String queryFoodByType(@RequestParam("foodTypeId")String foodTypeId){
        Msg msg = new Msg();
        List<Food> food = foodService.queryFoodByType(foodTypeId);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryGrFoodByType",produces = "application/json;charset=utf-8")
    public String queryGrFoodByType(@RequestBody() Map param){
        Msg msg = new Msg();
        List<Food> food = foodService.queryGrFoodByType((String) param.get("foodTypeId"));
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryFoodByName",produces = "application/json;charset=utf-8")
    public String queryFoodByName(@RequestParam("foodName")String foodName){
        Msg msg = new Msg();
        List<Food> food = foodService.queryFoodByName(foodName);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryGrFoodByName",produces = "application/json;charset=utf-8")
    public String queryGrFoodByName(@RequestParam("foodName")String foodName){
        Msg msg = new Msg();
        List<Food> food = foodService.queryGrFooodByName(foodName);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }



    @RequestMapping(value = "/groundingFood",produces = "application/json;charset=utf-8")
    public String groundingFood(@RequestParam("foodId")String foodId){
        Msg msg = new Msg();
        int food = foodService.groundingFood(foodId);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/undercarriageFood",produces = "application/json;charset=utf-8")
    public String undercarriageFood(@RequestParam("foodId")String foodId){
        Msg msg = new Msg();
        int food = foodService.undercarriageFood(foodId);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/updateFoodSeasonal",produces = "application/json;charset=utf-8")
    public String updateFoodSeasonal(@RequestParam("foodId")String foodId){
        Msg msg = new Msg();
        int food = foodService.updateFoodSeasonal(foodId);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/updateFoodNotSeasonal",produces = "application/json;charset=utf-8")
    public String updateFoodNotSeasonal(@RequestParam("foodId")String foodId){
        Msg msg = new Msg();
        int food = foodService.updateFoodNotSeasonal(foodId);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/deleteFoodByFoodId",produces = "application/json;charset=utf-8")
    public String deleteFoodByFoodId(@RequestParam("foodId")String foodId){
        Msg msg = new Msg();
        int food = foodService.deleteFoodByFoodId(foodId);
        msg.setResult(food);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/addFood",produces = "application/json;charset=utf-8")
    public String addFood(@RequestBody()Food food1){
        Msg msg = new Msg();
        Food food = new Food();
        food.setFoodId(food1.getFoodId());
        food.setFoodName(food1.getFoodName());
        food.setDefaultImage(food1.getDefaultImage());
        food.setFoodAlias(food1.getFoodAlias());
        food.setFoodSpecifications(food1.getFoodSpecifications());
        food.setFoodState(0);
        food.setIsSeasonal(food1.getIsSeasonal());
        food.setTypeId(food1.getTypeId());
        food.setManufactureDate(food1.getManufactureDate());
        food.setValidDate(food1.getValidDate());
        food.setUnitPrice(food1.getUnitPrice());
        int i = foodService.addFood(food);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }




    @RequestMapping(value = "/updateFood",produces = "application/json;charset=utf-8")
    public String updateFood(@RequestBody()Food food1){
        Msg msg = new Msg();
        Food food = new Food();
        food.setFoodId(food1.getFoodId());
        food.setFoodName(food1.getFoodName());
        food.setDefaultImage(food1.getDefaultImage());
        food.setFoodAlias(food1.getFoodAlias());
        food.setFoodSpecifications(food1.getFoodSpecifications());
        food.setFoodState(food1.getFoodState());
        food.setIsSeasonal(food1.getIsSeasonal());
        food.setTypeId(food1.getTypeId());
        food.setManufactureDate(food1.getManufactureDate());
        food.setValidDate(food1.getValidDate());
        food.setUnitPrice(food1.getUnitPrice());
        int i = foodService.updateFood(food);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryFoodByFoodId",produces = "application/json;charset=utf-8")
    public String queryFoodByFoodId(@RequestBody()Map param){
        Msg msg = new Msg();
        foodDto food = foodDtoService.getById((String) param.get("foodId"));
        msg.setResult(food);
        if (food == null)   msg.setCode("0");
        return jsonUtil.getJson(msg);
    }
}

