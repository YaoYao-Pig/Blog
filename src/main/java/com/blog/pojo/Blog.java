package com.blog.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_blog")
public class Blog implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String firstPicture;//首图
    private String flag;//标记（转载原创)
    private Integer views;//浏览次数
    private Boolean appreciation;
    private Boolean shareStatement=true;//转载声明是否开启
    private Boolean commentable=true;
    private Boolean published;//发布还是草稿
    private Boolean recommend=true;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Transient
    private String tagIds;
    //Object
    //Blog为维护关系的一端
    @ManyToOne
    private Type type;
    @ManyToMany(cascade = {CascadeType.PERSIST})//级联新增，新增一个blog也会要求tag
    private List<Tag> tags=new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments=new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blog() {
    }
    public void init(){
        this.tagIds=tagToIds(this.getTags());
    }
    private String tagToIds(List<Tag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids=new StringBuffer();
            boolean flag=false;
            for(Tag tag:tags){
                if(flag){
                    ids.append(",");
                }
                else{
                    flag=true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }
    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPircture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentable=" + commentable +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFirstPicture(String firstPircture) {
        this.firstPicture = firstPircture;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public User getUser() {
        return user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Type getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public Integer getViews() {
        return views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public boolean isPublished() {
        return published;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    public void setShareStatement(Boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public void setCommentable(Boolean commentable) {
        this.commentable = commentable;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public Boolean getShareStatement() {
        return shareStatement;
    }

    public Boolean getCommentable() {
        return commentable;
    }

    public Boolean getPublished() {
        return published;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}
