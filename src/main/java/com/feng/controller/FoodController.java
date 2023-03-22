package com.feng.controller;


import com.feng.pojo.Food;
import com.feng.pojo.Msg;
import com.feng.service.FoodService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.MacSpi;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/queryAllFood",produces = "application/json;charset=utf-8")
    public String queryAllFood(){
        Msg msg = new Msg();
        List<Food> food = foodService.queryAllFood();
        msg.setResult(food);
        return jsonUtil.getJson(msg);
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
    public String queryGrFoodByType(@RequestParam("foodTypeId")String foodTypeId){
        Msg msg = new Msg();
        List<Food> food = foodService.queryGrFoodByType(foodTypeId);
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
    public String addFood(@RequestParam("foodTypeId")String foodTypeId,
                          @RequestParam("foodName")String foodName,
                          @RequestParam("foodAlias")String foodAlias,
                          @RequestParam("foodSpecifications") String foodSpecifications,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")
                              @RequestParam("manufactureDate") Date manufactureDate,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")
                              @RequestParam("validDate")Date validDate,
                          @RequestParam("unitPrice")float unitPrice,
                          @RequestParam("defualtImage")String defualtImage){
        Msg msg = new Msg();
        Food food = new Food();
        food.setFoodName(foodName);
        food.setDefaultImage(defualtImage);
        food.setFoodAlias(foodAlias);
        food.setFoodSpecifications(foodSpecifications);
        food.setFoodState(0);
        food.setIsSeasonal(0);
        food.setTypeId(foodTypeId);
        food.setManufactureDate(manufactureDate);
        food.setValidDate(validDate);
        food.setUnitPrice(unitPrice);
        int i = foodService.addFood(food);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/updateFood",produces = "application/json;charset=utf-8")
    public String updateFood(@RequestParam("foodId")String foodId,
                             @RequestParam("foodTypeId")String foodTypeId,
                             @RequestParam("foodName")String foodName,
                             @RequestParam("foodAlias")String foodAlias,
                             @RequestParam("foodSpecifications") String foodSpecifications,
                             @DateTimeFormat(pattern = "yyyy-MM-dd")
                                 @RequestParam("manufactureDate") Date manufactureDate,
                             @DateTimeFormat(pattern = "yyyy-MM-dd")
                                 @RequestParam("validDate")Date validDate,
                             @RequestParam("unitPrice")float unitPrice,
                             @RequestParam("defualtImage")String defualtImage){
        Msg msg = new Msg();
        Food food = new Food();
        food.setFoodId(foodId);
        food.setFoodName(foodName);
        food.setDefaultImage(defualtImage);
        food.setFoodAlias(foodAlias);
        food.setFoodSpecifications(foodSpecifications);
        food.setFoodState(0);
        food.setIsSeasonal(0);
        food.setTypeId(foodTypeId);
        food.setManufactureDate(manufactureDate);
        food.setValidDate(validDate);
        food.setUnitPrice(unitPrice);
        int i = foodService.updateFood(food);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }
}

