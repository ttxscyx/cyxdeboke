package com.cyx.cyxdeboke.config;

import com.cyx.cyxdeboke.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器拦截路径
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminLoginInterceptor());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns(    //添加不拦截路径
                "/admin",                    //登录方法路径
                "/logout",                   //注销方法路径
                "/index","/",                //首页页面方法路径
                "/blog",                     //博客页面方法路径
                "/archives",                 //前端时间轴页面跳转路径
                "/message",                  //前端留言页面跳转路径
                "/messagecomment",           //前端留言页面跳转路径
                "/types/**",                 //前端分类页面跳转路径
                "/about",                    //前端关于页面跳转路径
                "/indexblog/**",             //前端跳转到博客详情页面
                "/comments/**",              //前端评论方法
                "/comments",                 //前端评论方法
                "/search",                   //前端搜索方法
         "/comment/{blogId}/{id}/delete",    //前端删除评论方法
         "/messages/{id}/delete",            //前端留言板删除留言方法
                "/footer/blogmessage",       //前端查询底部栏博客信息
                "/blogs/**",                 //博客后台的所有方法
                "/adminindex",               //后端首页方法路径
                "/**/*.html",                //html静态资源
                "/**/*.js",                  //js静态资源
          "/**/*.eot","/**/*.svg",           //Editor.md图标资源
          "/**/*.ttf","/**/*.woff",          //Editor.md图标资源
          "/**/*.otf","/**/*.woff2",         //Editor.md图标资源
                "/**/*.json",                //Editor.md图标资源(github emoji)
    "/**/*.jpg","/**/*.png","/**/*.mp4",     //图片视频资源
                "/**/*.css"                //css静态资源

                );
    }
}
