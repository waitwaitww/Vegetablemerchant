package com.feng.controller;


import com.feng.pojo.Msg;
import com.feng.pojo.WorkType;
import com.feng.service.WorkTypeService;
import com.feng.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * work_type 前端控制器
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/work-type")
public class WorkTypeController {

    @Autowired
    @Qualifier("WorkTypeServiceImpl")
    private WorkTypeService workTypeService;

    @RequestMapping(value = "/queryAllWorkType",produces = "application/json;charset=utf-8")
    public String queryAllWorkType(){
        Msg msg = new Msg();
        List<WorkType> workTypes = workTypeService.queryAllWorkType();
        msg.setResult(workTypes);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryWorkTypeById",produces = "application/json;charset=utf-8")
    public String queryWorkTypeById(@RequestParam("workTypeId")String workTypeId){
        Msg msg = new Msg();
        String s = workTypeService.queryWorkTypeName(workTypeId);
        msg.setResult(s);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/addWorkType",produces = "application/json;charset=utf-8")
    public String addWorkType(@RequestParam("workTypeName")String workTypeName){
        Msg msg = new Msg();
        WorkType workType = new WorkType();
        workType.setWorkTypeName(workTypeName);
        int i = workTypeService.addWorkType(workType);
        msg.setResult(i);
        return jsonUtil.getJson(msg);
    }

}

