package com.feng.service;

import com.feng.pojo.SystemAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * system_admin 服务类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
public interface SystemAdminService extends IService<SystemAdmin> {

    //根据管理员id查找密码
    String queryAdminPwdByAid(Long adminId);

}
