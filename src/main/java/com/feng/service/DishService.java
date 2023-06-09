package com.feng.service;

import com.feng.pojo.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * dish 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface DishService extends IService<Dish> {

    //添加成品菜
    int addDish(Dish dish);

    //删除成品菜
    int deleteDish(String dishId);

    //修改成品菜
    int updateDish(Dish dish);

    //根据id查询成品菜
    String queryNameById(String dishId);

    //查询所有成品菜
    List<Dish>  queryAllDish();

    //将某图片设置为默认图片
    int setDefualtIamge(String dishId,String imageUrl);

}
