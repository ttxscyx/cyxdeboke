package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.Entity.Admin;
import com.cyx.cyxdeboke.service.AdminService;
import com.cyx.cyxdeboke.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    //后端登录页面跳转
    @RequestMapping(value = "admin",method = RequestMethod.GET)
    public String admin(){
        return "admin/login";
    }
    //后端首页页面跳转
    @RequestMapping(value = {"adminindex"},method = RequestMethod.GET)
    public String adminindex(){
        return "admin/index";
    }
    //后端登录方法
    @RequestMapping(value = {"admin"},method = RequestMethod.POST)
    public String login1(@RequestParam("username")String username, @RequestParam("password")String password,
                        Model model, HttpServletRequest request) {
        Admin admin = adminService.getPwdByUsername(username);
        String pwd = admin.getPassword();
        //二次加密
        String password1 = MD5Utils.md5Code(password).toUpperCase();
        String password2 = MD5Utils.md5Code(password1).toUpperCase();
        System.out.println(pwd);
        System.out.println(password2);
        if (pwd.equals(password2)) {
            model.addAttribute("admin", admin);
            request.getSession().setAttribute("user", admin);
            System.out.println(admin);
        //后端登录页面跳转密码正确跳转至adminindex方法进入admin/index
            return "redirect:/adminindex";
        } else {

            System.out.println("------账号名称或密码不正确------");
            //后端登录页面跳转密码错误跳转至admin方法进入admin/login
            return "redirect:/admin";
        }
    }
    //注销功能
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "admin/login";
    }
}