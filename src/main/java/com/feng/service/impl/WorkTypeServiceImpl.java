package com.feng.service.impl;

import com.feng.pojo.WorkType;
import com.feng.mapper.WorkTypeMapper;
import com.feng.service.WorkTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * work_type 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("WorkTypeServiceImpl")
public class WorkTypeServiceImpl extends ServiceImpl<WorkTypeMapper, WorkType> implements WorkTypeService {
    @Autowired
    private WorkTypeMapper workTypeMapper;

    @Override
    public int addWorkType(WorkType workType) {
        return workTypeMapper.insert(workType);
    }

    @Override
    public String queryWorkTypeName(String workId) {
        return workTypeMapper.selectById(workId).getWorkTypeName();
    }
}
