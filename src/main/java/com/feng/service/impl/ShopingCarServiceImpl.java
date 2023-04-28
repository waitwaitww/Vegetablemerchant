package com.feng.service.impl;

import com.feng.pojo.ShopingCar;
import com.feng.mapper.ShopingCarMapper;
import com.feng.service.ShopingCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-04-24
 */
@Service
@Qualifier("ShopingCarServiceImpl")
public class ShopingCarServiceImpl extends ServiceImpl<ShopingCarMapper, ShopingCar> implements ShopingCarService {

}
