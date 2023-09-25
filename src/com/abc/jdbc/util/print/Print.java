package com.abc.jdbc.util.print;

import com.abc.jdbc.dto.CommentsDTO;
import com.abc.jdbc.dto.PostsDTO;

import java.sql.SQLException;
import java.util.List;

public class Print {

    // ================================================================================
    // path : com/abc/jdbc/main/Main.java
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    // ================================================================================
    // path : com/abc/jdbc/util/DatabaseConnection.java
    public void databaseConnectionError(Exception e) {
        System.out.println("DatabaseConnection Error! : " + e);
    }

    // ================================================================================
    // path : com/abc/jdbc/util/object/menu/Menu.java
    public static void loginMenu() { System.out.print("[1]회원가입 [2]로그인 [3]종료 : "); }

    public void boardMenu() {
        System.out.print("[1]글쓰기 [2]글 목록보기 [3]로그아웃 : ");
    }

    public void logout() { System.out.println("로그아웃 되었습니다.");}

    // ================================================================================
    // path : com/abc/jdbc/util/option/Options.java
    public void optionError() {
        System.out.println("잘못 입력하셨습니다.");
    }

    // ================================================================================
    // path : com/abc/jdbc/dao/MembersDAO.java
    public void successAddMember() {
        System.out.println("회원이 추가되었습니다!");
    }

    public void successLogin() {
        System.out.println("로그인 성공!");
    }

    public void failLogin() {
        System.out.println("로그인 실패 : 아이디 또는 비밀번호가 올바르지 않습니다.");
    }

    public void hasNotAsMembers() {
        System.out.println("등록된 회원이 없습니다.");
    }

    public void membersDAOAddMemberError(Exception e) {
        System.out.println("MembersDAO addMember Error! : " + e);
    }

    public void membersDAOLoginError(Exception e) {
        System.out.println("MembersDAO login Error! : " + e);
    }

    public void memberDAOGetAllMembersError(Exception e) { System.out.println("MemberDAO getAllMembers Error! : " + e); }

    public void membersDAOCloseError(Exception e) {
        System.out.println("MembersDAO close Error! : " + e);
    }

    // ================================================================================
    // path : com/abc/jdbc/dao/PostsDAO.java
    public void postDAOSuccessModifyTitle() {
        System.out.println("제목이 성공적으로 수정되었습니다.");
    }

    public void postDAOFailModifyTitle() {
        System.out.println("제목 수정에 실패했습니다.");
    }

    public void postDAOSuccessModifyContent() {
        System.out.println("내용이 성공적으로 수정되었습니다.");
    }

    public void postDAOFailModifyContent() {
        System.out.println("내용 수정에 실패했습니다.");
    }

    public void postDAOAddPostError(Exception e) {
        System.out.println("PostsDAO addPost Error! : " + e);
    }

    public void postDAOGetAllPostError(Exception e) {
        System.out.println("PostsDAO getAllPosts Error! : " + e);
    }

    public void postDAOEnterPostError(Exception e) {
        System.out.println("PostsDAO enterPost Error! : " + e);
    }

    public void postDAOModifyTitleError(Exception e) {
        System.out.println("PostsDAO modifyTitle: " + e);
    }

    public void postDAOModifyContentsError(Exception e) {
        System.out.println("PostsDAO modifyContents: " + e);
    }

    public void postDAOCloseError(Exception e) {
        System.out.println("PostsDAO close Error! : " + e);
    }

    // ================================================================================
    // path : com/abc/jdbc/dao/CommentsDAO.java
    public void commentDAOAddCommentSuccess() {
        System.out.println("댓글을 작성했습니다.");
        System.out.println();
    }

    public void commentDAOGetCommentsByPostIdCommentsListIsEmpty(String s) {
        System.out.println(s + "번 게시글에 댓글이 없습니다.");
    }

    public void commentDAOGetCommentsByPostIdCommentsListIsNotEmpty(String s) {
        System.out.println("<" + s + "번 게시글의 댓글 목록>");
    }

    public void commentDAOGetCommentsByPostIdCommentElement(CommentsDTO comment) {
        System.out.println("댓글 번호 : " + comment.getId()); // 댓글의 고유 식별자 출력
        System.out.println("댓글 작성자 : " + comment.getName());
        System.out.println("댓글 내용: " + comment.getCommentsText());
        System.out.println("댓글 시간: " + comment.getCommentsTime());
        System.out.println("-------------");
    }

    public void commentDAOCommentModifySelectNumber() {
        System.out.print("수정할 댓글 번호를 선택하세요: ");
    }

    public void commentDAOCommentModifyContent() {
        System.out.print("수정할 내용을 입력하세요: ");
    }

    public void commentDAOCommentModifyContentSuccess() {
        System.out.println("댓글이 성공적으로 수정되었습니다.");
    }

    public void commentDAOCommentModifyContentFail() {
        System.out.println("댓글 수정에 실패했습니다.");
    }

    public void commentDAOAddCommentError(Exception e) {
        System.out.println("CommentsDAO addComment Error! : " + e);
    }

    public void commentDAOGetCommentsByPostIdSqlError(SQLException e) { System.out.println("SQL 오류 발생: " + e.getMessage()); }

    public void commentDAOGetCommentsByPostIdError(Exception e) {
        System.out.println("오류 발생: " + e.getMessage());
    }

    public void commentDAOCommentModifyError(Exception e) {
        System.out.println("CommentDAO commentModify: " + e);
    }

    public void commentDAOCloseError(Exception e) {
        System.out.println("CommentsDAO close Error! : " + e);
    }


    // ================================================================================
    // path : com/abc/jdbc/dao/LikesDAO.java
    public void likesDAOPressLike() {
        System.out.println("좋아요를 눌렀습니다.");
    }

    public void likesDAOAlreadyPressLike() {
        System.out.println("이미 좋아요를 누르셨습니다!");
    }

    public void likesDAOAddLikeError(Exception e) {
        System.out.println("LikesDAO addLike Error! : " + e);
    }


    // ================================================================================
    // path : com/abc/jdbc/util/user/IdPassword.java , com/abc/jdbc/util/user/IdPwName.java
    public void inputId() {
        System.out.print("아이디 입력 : ");
    }

    public void inputPw() {
        System.out.print("비밀번호 입력 : ");
    }

    // ================================================================================
    // path : com/abc/jdbc/util/user/IdPwName.java
    public void inputNm() {
        System.out.print("이름 입력 : ");
    }

    // ================================================================================
    // path : com/abc/jdbc/util/user/createPost.java
    public void inputTitle() { System.out.print("글 제목 입력: "); }
    public void inputContent() { System.out.print("글 내용 입력: "); }
    public void successCreatePost() { System.out.println("글이 작성되었습니다."); }

    // ================================================================================
    // path : com/abc/jdbc/util/user/PostList.java
    public void allPostList(List<PostsDTO> postsList) {
        System.out.println("<모든 글 목록>");
        for (PostsDTO post : postsList) { // 향상된 for 문
            System.out.println("글 번호 : " + post.getId());
            System.out.println("글 제목 : " + post.getTitle());
            System.out.println("-".repeat(20));
        }
    }

    // ================================================================================
    // path : com/abc/jdbc/util/user/EnterPost.java
    public void whichEnterPost() { System.out.print("몇번 글에 들어갈까요? : "); }
    public void enteredPost(int post) {
        System.out.println(post + "번 글에 들어 왔습니다.");
        System.out.println(".A__A    ✨\uD83C\uDF82✨    A__A\n" +
                "( •⩊•)   _______   (•⩊• )\n" +
                "(>\uD83C\uDF70>)   |           |   (<\uD83D\uDD2A<)\n");
    }
    public void emptyPost(int post) { System.out.println(post + "번 게시글은 존재하지 않습니다."); }
    public void postNumber(int post) { System.out.println("<" + post + "번 글>"); }
    public void viewPostDTO(PostsDTO e) {
        System.out.println("글 번호 : " + e.getId());
        System.out.println("글 제목 : " + e.getTitle());
        System.out.println("글 작성 시간 : " + e.getCurrentTime());
        System.out.println("글 내용 : " + e.getContent());
        System.out.println("작성자 : " + e.getMembersID());
        System.out.println("추천수 : " + e.getLikesCounts());
        System.out.println("-".repeat(20));
        System.out.println();
    }
}








