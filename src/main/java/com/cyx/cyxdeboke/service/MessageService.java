package com.cyx.cyxdeboke.service;

import com.cyx.cyxdeboke.Entity.Comment;
import com.cyx.cyxdeboke.Entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    //找出整个留言板的留言
    List<Message> listMessages();
    //保存留言
    void saveMessage(Message message);
    //删除留言
    void deleteMessage(Long id);
    //通过查询前端传回来的评论分类id判断是不是父类
    Message ParentMessage(Long id);
}
