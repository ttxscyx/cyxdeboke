package com.cyx.cyxdeboke.queryVo;

import java.util.Date;
//时间轴实体类
public class ArchiveBlog {

    private Long id;
    private String title;
    private Date releasetime;

    @Override
    public String toString() {
        return "ArchiveBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releasetime=" + releasetime +
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

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public ArchiveBlog() {
    }

    public ArchiveBlog(Long id, String title, Date releasetime) {
        this.id = id;
        this.title = title;
        this.releasetime = releasetime;
    }
}
