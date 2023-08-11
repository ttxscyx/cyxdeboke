package com.cyx.cyxdeboke.service.Impl;

import com.cyx.cyxdeboke.Entity.Message;
import com.cyx.cyxdeboke.mapper.MessageMapper;
import com.cyx.cyxdeboke.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    //存放迭代找出的所有子代的集合
    private List<Message> tempReplys = new ArrayList<>();

    /**
     * @Description: 查询留言
     * @Auther:
     * @Date:
     * @Param:
     * @Return: 留言消息
     */
    @Override
    //找出整个留言板的留言
    public List<Message> listMessages() {
        //查询出父节点
        List<Message> messages = messageMapper.findByParentIdNull(Long.parseLong("-1"));
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = messageMapper.findByParentIdNotNull(id);
            //查询出子留言
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    /**
     * @Description: 查询出子留言
     * @Auther:
     * @Date:
     * @Param: childMessages：所有子留言
     * @Param: parentNickname1：父留言的姓名
     * @Return:
     */
    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子回复
        if(childMessages.size() > 0){
            //循环找出子留言的id
            for(Message childMessage : childMessages){
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }

    /**
     * @Description: 循环迭代找出子集回复
     * @Auther:
     * @Date:
     * @Param: childId：子留言的id
     * @Param: parentNickname1：子留言的姓名
     * @Return:
     */
    private void recursively(Long childId, String parentNickname1) {
        //根据子一级留言的id找到子二级留言
        List<Message> replayMessages = messageMapper.findByReplayId(childId);

        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                //循环迭代找出子集回复
                recursively(replayId,parentNickname);
            }
        }
    }

    @Override
    //保存留言
    public void saveMessage(Message message) {
        message.setCreateTime(new Date());
        messageMapper.saveMessage(message);
    }

    @Override
    //删除留言
    public void deleteMessage(Long id) {
        messageMapper.deleteMessage(id);
    }

    @Override
    //通过查询前端传回来的评论分类id判断是不是父类
    public Message ParentMessage(Long id) {
        return messageMapper.ParentMessage(id);
    }
}
