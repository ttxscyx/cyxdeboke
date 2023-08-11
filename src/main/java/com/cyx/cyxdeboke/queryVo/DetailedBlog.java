package com.cyx.cyxdeboke.queryVo;

import com.cyx.cyxdeboke.Entity.Comment;

import java.util.Date;
//博客详情实体类
public class DetailedBlog {
    private Long id;
    private String img1;
    private String title;
    private String content;
    private Integer commentCount;
    private Date releasetime;
    private boolean commentabled;
    private String name;
    private String typeName;

    public DetailedBlog() {
    }

    @Override
    public String toString() {
        return "DetailedBlog{" +
                "id=" + id +
                ", img1='" + img1 + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentCount=" + commentCount +
                ", releasetime=" + releasetime +
                ", commentabled=" + commentabled +
                ", name='" + name + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public DetailedBlog(Long id, String img1, String title, String content, Integer commentCount, Date releasetime, boolean commentabled, String name, String typeName) {
        this.id = id;
        this.img1 = img1;
        this.title = title;
        this.content = content;
        this.commentCount = commentCount;
        this.releasetime = releasetime;
        this.commentabled = commentabled;
        this.name = name;
        this.typeName = typeName;
    }
}
