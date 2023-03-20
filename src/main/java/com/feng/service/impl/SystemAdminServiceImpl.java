package com.feng.service.impl;

import com.feng.pojo.SystemAdmin;
import com.feng.mapper.SystemAdminMapper;
import com.feng.service.SystemAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * system_admin 服务实现类
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Service
@Qualifier("SystemAdminServiceImpl")
public class SystemAdminServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin> implements SystemAdminService {

    @Autowired
    private SystemAdminMapper adminMapper;

    @Override
    public String queryAdminPwdByAid(String  adminId) {
        return adminMapper.selectById(adminId).getAdminPwd();
    }
}
