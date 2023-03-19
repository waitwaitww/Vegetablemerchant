package com.feng.service.impl;

import com.feng.mapper.ImagesMapper;
import com.feng.pojo.DishImage;
import com.feng.pojo.FoodImage;
import com.feng.mapper.FoodImageMapper;
import com.feng.service.FoodImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private FoodImageMapper foodImageMapper;

    @Autowired
    private ImagesMapper imagesMapper;

    @Override
    public List<String> queryUrlByDishId(String foodId)  {
        return imagesMapper.queryUrlByDishId(foodId);
    }

    @Override
    public int addDishImage(String foodId, String imageUrl) {
        FoodImage foodImage = new FoodImage(foodId, imageUrl);
        return foodImageMapper.insert(foodImage);
    }
}
