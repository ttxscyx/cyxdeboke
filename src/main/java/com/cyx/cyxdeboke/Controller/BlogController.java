package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.Entity.Admin;
import com.cyx.cyxdeboke.Entity.Blog;
import com.cyx.cyxdeboke.Entity.Type;
import com.cyx.cyxdeboke.queryVo.BlogQuery;
import com.cyx.cyxdeboke.queryVo.SearchBlog;
import com.cyx.cyxdeboke.queryVo.ShowBlog;
import com.cyx.cyxdeboke.service.BlogService;
import com.cyx.cyxdeboke.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/blogs/")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    //后端列表分页方法
    @RequestMapping("bloglist")
    public String listBlogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                            HttpServletRequest request) {
        //按照排序字段 倒叙排序
        String orderBy = "modifytime desc";
        //开始分页
        PageHelper.startPage(pageNum, 3, orderBy);
        List<BlogQuery> blogs = blogService.listBlogs();
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogs);

        if (blogs != null) {
            model.addAttribute("pageInfo", pageInfo);
            System.out.println(pageInfo);
        }
        List<Type> types = typeService.listTypes();
        model.addAttribute("types", types);
        System.out.println(types);
        return "admin/blog";
    }
    //后端列表搜索方法
    @PostMapping("blogs/search")
    public String search( @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                          SearchBlog searchBlog,Model model){
        List<SearchBlog> blogs = blogService.searchBlogs(searchBlog);
        PageHelper.startPage(pageNum, 10);
        PageInfo<SearchBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blog :: blogList";
    }
    //删除博客
    @GetMapping("deleteBlog/{id}/delete")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes attributes){
        int b = blogService.deleteBlogById(id);
        if (b == 0) {
            attributes.addFlashAttribute("message", "删除失败");
        } else {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/blogs/bloglist";
    }
    //跳转到新增页面
    @GetMapping("addblog")
    @CrossOrigin
    public String input(Model model) {
        model.addAttribute("types", typeService.listTypes());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }
    //新增方法
    @PostMapping("addblogs")
    public String post(Blog blog, RedirectAttributes attributes,
                       HttpSession session) {

        blog.setAdmin((Admin) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setTypeId(blog.getType().getId());
        blog.setAdminId(blog.getAdmin().getId());
        int b = blogService.saveBlog(blog);
        if (b == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/blogs/bloglist";
    }
    //跳转到博客编辑页面
    @GetMapping("/updateblog/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        ShowBlog blogById = blogService.getBlogById(id);
        List<Type> allType = typeService.getAlltype();
        System.out.println("alllllType："+allType);
        model.addAttribute("blog", blogById);
        model.addAttribute("types", allType);
        return "admin/blogs-input";
    }
    //编辑博客
    @PostMapping("/updateblog/{id}")
    public String editPost(@Valid ShowBlog showBlog, RedirectAttributes attributes) {
        int b = blogService.updateBlog(showBlog);
        if (b == 0) {
            attributes.addFlashAttribute("message", "修改失败");
        } else {
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/blogs/bloglist";
    }
    /*上传图片*/
    /*@ResponseBody
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public JSONObject hello(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {

        JSONObject jsonObject=new JSONObject();

        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String rootPath = request.getSession().getServletContext().getRealPath("/static/img/blog/");

            System.out.println("editormd上传图片："+rootPath);

            *//**
             * 文件路径不存在则需要创建文件路径
             *//*
            File filePath = new File(rootPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            // 最终文件名
            File realFile = new File(rootPath + File.separator + attach.getOriginalFilename());
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

            // 下面response返回的json格式是editor.md所限制的，规范输出就OK

            jsonObject.put("success", 1);
            jsonObject.put("message", "上传成功");
            jsonObject.put("url", "/MyPage/static/img/blog/"+attach.getOriginalFilename());
        } catch (Exception e) {
            jsonObject.put("success", 0);
        }

        return jsonObject;
    }*/
}
