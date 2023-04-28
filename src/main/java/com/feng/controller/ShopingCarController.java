package com.feng.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.CarFood;
import com.feng.pojo.Food;
import com.feng.pojo.Msg;
import com.feng.pojo.ShopingCar;
import com.feng.service.CarDtoService;
import com.feng.service.CarFoodService;
import com.feng.service.FoodService;
import com.feng.service.ShopingCarService;
import com.feng.util.jsonUtil;
import com.feng.view.carDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/shoping-car")
public class ShopingCarController {


    @Autowired
    @Qualifier("ShopingCarServiceImpl")
    private ShopingCarService shopingCarService;

    @Autowired
    @Qualifier("CarDtoServiceImpl")
    private CarDtoService carDtoService;

    @Autowired
    @Qualifier("FoodServiceImpl")
    private FoodService foodService;

    @Autowired
    @Qualifier("CarFoodServiceImpl")
    private CarFoodService carFoodService;

    @RequestMapping(value = "/addFoodToCar",produces = "application/json;charset=utf-8")
    public String addFoodToCar(@RequestBody() Map param){
        Msg msg = new Msg();

        QueryWrapper<ShopingCar> shopingCarQueryWrapper = new QueryWrapper<>();
        shopingCarQueryWrapper.eq("consumer_id",(String)param.get("consumerId"));
        ShopingCar shopingCar = shopingCarService.getOne(shopingCarQueryWrapper);

        Food food = foodService.getById((String) param.get("foodId"));

        if((Integer) param.get("foodNum") >0)
        {
            CarFood carFood = new CarFood();
            carFood.setCarId(shopingCar.getCarId());
            carFood.setFoodId(food.getFoodId());
            carFood.setCounts((Integer) param.get("foodNum"));

            boolean a = carFoodService.save(carFood);

            shopingCar.setFoodnum(shopingCar.getFoodnum()+1);
            shopingCar.setCarId(shopingCar.getConsumerId());
            shopingCar.setTotalprice(shopingCar.getTotalprice()+(food.getUnitPrice()*(int)param.get("foodNum")));

            shopingCarService.update(shopingCar,null);

        }

        QueryWrapper<carDto> carDtoQueryWrapper = new QueryWrapper<>();
        carDtoQueryWrapper.eq("car_id",shopingCar.getCarId());
        msg.setResult(carDtoService.list(carDtoQueryWrapper));

        return jsonUtil.getJson(msg);

    }

}

