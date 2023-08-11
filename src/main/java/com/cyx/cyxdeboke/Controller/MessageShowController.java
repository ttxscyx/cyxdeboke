package com.cyx.cyxdeboke.Controller;

import com.cyx.cyxdeboke.Entity.Admin;
import com.cyx.cyxdeboke.Entity.Comment;
import com.cyx.cyxdeboke.Entity.Message;
import com.cyx.cyxdeboke.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageShowController {

    @Autowired
    private MessageService messageService;

    @Value("${message.avatar}")
    private String avatar;

    @Value("${spring.mail.from}")
    private String emailFrom;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private TemplateEngine templateEngine;
    //留言页面展示
    @GetMapping("/message")
    public String Message() {
        return "blog/message";
    }

    //异步查询留言信息
    @GetMapping("/messagecomment")
    public String messages(Model model) {
        //TODO 有Bug 查询不到留言信息
        List<Message> messages = messageService.listMessages();
        System.out.println(messages);
        model.addAttribute("messages", messages);
        return "blog/message :: messageList";
    }

    //保存留言
    @PostMapping("/message")
    public String post(Message message, HttpSession session, Model model) throws MessagingException {
        Admin admin = (Admin) session.getAttribute("user");
        //设置头像
        if (admin != null) {
            message.setAdminMessage(true);
        } else {
            message.setAvatar(avatar);
        }
        if (message.getParentMessage().getId() != null) {
            message.setParentMessageId(message.getParentMessage().getId());
        }
        System.out.println("准备保存留言");
        messageService.saveMessage(message);
        List<Message> messages = messageService.listMessages();
        System.out.println("保存完毕查询留言: "+messages);
        model.addAttribute("messages", messages);

        //判断该评论是不是父类评论,是的话不需要发送邮件
        if(message.getParentMessage().getId() != -1) {

            Message messageList = messageService.ParentMessage(message.getParentMessage().getId());

            System.out.println("commentList====" + messageList);
            // 创建邮件内容
            // 通过 Context 构造模版中变量需要的值
            Context ctx = new Context();

            ctx.setVariable("tts", messageList.getEmail());
            // 使用TemplateEngine 对模版进行渲染
            String mail1 = templateEngine.process("blog/mailtemplate.html", ctx);
            //创建MimeMessage对象
            MimeMessage message1 = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message1, true);
            helper.setSubject("测试邮件");//设置邮件的主题
            helper.setFrom(emailFrom);//发邮件的邮箱地址，从资源可直接提取
            helper.setTo(messageList.getEmail());//给谁发，通过参数进行传递
            helper.setText(mail1, true);//设置邮件的文本内容
            // 发送邮件
            javaMailSender.send(message1);
        }

        return "blog/message :: messageList";
    }

    @GetMapping("/messages/{id}/delete")
    public String deleteMessage(@PathVariable Long id, Model model){
        messageService.deleteMessage(id);
        List<Message> messages = messageService.listMessages();
        model.addAttribute("messages",messages);
        return "redirect:/message";
    }
}
