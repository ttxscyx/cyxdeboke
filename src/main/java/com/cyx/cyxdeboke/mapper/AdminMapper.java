package com.cyx.cyxdeboke.mapper;

import com.cyx.cyxdeboke.Entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    //后端,登录查出用户名
     Admin getPwdByUsername(@Param("username") String username);
    //根据id查出Admin
     Admin getAdminId(@Param("id") Long id);
}
