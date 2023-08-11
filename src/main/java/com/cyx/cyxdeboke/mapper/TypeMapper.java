package com.cyx.cyxdeboke.mapper;

import com.cyx.cyxdeboke.Entity.Type;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TypeMapper {
    //后端,查出整个Type列表
    List<Type> listTypes();
    //后端,查出TypeId
    Type getType(Long typeId);
    //前端,查询出所有分类和博客
    List<Type> listTypesAndBlogs();

    int saveType(Type type);

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteById(Long id);
}
