package com.cyx.cyxdeboke.queryVo;

//搜索博客管理列表
public class SearchBlog {

    private String title;
    private Long typeId;

    public SearchBlog(String title, Long typeId) {
        this.title = title;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "SearchBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public SearchBlog() {
    }
}

