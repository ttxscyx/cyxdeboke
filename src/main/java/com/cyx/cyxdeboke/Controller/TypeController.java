package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.Entity.Type;
import com.cyx.cyxdeboke.service.BlogService;
import com.cyx.cyxdeboke.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types")
    public String listTypes(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        //按照排序字段 倒叙排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Type> types = typeService.listTypes();

        if (types != null) {
            PageInfo<Type> pageInfo = new PageInfo<>(types);
            model.addAttribute("pageInfo", pageInfo);
        }
        return "admin/types";
    }

    //跳转到输入页面
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    //新增分类
    @PostMapping("/types")
    public String post(@Valid Type type, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复分类");
            return "redirect:/types/types/input";
        }

        int b = typeService.saveType(type);
        if (b == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/types/types";
    }

    //跳转到分类编辑页面
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    //编辑保存
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, RedirectAttributes attributes) {
        int t = typeService.updateType(type);
        if (t == 0) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/types/types";
    }

    //删除分类
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id, RedirectAttributes attributes) {
        //查询Tpye表有没有的内容有没有被blog表引用,没有可以删除
        int blog= blogService.Typeslistblog(id);
        System.out.println("blog="+blog);
        //blog!=0时代表有博客使用了该类型,不可删除,反之可以删除
        if (blog != 0) {
            attributes.addFlashAttribute("message", "删除失败,有博客绑定该分类！");
        } else {
             typeService.deleteById(id);
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/types/types";
    }
}
