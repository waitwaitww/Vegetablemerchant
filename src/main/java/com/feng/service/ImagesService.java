package com.feng.service;

import com.feng.pojo.Images;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * image 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface ImagesService extends IService<Images> {

    //添加照片
    int addImage(Images images);

    //根据id查询照片url
    String queryUrlById(String imageId);

}
