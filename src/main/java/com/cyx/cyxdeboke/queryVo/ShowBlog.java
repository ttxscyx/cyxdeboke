package com.cyx.cyxdeboke.queryVo;

import java.util.Date;

//编辑修改文章实体类
public class ShowBlog {
    private Long id;
    private String title;
    private String content;
    private Date modifytime;
    private String releasetime;
    private String img1;
    private boolean commentabled;
    private Long typeId;

    @Override
    public String toString() {
        return "ShowBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", modifytime=" + modifytime +
                ", releasetime='" + releasetime + '\'' +
                ", img1='" + img1 + '\'' +
                ", commentabled=" + commentabled +
                ", typeId=" + typeId +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public ShowBlog() {
    }

    public ShowBlog(Long id, String title, String content, Date modifytime, String releasetime, String img1, boolean commentabled, Long typeId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modifytime = modifytime;
        this.releasetime = releasetime;
        this.img1 = img1;
        this.commentabled = commentabled;
        this.typeId = typeId;
    }
}
