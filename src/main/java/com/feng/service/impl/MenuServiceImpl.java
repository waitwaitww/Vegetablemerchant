package com.feng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Menu;
import com.feng.mapper.MenuMapper;
import com.feng.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * menu 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("MenuServiceImpl")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public int isExist(String menuId){
        if (menuMapper.selectById(menuId) != null)
            return 1 ;
        return 0;
    }

    @Override
    public int addMenu(Menu menu) {
        if (isExist(menu.getMenuId()) != 0)
            return menuMapper.insert(menu);
        return 0;
    }

    @Override
    public int deleteMenu(String menuId) {
        if (isExist(menuId) != 0)
            return menuMapper.deleteById(menuId);
        return 0;
    }

    @Override
    public int dispatchStaff(String menuId, String staffId) {
        if(isExist(menuId) != 0)
            return menuMapper.dispatchStaff(menuId,staffId);
        return 0;
    }

    @Override
    public int updateMenuGo(String menuId) {
        if(isExist(menuId) != 0)
            return menuMapper.updateMenuGo(menuId);
        return 0;
    }

    @Override
    public int updateMenuEnd(String menuId) {
        if(isExist(menuId) != 0)
            return menuMapper.updateMenuEnd(menuId);
        return 0;
    }

    @Override
    public List<Menu> queryMenuByConsumerId(String consumerId) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("consumer_id" ,consumerId);
        return menuMapper.selectList(wrapper);
    }

    @Override
    public List<Menu> queryEndMenuByConsumerId(String consumerId) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("consumer_id" ,consumerId)
                .eq("menu_id", 2);
        return menuMapper.selectList(wrapper);
    }

    @Override
    public List<Menu> queryGoMenuByConsumerId(String consumerId) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("consumer_id" ,consumerId)
                .eq("menu_id", 1);
        return menuMapper.selectList(wrapper);
    }

    @Override
    public List<Menu> queryBeMenuByConsumerId(String consumerId) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("consumer_id" ,consumerId)
                .eq("menu_id", 0);
        return menuMapper.selectList(wrapper);
    }

    @Override
    public int bindOrder(String menuID, String orderId) {
        return menuMapper.bindOrder(menuID,orderId);
    }


}
