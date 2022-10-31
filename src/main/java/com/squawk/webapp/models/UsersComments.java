package com.squawk.webapp.models;

public class UsersComments {
    private Long userID;
    private Long commentID;

    public UsersComments(Long userID, Long commentID) {
        this.userID = userID;
        this.commentID = commentID;
    }

    public UsersComments() {
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
