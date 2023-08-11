package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.queryVo.ArchiveBlog;
import com.cyx.cyxdeboke.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;
    //跳转到时间轴页面
    @GetMapping("/archives")
    public String archives(Model model){

        List<ArchiveBlog> archiveBlogs = blogService.getArchiveBlogs();
        model.addAttribute("blogs",archiveBlogs);

        return "blog/archives";
    }
}
