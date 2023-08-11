package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.Entity.Type;
import com.cyx.cyxdeboke.queryVo.BlogQuery;
import com.cyx.cyxdeboke.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class actionController {
    //前端博客页面跳转
    @RequestMapping("blog")
    public String blog(){
        return "blog/blog";
    }
    //前端关于页面跳转
    @RequestMapping("about")
    public String about(){
        return "blog/about";
    }
    //前端联系页面跳转
    @RequestMapping("contact")
    public String contact(){
        return "blog/contact";
    }
}
