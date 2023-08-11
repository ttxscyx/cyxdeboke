package com.cyx.cyxdeboke.service.Impl;

import com.cyx.cyxdeboke.Entity.Blog;
import com.cyx.cyxdeboke.NotFountException;
import com.cyx.cyxdeboke.mapper.BlogMapper;
import com.cyx.cyxdeboke.queryVo.*;
import com.cyx.cyxdeboke.service.BlogService;
import com.cyx.cyxdeboke.util.MarkdownUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Override
    //后端,列表分页方法调用时,查出对应数据
    public List<BlogQuery> listBlogs() {
        return blogMapper.listBlogs();
    }

    @Override
    //后端,列表搜索方法调用时,查出对应数据
    public List<SearchBlog> searchBlogs(SearchBlog searchBlog) {
        return blogMapper.searchBlogs(searchBlog);
    }

    @Override
    //后端,列表删除方法调用时,删除对应数据
    public int deleteBlogById(Long id) {
        return blogMapper.deleteBlogById(id);
    }


    @Override
    //后端,新增保存博客
    public int saveBlog(Blog blog) {
        blog.setModifytime(new Date());
        blog.setReleasetime(new Date());
        blog.setCommentCount(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    //后端,通过前端传回来的id搜索出对应的数据
    public ShowBlog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    //后端,编辑博客
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setModifytime(new Date());
        return blogMapper.updateBlog(showBlog);
    }

    @Override
    //后端,查询Tpye表有没有的内容有没有被blog表引用,没有可以删除
    public int Typeslistblog(Long id) {
        return blogMapper.Typeslistblog(id);
    }

    @Override
    //前端,将第一页博客展示出来
    public List<FirstPageBlog> getFirstPageBlogs() {
        return blogMapper.getFirstPageBlogs();
    }

    @Override
    //前端,根据id查出DetailedBlog
    public DetailedBlog getDetailedBlogById(Long id) {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlogById(id);
        if (detailedBlog==null){
            throw new NotFountException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogMapper.getCommentCountById(id);
        return detailedBlog;
    }
    @Override
    //前端查询博客总数量
    public Integer getBlogTotal() {
        return blogMapper.getBlogTotal();
    }

    @Override
    //前端查询评论总数
    public Integer getBlogCommentTotal() {
        return blogMapper.getBlogCommentTotal();
    }

    @Override
    //前端查询留言总数
    public Integer getBlogMessageTotal() {
        return blogMapper.getBlogMessageTotal();
    }

    @Override
    //前端搜索博客
    public List<FirstPageBlog> getSearchBlogs(String query) {
        return blogMapper.getSearchBlogs(query);
    }

    @Override
    //根据分类id获取博客
    public List<FirstPageBlog> getBlogsByTypeId(Long id) {
        return blogMapper.getBlogsByTypeId(id);
    }

    @Override
    //查询时间轴博客信息
    public List<ArchiveBlog> getArchiveBlogs() {
        return blogMapper.getArchiveBlogs();
    }

}
