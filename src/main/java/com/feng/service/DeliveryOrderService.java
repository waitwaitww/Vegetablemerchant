package com.feng.service;

import com.feng.pojo.DeliveryOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * order 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface DeliveryOrderService extends IService<DeliveryOrder> {

    //添加派送单
    int addOrder(DeliveryOrder order);

    //删除派送单
    int deleteOrder(String orderId);

    //绑定派送单给派送员
    int dispatchStaff(String orderId,String staffId);

    //将派送单状态设置为派送中
    int setOrderGo(String orderId);

    //将订单状态设置为完成配送
    int setOrderEnd(String orderId);

    //根据配菜单号查询派送单
    DeliveryOrder queryOrderByMenuId(String menuId);

    //查询某一员工的现在正进行的派送单
    List<DeliveryOrder> queryGoOrderByStaff(String staffId);

    //查询某用户还未接单的派送单
    List<DeliveryOrder> queryBeOrderByConsumerId(String consumerId);

    //查询某用户正在派送的订单
    List<DeliveryOrder> queryGoOrderByConsumerId(String consumerId);

    //查询某用户所有完成的派送单
    List<DeliveryOrder> queryEndOrderByConsumerId(String consumerId);

}
