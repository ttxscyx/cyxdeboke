package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.Entity.Admin;
import com.cyx.cyxdeboke.Entity.Comment;
import com.cyx.cyxdeboke.queryVo.DetailedBlog;
import com.cyx.cyxdeboke.queryVo.FirstPageBlog;
import com.cyx.cyxdeboke.service.AdminService;
import com.cyx.cyxdeboke.service.BlogService;
import com.cyx.cyxdeboke.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class IndexShowController {
    @Autowired
    BlogService blogService;
    @Autowired
    AdminService adminService;
    @Autowired
    CommentService commentService;
    //跳转到首页页面
    @RequestMapping({"", "index"})
    public String index(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,3);
        //第一页博客展示
        List<FirstPageBlog> firstPageBlogs = blogService.getFirstPageBlogs();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlogs);
        System.out.println("pageInfo====="+pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        return "blog/index";
    }

    //跳转到博客详情页面
    @GetMapping("indexblog/{id}")
    public String blog(@PathVariable Long id, Model model){
        DetailedBlog blog = blogService.getDetailedBlogById(id);
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("blog",blog);
        model.addAttribute("comments",comments);
        return "blog/blog";
    }

    //搜索博客
    @PostMapping("/search")
    public String search(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(name = "query")String query,Model model){
        PageHelper.startPage(pageNum,1000);
        List<FirstPageBlog> blogs = blogService.getSearchBlogs(query);
        System.out.println("blogs="+blogs);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        return "blog/search";
    }

    //查询底部栏博客信息
    @RequestMapping("footer/blogmessage")
    public String blogMessage(Model model){
        int blogTotal = blogService.getBlogTotal();
        model.addAttribute("blogTotal",blogTotal);
        System.out.println("blogTotal="+blogTotal);
        int blogCommentTotal = blogService.getBlogCommentTotal();
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        int blogMessageTotal = blogService.getBlogMessageTotal();
        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "blog/index :: blogMessage";
    }
}
