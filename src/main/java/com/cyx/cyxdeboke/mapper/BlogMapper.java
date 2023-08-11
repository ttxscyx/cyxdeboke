package com.cyx.cyxdeboke.mapper;

import com.cyx.cyxdeboke.Entity.Blog;
import com.cyx.cyxdeboke.queryVo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {
    //后端,列表分页方法调用时,查出对应数据
    List<BlogQuery> listBlogs();
    //后端,列表搜索方法调用时,查出对应数据
    List<SearchBlog> searchBlogs(SearchBlog searchBlog);
    //后端,列表删除方法调用时,删除对应数据
    int deleteBlogById(Long id);
    //后端,新增保存博客
    int saveBlog(Blog blog);
    //后端,通过前端传回来的id搜索出对应的数据
    ShowBlog getBlogById(Long id);
    //后端,编辑博客
    int updateBlog(ShowBlog showBlog);
    //后端,查询Tpye表有没有的内容有没有被blog表引用,没有可以删除
    int Typeslistblog(Long id);
    //前端,将第一页博客展示出来
    List<FirstPageBlog> getFirstPageBlogs();
    //前端,根据id查出DetailedBlog
    DetailedBlog getDetailedBlogById(Long id);
    //查询出文章评论数量并更新
    void getCommentCountById(Long id);
    //前端查询博客总数量
    Integer getBlogTotal();
    //前端查询访问总数
    /*Integer getBlogViewTotal();*/
    //前端查询评论总数
    Integer getBlogCommentTotal();
    //前端查询留言总数
    Integer getBlogMessageTotal();
    //前端搜索博客
    List<FirstPageBlog> getSearchBlogs(String query);
    //根据分类id获取博客
    List<FirstPageBlog> getBlogsByTypeId(Long id);
    //查询时间轴博客信息
    List<ArchiveBlog> getArchiveBlogs();
}
