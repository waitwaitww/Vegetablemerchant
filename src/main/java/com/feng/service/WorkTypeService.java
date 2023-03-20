package com.feng.service;

import com.feng.pojo.WorkType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * work_type 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface WorkTypeService extends IService<WorkType> {

    //添加工作类型
    int addWorkType (WorkType workType);

    //根据序号查询工作类型名
    String queryWorkTypeName(String workId);

    //查询所有工作类型
    List<WorkType> queryAllWorkType();



}
