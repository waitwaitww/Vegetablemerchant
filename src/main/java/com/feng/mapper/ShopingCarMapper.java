package com.feng.mapper;

import com.feng.pojo.ShopingCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-04-24
 */
@Repository
@Mapper
public interface ShopingCarMapper extends BaseMapper<ShopingCar> {

}
