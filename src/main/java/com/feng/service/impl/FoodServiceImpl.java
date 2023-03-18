package com.feng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Food;
import com.feng.mapper.FoodMapper;
import com.feng.service.FoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * food 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("FoodServiceImpl")
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public int addFood(Food food) {
        return foodMapper.insert(food);
    }

    @Override
    public int deleteFoodByFoodId(String foodId) {
        return foodMapper.deleteById(foodId);
    }

    @Override
    public int updateFood(Food food) {
        return foodMapper.updateById(food);
    }

    @Override
    public int updateFoodSeasonal(String foodId) {
        return foodMapper.updateFoodSeasonal(foodId);
    }

    @Override
    public int updateFoodNotSeasonal(String foodId) {
        return foodMapper.updateFoodNotSeasonal(foodId);
    }

    @Override
    public int undercarriageFood(String foodId) {
        return foodMapper.undercarriageFood(foodId);
    }

    @Override
    public int groundingFood(String foodId) {
        return foodMapper.groundingFood(foodId);
    }

    @Override
    public List<Food> queryAllFood() {

        return foodMapper.selectList(null);
    }

    @Override
    public List<Food> queryAllGrFood() {
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        wrapper.eq("food_state", 0);
        return foodMapper.selectList(wrapper);
    }

    @Override
    public List<Food> queryFoodByType(String typeId) {
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        wrapper.eq("type_id",typeId);
        return foodMapper.selectList(wrapper);
    }

    @Override
    public List<Food> queryGrFoodByType(String typeId) {
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        wrapper.eq("type_id",typeId).eq("food_state", 0);
        return foodMapper.selectList(wrapper);
    }

    @Override
    public List<Food> queryFoodByName(String foodName) {
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        wrapper.like("food_name",foodName).or().like("food_alias", foodName).eq("food_state",0);
        return foodMapper.selectList(wrapper);
    }

    @Override
    public List<Food> queryGrFooodByName(String foodName) {
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        wrapper.like("food_name",foodName).or().like("food_alias", foodName);
        return foodMapper.selectList(wrapper);
    }
}
