package com.feng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.DeliveryOrder;
import com.feng.mapper.DeliveryOrderMapper;
import com.feng.service.DeliveryOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * order 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("DeliveryOrderServiceImpl")
public class DeliveryOrderServiceImpl extends ServiceImpl<DeliveryOrderMapper, DeliveryOrder> implements DeliveryOrderService {

    @Autowired
    private DeliveryOrderMapper deliveryOrderMapper;

    @Override
    public int addOrder(DeliveryOrder order) {
        return deliveryOrderMapper.insert(order);
    }

    @Override
    public int deleteOrder(String orderId) {
        return deliveryOrderMapper.deleteById(orderId);
    }

    @Override
    public int dispatchStaff(String OrderId,String staffId) {
        DeliveryOrder deliveryOrder = deliveryOrderMapper.selectById(OrderId);
        deliveryOrder.setStaffId(staffId);
        return deliveryOrderMapper.updateById(deliveryOrder);
    }

    @Override
    public int setOrderGo(String orderId) {
        DeliveryOrder deliveryOrder = deliveryOrderMapper.selectById(orderId);
        deliveryOrder.setOrderState(1);
        return deliveryOrderMapper.updateById(deliveryOrder);
    }

    @Override
    public int setOrderEnd(String orderId) {
        DeliveryOrder deliveryOrder = deliveryOrderMapper.selectById(orderId);
        deliveryOrder.setOrderState(2);
        return deliveryOrderMapper.updateById(deliveryOrder);
    }

    @Override
    public DeliveryOrder queryOrderByMenuId(String menuId) {
        QueryWrapper<DeliveryOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("menu_id",menuId);
        return deliveryOrderMapper.selectOne(wrapper);
    }

    @Override
    public List<DeliveryOrder> queryGoOrderByStaff(String staffId) {
        QueryWrapper<DeliveryOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("staff_id",staffId).eq("order_state",1);
        return deliveryOrderMapper.selectList(wrapper);
    }

    @Override
    public List<DeliveryOrder> queryBeOrderByConsumerId(String consumerId) {
        return deliveryOrderMapper.queryBeOrderByConsumerId(consumerId);
    }

    @Override
    public List<DeliveryOrder> queryGoOrderByConsumerId(String consumerId) {

        return deliveryOrderMapper.queryGoOrderByConsumerId(consumerId);
    }

    @Override
    public List<DeliveryOrder> queryEndOrderByConsumerId(String consumerId) {
        return deliveryOrderMapper.queryEndOrderByConsumerId(consumerId);
    }
}
