package com.feng.service;

import com.feng.pojo.FoodImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * food--image 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface FoodImageService extends IService<FoodImage> {

    //根据菜品id查询图片url
    List<String > queryUrlByDishId(String foodId);

    //添加菜品图片对应
    int addDishImage(String foodId,String imageUrl);

}
