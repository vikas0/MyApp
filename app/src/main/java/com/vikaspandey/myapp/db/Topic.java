package com.vikaspandey.myapp.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "TOPIC".
 */
@Entity
public class Topic {
    @SerializedName("id")
    @Expose
    @Id
    private Long id;
    @SerializedName("fpd_flag")
    @Expose
    private Boolean fpd_flag;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("forum_name")
    @Expose
    private String forum_name;
    @SerializedName("share_url")
    @Expose
    private String share_url;
    @SerializedName("updated_at")
    @Expose
    private String updated_at;
    @SerializedName("view_count")
    @Expose
    private Integer view_count;
    @SerializedName("posts_count")
    @Expose
    private Integer posts_count;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("front_page_suggestions_count")
    @Expose
    private Integer front_page_suggestions_count;
    @SerializedName("last_activity_at")
    @Expose
    private Long last_activity_at;

    @Generated
    public Topic() {
    }

    public Topic(Long id) {
        this.id = id;
    }

    @Generated
    public Topic(Long id, Boolean fpd_flag, String title, String forum_name, String share_url, String updated_at, Integer view_count, Integer posts_count, Integer score, Integer front_page_suggestions_count, Long last_activity_at) {
        this.id = id;
        this.fpd_flag = fpd_flag;
        this.title = title;
        this.forum_name = forum_name;
        this.share_url = share_url;
        this.updated_at = updated_at;
        this.view_count = view_count;
        this.posts_count = posts_count;
        this.score = score;
        this.front_page_suggestions_count = front_page_suggestions_count;
        this.last_activity_at = last_activity_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFpd_flag() {
        return fpd_flag;
    }

    public void setFpd_flag(Boolean fpd_flag) {
        this.fpd_flag = fpd_flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForum_name() {
        return forum_name;
    }

    public void setForum_name(String forum_name) {
        this.forum_name = forum_name;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getPosts_count() {
        return posts_count;
    }

    public void setPosts_count(Integer posts_count) {
        this.posts_count = posts_count;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getFront_page_suggestions_count() {
        return front_page_suggestions_count;
    }

    public void setFront_page_suggestions_count(Integer front_page_suggestions_count) {
        this.front_page_suggestions_count = front_page_suggestions_count;
    }

    public Long getLast_activity_at() {
        return last_activity_at;
    }

    public void setLast_activity_at(Long last_activity_at) {
        this.last_activity_at = last_activity_at;
    }

}
