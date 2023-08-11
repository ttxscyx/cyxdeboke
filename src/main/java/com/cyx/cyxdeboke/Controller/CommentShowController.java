package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.Entity.Admin;
import com.cyx.cyxdeboke.Entity.Comment;
import com.cyx.cyxdeboke.mapper.CommentMapper;
import com.cyx.cyxdeboke.queryVo.DetailedBlog;
import com.cyx.cyxdeboke.service.BlogService;
import com.cyx.cyxdeboke.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentShowController {

    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    CommentMapper commentMapper;
    @Value("${spring.mail.from}")
    private String emailFrom;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
    //查询评论列表
    @GetMapping("comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        System.out.println(blogId);
        System.out.println("comments======="+comments);
        model.addAttribute("comments", comments);
        return "blog/blog :: commentList";
    }
    //新增评论
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session, Model model) throws MessagingException {
        Long blogId = comment.getBlogId();
        Admin admin = (Admin) session.getAttribute("user");
        if (admin != null) {
            comment.setAdminComment(true);
        } else {
            System.out.println("输出1");
        }
        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);

        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);

        //判断该评论是不是父类评论,是的话不需要发送邮件
        if(comment.getParentComment().getId() != -1){

        Comment commentList = commentService.ParentComment(comment.getParentComment().getId());

         System.out.println("commentList===="+commentList);
        // 创建邮件内容
        // 通过 Context 构造模版中变量需要的值
        Context ctx = new Context();

        ctx.setVariable("tts", commentList.getEmail());
        // 使用TemplateEngine 对模版进行渲染
        String mail1 = templateEngine.process("blog/mailtemplate.html", ctx);
        //创建MimeMessage对象
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("测试邮件");//设置邮件的主题
        helper.setFrom(emailFrom);//发邮件的邮箱地址，从资源可直接提取
        helper.setTo(commentList.getEmail());//给谁发，通过参数进行传递
        helper.setText(mail1, true);//设置邮件的文本内容
        // 发送邮件
        javaMailSender.send(message);

}
        return "blog/blog :: commentList";
    }

    //删除评论
    @GetMapping("comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId, @PathVariable Long id, Comment comment, RedirectAttributes attributes, Model model){
        commentService.deleteComment(comment,id);
        DetailedBlog detailedBlog = blogService.getDetailedBlogById(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "redirect:/indexblog/{blogId}";
    }
}
