package com.feng.service.impl;

import com.feng.pojo.FoodType;
import com.feng.mapper.FoodTypeMapper;
import com.feng.service.FoodTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("FoodTypeServiceImpl")
public class FoodTypeServiceImpl extends ServiceImpl<FoodTypeMapper, FoodType> implements FoodTypeService {

    @Autowired
    private FoodTypeMapper foodTypeMapper;

    @Override
    public String queryNameByid(String typeId) {
        return foodTypeMapper.selectById(typeId).getTypeName();
    }

    @Override
    public int addType(FoodType foodType) {
        return foodTypeMapper.insert(foodType);
    }

    @Override
    public int delete(String typeId) {
        return foodTypeMapper.deleteById(typeId);
    }

    @Override
    public List<FoodType> queryAllFoodType() {
        return foodTypeMapper.selectList(null);
    }
}
