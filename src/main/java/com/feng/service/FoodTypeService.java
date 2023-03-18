package com.feng.service;

import com.feng.pojo.FoodType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface FoodTypeService extends IService<FoodType> {

    //根据序号查询类名
    String queryNameByid(String typeId);

    //添加类型
    int addType(FoodType foodType);

    //删除类型
    int delete(String typeId);

}
