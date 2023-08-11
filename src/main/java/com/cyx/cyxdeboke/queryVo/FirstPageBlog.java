package com.cyx.cyxdeboke.queryVo;

import java.util.Date;

//博客首页数据实体类
public class FirstPageBlog {
    //Blog
    private Long id;
    private String title;
    private String img1;
    private String content;
    private Integer commentCount;
    private Date releasetime;

    //Type
    private String typeName;
    private String typeId;

    //Admin
    private String name;

    public FirstPageBlog() {
    }

    @Override
    public String toString() {
        return "FirstPageBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img1='" + img1 + '\'' +
                ", content='" + content + '\'' +
                ", commentCount=" + commentCount +
                ", releasetime=" + releasetime +
                ", typeName='" + typeName + '\'' +
                ", typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FirstPageBlog(Long id, String title, String img1, String content, Integer commentCount, Date releasetime, String typeName, String typeId, String name) {
        this.id = id;
        this.title = title;
        this.img1 = img1;
        this.content = content;
        this.commentCount = commentCount;
        this.releasetime = releasetime;
        this.typeName = typeName;
        this.typeId = typeId;
        this.name = name;
    }
}
