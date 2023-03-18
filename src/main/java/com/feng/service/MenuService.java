package com.feng.service;

import com.feng.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * menu 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface MenuService extends IService<Menu> {

    //生成新的配菜单
    int addMenu(Menu menu);

    //删除配送单
    int deleteMenu(String menuId);

    //派单给配菜员
    int dispatchStaff(String menuId,String staffId);

    //将配菜单状态设置为配菜中
    int updateMenuGo(String menuId);

    //将配菜单状态设置为配菜完成
    int updateMenuEnd(String menuId);

    //查询某消费者的所有订单
    List<Menu> queryMenuByConsumerId(String consumerId);

    //查询某消费者已完成的所有订单
    List<Menu> queryEndMenuByConsumerId(String consumerId);

    //查询某用户正在配菜的订单
    List<Menu> queryGoMenuByConsumerId(String consumerId);

    //查询某用户还未配菜的订单
    List<Menu> queryBeMenuByConsumerId(String consumerId);

    //绑定派送单
    int bindOrder(String menuID, String orderId);

}
