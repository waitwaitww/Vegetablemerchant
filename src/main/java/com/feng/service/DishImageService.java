package com.feng.service;

import com.feng.pojo.DishImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * dish--image 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface DishImageService extends IService<DishImage> {

    //根据成品菜id查询图片url
    List<String > queryUrlByDishId(String dishId);

    //添加成品菜图片对应
    int addDishImage(String dishId,String imageUrl);

}
