package com.feng.service.impl;

import com.feng.mapper.ImagesMapper;
import com.feng.pojo.DishImage;
import com.feng.mapper.DishImageMapper;
import com.feng.service.DishImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * dish--image 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("DishImageServiceImpl")
public class DishImageServiceImpl extends ServiceImpl<DishImageMapper, DishImage> implements DishImageService {

    @Autowired
    private DishImageMapper dishImageMapper;

    @Autowired
    private ImagesMapper imagesMapper;

    @Override
    public List<String> queryUrlByDishId(String dishId) {
        return imagesMapper.queryUrlByDishId(dishId);
    }

    @Override
    public int addDishImage(String dishId, String imageUrl) {
        DishImage dishImage = new DishImage(dishId, imageUrl);
        return dishImageMapper.insert(dishImage);
    }
}
