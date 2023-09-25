package com.abc.jdbc.util.sql;

public class SqlQuery {
    public String membersDAOAddMember() {
        return "INSERT INTO MEMBERS (INPUTID, PASSWORD, NAME) VALUES (?, ?, ?)";
    }
    public String membersDAOLogin() {
        return "SELECT * FROM MEMBERS WHERE INPUTID = ? AND PASSWORD = ?";
    }
    public String membersDAOGetAllMembers() {
        return "SELECT * FROM MEMBERS";
    }

    public String postsDAOAddPost() {
        return "INSERT INTO Posts (TITLE, CONTENT, MEMBERSID) VALUES (?, ?, ?)";
    }
    public String postsDAOGetAllPosts() {
        return "SELECT * FROM POSTS";
    }
    public String postsDAOEnterPost() {
        return "SELECT * FROM POSTS WHERE ID = ?";
    }
    public String postsDAOModifyTitle() {
        return "update posts set title = ? WHERE id = ?";
    }
    public String postsDAOModifyContent() {
        return "update posts set content = ? WHERE id = ?";
    }

    public String commentsDAOAddComment() {
        return "INSERT INTO COMMENTS (POSTSID, MEMBERSID, COMMENTSTEXT) VALUES (?, ?, ?)";
    }
    public String commentsDAOGetCommentsByPostId() {
        return "SELECT ID, NAME, COMMENTSTEXT, COMMENTSTIME FROM COMMENTS WHERE POSTSID = ?";
    }
    public String commentsDAOCommentModify() {
        return "UPDATE COMMENTS SET COMMENTSTEXT = ? WHERE ID = ?";
    }

    public String likesDAOAddLike() {
        return "INSERT INTO LIKES (POSTSID, MEMBERSID) VALUES (?, ?)";
    }







}
