package com.feng.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Msg;
import com.feng.service.MenuDtoService;
import com.feng.util.jsonUtil;
import com.feng.view.menuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * menu--food 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/mune-food")
public class MuneFoodController {

    @Autowired
    @Qualifier("MenuDtoServiceImpl")
    private MenuDtoService menuDtoService;

    @RequestMapping(value = "/queryFoodsByMenuId",produces = "application/json;charset=utf-8")
    public String  queryFoodsByMenuId(@RequestBody()Map param){
        Msg msg = new Msg();
        QueryWrapper<menuDto> wrapper = new QueryWrapper<>();
        wrapper.eq("menu_id",(String)param.get("menuId"));
        List<menuDto> foods = menuDtoService.list(wrapper);
        msg.setResult(foods);
        return jsonUtil.getJson(msg);
    }

}

