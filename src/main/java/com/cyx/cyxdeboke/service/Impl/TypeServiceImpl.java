package com.cyx.cyxdeboke.service.Impl;

import com.cyx.cyxdeboke.Entity.Type;
import com.cyx.cyxdeboke.mapper.TypeMapper;
import com.cyx.cyxdeboke.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    //后端,查出整个Type列表
    public List<Type> listTypes() {
        return typeMapper.listTypes();
    }

    @Override
    //后端,查出TypeId
    public Type getType(Long typeId) {
        return typeMapper.getType(typeId);
    }

    @Override
    //后端,查出整个Type列表
    public List<Type> getAlltype() {
        return typeMapper.listTypes();
    }

    @Override
    //前端,查询出所有分类和博客
    public List<Type> listTypesAndBlogs() {
        return typeMapper.listTypesAndBlogs();
    }

    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int deleteById(Long id) {
        return typeMapper.deleteById(id);
    }


}
