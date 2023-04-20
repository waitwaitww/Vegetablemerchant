package com.feng.controller;


import com.feng.pojo.FoodType;
import com.feng.pojo.Msg;
import com.feng.service.FoodTypeService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/food-type")
public class FoodTypeController {

    @Autowired
    @Qualifier("FoodTypeServiceImpl")
    private FoodTypeService foodTypeService;

    @RequestMapping(value = "/queryAllFoodType",produces = "application/json;charset=utf-8")
    public String queryAllFoodType(){
        Msg msg = new Msg();
        List<FoodType> foodTypes = foodTypeService.queryAllFoodType();
        msg.setResult(foodTypes);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryFoodTypeByTypeId",produces = "application/json;charset=utf-8")
    public String queryFoodTypeByTypeId(@RequestParam("typeId")String typeId){
        Msg msg = new Msg();
        String s = foodTypeService.queryNameByid(typeId);
        msg.setResult(s);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/addFoodType",produces = "application/json;charset=utf-8")
    public String addFoodType(@RequestBody()FoodType foodType1){
        Msg msg = new Msg();
        FoodType foodType = new FoodType();
        foodType.setTypeName(foodType1.getTypeName());
        int i = foodTypeService.addType(foodType);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }


    @RequestMapping(value = "/deleteFoodType",produces = "application/json;charset=utf-8")
    public String deleteFoodType(@RequestParam("typeId")String typeId){
        Msg msg = new Msg();
        int delete = foodTypeService.delete(typeId);
        msg.setResult(delete);
        return jsonUtil.getJson(msg);
    }

}

