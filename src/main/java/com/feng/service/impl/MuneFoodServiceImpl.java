package com.feng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.MuneFood;
import com.feng.mapper.MuneFoodMapper;
import com.feng.service.MuneFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * menu--food 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("MuneFoodServiceImpl")
public class MuneFoodServiceImpl extends ServiceImpl<MuneFoodMapper, MuneFood> implements MuneFoodService {

    @Autowired
    private MuneFoodMapper muneFoodMapper;

    @Override
    public int addMuneFood(MuneFood muneFood) {
        return muneFoodMapper.insert(muneFood);
    }

    @Override
    public int updateCountByIds(String menuId, String foodId ,float count) {
        return muneFoodMapper.updateCountByIds(menuId,foodId,count);
    }
}
