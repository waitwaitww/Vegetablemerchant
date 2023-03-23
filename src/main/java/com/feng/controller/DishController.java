package com.feng.controller;


import com.feng.pojo.Dish;
import com.feng.pojo.Msg;
import com.feng.service.DishService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/queryAllDish",produces = "application/json;charset=utf-8")
    public String queryAllDish(){
        Msg msg = new Msg();
        List<Dish> dishes = dishService.queryAllDish();
        msg.setResult(dishes);
        return jsonUtil.getJson(msg);
    }

    

}

