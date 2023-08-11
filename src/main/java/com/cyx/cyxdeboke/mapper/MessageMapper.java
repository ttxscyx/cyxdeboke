package com.cyx.cyxdeboke.mapper;

import com.cyx.cyxdeboke.Entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {
    //添加一个评论
    int saveMessage(Message message);
    //查询父级评论
    List<Message> findByParentIdNull(@Param("ParentId") Long ParentId);
    //查询一级回复
    List<Message> findByParentIdNotNull(@Param("id") Long id);
    //查询二级以及所有子集回复
    List<Message> findByReplayId(@Param("childId") Long childId);
    //删除评论
    void deleteMessage(Long id);
    //通过查询前端传回来的评论分类id判断是不是父类
    Message ParentMessage(@Param("id") Long id);
}
