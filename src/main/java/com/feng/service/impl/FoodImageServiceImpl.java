package com.feng.service.impl;

import com.feng.pojo.FoodImage;
import com.feng.mapper.FoodImageMapper;
import com.feng.service.FoodImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * food--image 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("FoodImageServiceImpl")
public class FoodImageServiceImpl extends ServiceImpl<FoodImageMapper, FoodImage> implements FoodImageService {

}
