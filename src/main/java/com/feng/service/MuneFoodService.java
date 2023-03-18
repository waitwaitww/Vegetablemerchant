package com.feng.service;

import com.feng.pojo.MuneFood;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * menu--food 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface MuneFoodService extends IService<MuneFood> {

    //增加菜品记录
    int addMuneFood(MuneFood muneFood);

    //修改某未完成订单的菜品记录的数量
    int updateCountByIds(String menuId,String foodId ,float count);

}
