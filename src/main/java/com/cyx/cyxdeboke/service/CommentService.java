package com.cyx.cyxdeboke.service;

import com.cyx.cyxdeboke.Entity.Comment;
import com.cyx.cyxdeboke.queryVo.DetailedBlog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    //根据传回来的博客id找到该博客的评论
    List<Comment> listCommentByBlogId(Long id);
    //保存评论
    void saveComment(Comment comment);
    //删除评论
    void deleteComment(Comment comment, Long id);
    //通过查询前端传回来的评论分类id判断是不是父类
    Comment ParentComment(Long id);
}
