package com.squawk.webapp.models;

public class LikeComment {
    private Long likeCommentID;
    private Long userID;
    private Long commentID;

    public LikeComment(Long likeCommentID, Long userID, Long commentID) {
        this.likeCommentID = likeCommentID;
        this.userID = userID;
        this.commentID = commentID;
    }

    public LikeComment() {
    }

    public Long getLikeCommentID() {
        return likeCommentID;
    }

    public void setLikeCommentID(Long likeCommentID) {
        this.likeCommentID = likeCommentID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }
    
}
