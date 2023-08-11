package com.cyx.cyxdeboke.service;

import com.cyx.cyxdeboke.Entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
     //后端,登录查出用户名
     Admin getPwdByUsername(String username);
     //根据id查出Admin
     Admin getAdminId(Long id);
}
