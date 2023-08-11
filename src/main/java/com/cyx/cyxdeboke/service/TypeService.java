package com.cyx.cyxdeboke.service;

import com.cyx.cyxdeboke.Entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TypeService {
    //后端,查出整个Type列表
    List<Type> listTypes();
    //后端,查出TypeId
    Type getType(Long typeId);
    //后端,查出整个Type列表
    List<Type> getAlltype();
    //前端,查询出所有分类和博客
    List<Type> listTypesAndBlogs();

    Type getTypeByName(String name);

    int saveType(Type type);

    int updateType(Type type);

    int deleteById(Long id);
}
