package com.cyx.cyxdeboke.service.Impl;

import com.cyx.cyxdeboke.Entity.Admin;
import com.cyx.cyxdeboke.mapper.AdminMapper;
import com.cyx.cyxdeboke.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    //后端,登录查出用户名
    public Admin getPwdByUsername(String username) {
        return adminMapper.getPwdByUsername(username);
    }
    @Override
    //根据id查出Admin
    public Admin getAdminId(Long id) {
        return adminMapper.getAdminId(id);
    }
}
