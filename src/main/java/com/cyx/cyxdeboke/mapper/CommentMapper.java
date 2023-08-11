package com.cyx.cyxdeboke.mapper;

import com.cyx.cyxdeboke.Entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    //根据创建时间倒序来排
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);
    //查询一级回复
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);
    //查询二级回复
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId,@Param("childId") Long childId);
    //保存评论
    void saveComment(Comment comment);
    //删除评论
    void deleteComment(Long id);
    //通过查询前端传回来的评论分类id判断是不是父类
    Comment ParentComment(@Param("id") Long id);
}
