package com.cyx.cyxdeboke.queryVo;

import com.cyx.cyxdeboke.Entity.Type;
//显示数据实体类
public class BlogQuery {
    private Long id;
    private String title;
    private String modifytime;
    private Type type;
    private Long typeId;
    public BlogQuery() {
    }

    public BlogQuery(Long id, String title, String modifytime, Type type, Long typeId) {
        this.id = id;
        this.title = title;
        this.modifytime = modifytime;
        this.type = type;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", modifytime='" + modifytime + '\'' +
                ", type=" + type +
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

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
