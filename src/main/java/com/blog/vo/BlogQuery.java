package com.blog.vo;

public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;

    public BlogQuery() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public String getTitle() {
        return title;
    }

    public Long getTypeId() {
        return typeId;
    }

}
