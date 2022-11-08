package com.example.project_a;

public class CommentItem {
    String userId;
    String comment;
    String commentTime;
    float star;

    public CommentItem(String userId, String comment, String commentTime, float star) {
        this.userId = userId;
        this.comment = comment;
        this.commentTime = commentTime;
        this.star = star;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
