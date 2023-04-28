package com.feng.controller;


import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Consumer;
import com.feng.pojo.DeliveryOrder;
import com.feng.pojo.Menu;
import com.feng.pojo.Msg;
import com.feng.service.ConsumerService;
import com.feng.service.DeliveryOrderService;
import com.feng.service.MenuService;
import com.feng.service.StaffService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * menu 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    @Qualifier("MenuServiceImpl")
    private MenuService menuService;

    @Autowired
    @Qualifier("DeliveryOrderServiceImpl")
    DeliveryOrderService deliveryOrderService;

    @Autowired
    @Qualifier("ConsumerServiceImpl")
    private ConsumerService consumerService;

    @Autowired
    @Qualifier("StaffServiceImpl")
    private StaffService staffService;

    @RequestMapping(value = "/queryMenuByStaffId",produces = "application/json;charset=utf-8")
    public String queryMenuByStaffId(@RequestBody()Map param){
        Msg msg = new Msg();
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("staff_id",(String)param.get("staffId"));
        wrapper.orderByAsc("menu_state");
        List<Menu> menus = menuService.list(wrapper);
        msg.setResult(menus);
        return jsonUtil.getJson(msg);
    }


    @RequestMapping(value = "/finishMenu",produces = "application/json;charset=utf-8")
    public String finishMenu(@RequestBody()Map param){
        Msg msg = new Msg();

        String menuID = (String) param.get("menuId");

        Menu menu = menuService.getById(menuID);

        if(menu.getOrderNumber() == 1){
            DeliveryOrder order = deliveryOrderService.getById(menu.getOrderId());

            Consumer consumer = consumerService.getById(menu.getConsumerId());

            String telephone = consumer.getConsumerTelephone();

            order.setOrderTelephone(telephone);
            order.setOrderGenerationTime(DateTime.now());
            order.setMenuId(menu.getMenuId());
            order.setOrderState(1);
            order.setDestination(consumer.getAddress1());
            order.setStaffId(deliveryOrderService.findStaffIdByCount());

            boolean save = deliveryOrderService.saveOrUpdate(order);
            if (!save){
                msg.setM("配送单生成失败！");
            }
        }
        menu.setCompletionTime(DateTime.now());
        menu.setMenuState(2);

        staffService.finish(menu.getStaffId());

        boolean b = menuService.saveOrUpdate(menu);

        msg.setResult(b);
        if (b)
            msg.setCode("success");
        return jsonUtil.getJson(msg);

        
    }
}

