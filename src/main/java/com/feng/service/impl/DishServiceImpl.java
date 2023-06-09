package com.feng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.mapper.FoodDishMapper;
import com.feng.pojo.Dish;
import com.feng.mapper.DishMapper;
import com.feng.pojo.FoodDish;
import com.feng.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * dish 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("DishServiceImpl")
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private FoodDishMapper foodDishMapper;

    @Override
    public int addDish(Dish dish) {
        return dishMapper.insert(dish);
    }

    @Override
    public int deleteDish(String dishId) {

        QueryWrapper<FoodDish> w = new QueryWrapper<>();
        w.eq("dish_id",dishId);
        foodDishMapper.delete(w);

        return dishMapper.deleteById(dishId);
    }

    @Override
    public int updateDish(Dish dish) {
        return dishMapper.updateById(dish);
    }

    @Override
    public String queryNameById(String dishId) {
        return dishMapper.selectById(dishId).getDishName();
    }

    @Override
    public List<Dish> queryAllDish() {
        return dishMapper.selectList(null);
    }

    @Override
    public int setDefualtIamge(String dishId, String imageUrl) {
        return dishMapper.setDefualtIamge(dishId,imageUrl);
    }
}
