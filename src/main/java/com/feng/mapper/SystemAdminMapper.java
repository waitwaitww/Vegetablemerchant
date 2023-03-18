package com.feng.mapper;

import com.feng.pojo.SystemAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * system_admin Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Repository
@Mapper
public interface SystemAdminMapper extends BaseMapper<SystemAdmin> {

}
