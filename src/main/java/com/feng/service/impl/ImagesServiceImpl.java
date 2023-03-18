package com.feng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.pojo.Images;
import com.feng.mapper.ImagesMapper;
import com.feng.service.ImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

/**
 * <p>
 * image 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("ImagesServiceImpl")
public class ImagesServiceImpl extends ServiceImpl<ImagesMapper, Images> implements ImagesService {

    @Autowired
    private ImagesMapper imagesMapper;

    @Override
    public int addImage(Images images) {
        return imagesMapper.insert(images);
    }

    @Override
    public String queryUrlById(String imageId) {
        QueryWrapper<Images> wrapper = new QueryWrapper<>();
        wrapper.eq("image_id" ,imageId);
        return imagesMapper.selectOne(wrapper).getUrl();
    }
}
