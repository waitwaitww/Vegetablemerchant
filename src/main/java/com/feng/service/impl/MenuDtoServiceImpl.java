package com.feng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.mapper.FoodDtoMapper;
import com.feng.mapper.MenuDtoMapper;
import com.feng.service.MenuDtoService;
import com.feng.view.foodDto;
import com.feng.view.menuDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MenuDtoServiceImpl")
public class MenuDtoServiceImpl extends ServiceImpl<MenuDtoMapper, menuDto> implements MenuDtoService {
}
