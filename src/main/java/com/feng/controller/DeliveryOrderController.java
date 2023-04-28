package com.feng.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.DeliveryOrder;
import com.feng.pojo.Msg;
import com.feng.service.DeliveryOrderService;
import com.feng.service.StaffService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.MacSpi;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * order 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/delivery-order")
public class DeliveryOrderController {

    @Autowired
    @Qualifier("DeliveryOrderServiceImpl")
    private DeliveryOrderService deliveryOrderService;

    @Autowired
    @Qualifier("StaffServiceImpl")
    private StaffService staffService;

    @RequestMapping(value = "/queryOrderByStaffId",produces = "application/json;charset=utf-8")
    public String queryOrderByStaffId(@RequestBody Map<String,Object> param){
        Msg msg = new Msg();
        QueryWrapper<DeliveryOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("staff_id",(String)param.get("staffId"));
        wrapper.orderByAsc("order_state");
        List<DeliveryOrder> orders = deliveryOrderService.list(wrapper);
        msg.setResult(orders);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/confirmDelivery",produces = "application/json;charset=utf-8")
    public String confirmDelivery(@RequestBody()Map param){
        Msg msg = new Msg();
        String orderId = (String) param.get("orderId");
        int i = deliveryOrderService.setOrderEnd(orderId);

        staffService.finish(deliveryOrderService.getById(orderId).getStaffId());
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }


}

