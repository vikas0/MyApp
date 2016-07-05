
package com.vikaspandey.myapp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vikaspandey.myapp.db.Forum;
import com.vikaspandey.myapp.db.Topic;
import com.vikaspandey.myapp.db.User;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("text_raw")
    @Expose
    private String textRaw;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("like_count")
    @Expose
    private Integer likeCount;
    @SerializedName("post_like_status")
    @Expose
    private Boolean postLikeStatus;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("topic")
    @Expose
    private Topic topic;
    @SerializedName("forum")
    @Expose
    private Forum forum;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The textRaw
     */
    public String getTextRaw() {
        return textRaw;
    }

    /**
     * 
     * @param textRaw
     *     The text_raw
     */
    public void setTextRaw(String textRaw) {
        this.textRaw = textRaw;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The likeCount
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * 
     * @param likeCount
     *     The like_count
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * 
     * @return
     *     The postLikeStatus
     */
    public Boolean getPostLikeStatus() {
        return postLikeStatus;
    }

    /**
     * 
     * @param postLikeStatus
     *     The post_like_status
     */
    public void setPostLikeStatus(Boolean postLikeStatus) {
        this.postLikeStatus = postLikeStatus;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The topic
     */
    public Topic getTopic() {
        return topic;
    }

    /**
     * 
     * @param topic
     *     The topic
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * 
     * @return
     *     The forum
     */
    public Forum getForum() {
        return forum;
    }

    /**
     * 
     * @param forum
     *     The forum
     */
    public void setForum(Forum forum) {
        this.forum = forum;
    }

}
