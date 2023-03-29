package com.feng.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
//import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
//import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component//不要忘记把处理器放入IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert");
        this.setFieldValByName("Create_time",new Date(),metaObject);
        this.setFieldValByName("updataTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start updata");
        this.setFieldValByName("updataTime",new Date(),metaObject);
    }

//    //逻辑删除组件
//    @Bean
//    public ISqlInjector sqlInjector(){
//        return new LogicSqlInjector();
//    }
//
//    //性能分析插件
//    @Bean
//    @Profile({"dev","test"})//设置dev开发、test测试 环境开启  保证我们的效率
//    public PerformanceInterceptor performanceInterceptor(){
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        performanceInterceptor.setMaxTime(1000);//设置sql最大执行时间*ms，如果超过了则不执行
//        performanceInterceptor.setFormat(true);//开启sql格式化
//        return performanceInterceptor;
//    }
}
