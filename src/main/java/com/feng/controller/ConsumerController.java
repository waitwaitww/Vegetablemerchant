package com.feng.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Consumer;
import com.feng.pojo.Msg;
import com.feng.pojo.ShopingCar;
import com.feng.service.ConsumerService;
import com.feng.service.ShopingCarService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * consumer 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    @Qualifier("ConsumerServiceImpl")
    private ConsumerService consumerService;

    @Autowired
    @Qualifier("ShopingCarServiceImpl")
    private ShopingCarService shopingCarService;

    @RequestMapping(value = "/queryConsumerById",produces = "application/json;charset=utf-8")
    public String queryConsumerById(@RequestBody() Map param){
        Msg msg = new Msg();

        Consumer consumer = consumerService.getById((String) param.get("consumerId"));

        if (consumer == null){
            msg.setResult("false");
        }else   msg.setResult(consumer);

        return jsonUtil.getJson(msg);

    }

    @RequestMapping(value = "/createConsumer",produces = "application/json;charset=utf-8")
    public String createConsumer(@RequestBody()Map param){
        Msg msg = new Msg();

        Consumer consumer = new Consumer();

        consumer.setConsumerId((String) param.get("userOpenid"));
        consumer.setAddress1((String) param.get("address"));
        consumer.setConsumerName((String) param.get("userNickname"));
        consumer.setConsumerTelephone((String) param.get("consumerTelephone"));
        consumer.setConsumerPwd("123");
        consumer.setIsvip(0);
        consumer.setConsumerWallet((float) 0.0);

        consumerService.save(consumer);

        ShopingCar shopingCar = new ShopingCar();
        shopingCar.setCarId(consumer.getConsumerId());
        shopingCar.setFoodnum(0);
        shopingCar.setTotalprice(0);

        shopingCarService.save(shopingCar);

        msg.setResult(consumer);

        return jsonUtil.getJson(msg);

    }

    @RequestMapping(value = "/updateAddress",produces = "application/json;charset=utf-8")
    public String updateAddress(@RequestBody()Map param){
        Consumer consumer = consumerService.getById((String) param.get("consumerId"));

        consumer.setAddress1((String) param.get("address"));
        QueryWrapper<Consumer> consumerQueryWrapper = new QueryWrapper<>();
        consumerQueryWrapper.eq("consumer_id",consumer.getConsumerId());
        boolean update = consumerService.update(consumer, consumerQueryWrapper);

        Msg msg = new Msg();

        msg.setResult(update);

        return jsonUtil.getJson(msg);
    }

}

