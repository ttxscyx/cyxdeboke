package com.cyx.cyxdeboke.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="blog")
public class Blog {
    private Long id;
    private Admin admin;
    private String title;
    private String content;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;
    private String img6;
    private boolean commentabled;
    private Date releasetime;
    private Date modifytime;
    private Integer commentCount;
    private Comment comment;
    private Type type;
    private Long TypeId;
    private Long AdminId;
    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", admin=" + admin +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", img3='" + img3 + '\'' +
                ", img4='" + img4 + '\'' +
                ", img5='" + img5 + '\'' +
                ", img6='" + img6 + '\'' +
                ", commentabled=" + commentabled +
                ", releasetime=" + releasetime +
                ", modifytime=" + modifytime +
                ", commentCount=" + commentCount +
                ", comment=" + comment +
                ", type=" + type +
                ", TypeId=" + TypeId +
                ", AdminId=" + AdminId +
                '}';
    }

    public Blog(Long id, Admin admin, String title, String content, String img1, String img2, String img3, String img4, String img5, String img6, boolean commentabled, Date releasetime, Date modifytime, Integer commentCount, Comment comment, Type type, Long typeId, Long adminId) {
        this.id = id;
        this.admin = admin;
        this.title = title;
        this.content = content;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.img5 = img5;
        this.img6 = img6;
        this.commentabled = commentabled;
        this.releasetime = releasetime;
        this.modifytime = modifytime;
        this.commentCount = commentCount;
        this.comment = comment;
        this.type = type;
        TypeId = typeId;
        AdminId = adminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public String getImg6() {
        return img6;
    }

    public void setImg6(String img6) {
        this.img6 = img6;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getTypeId() {
        return TypeId;
    }

    public void setTypeId(Long typeId) {
        TypeId = typeId;
    }

    public Long getAdminId() {
        return AdminId;
    }

    public void setAdminId(Long adminId) {
        AdminId = adminId;
    }
}
