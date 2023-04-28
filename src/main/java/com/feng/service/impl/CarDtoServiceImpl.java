package com.feng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.mapper.CarDtoMapper;
import com.feng.mapper.MenuDtoMapper;
import com.feng.service.CarDtoService;
import com.feng.view.carDto;
import com.feng.view.menuDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("CarDtoServiceImpl")
public class CarDtoServiceImpl extends ServiceImpl<CarDtoMapper, carDto> implements CarDtoService {
}
