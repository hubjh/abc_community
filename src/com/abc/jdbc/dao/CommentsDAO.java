package com.abc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.abc.jdbc.dto.PostsDTO;
import com.abc.jdbc.util.DatabaseConnection;
import com.abc.jdbc.dto.CommentsDTO;
import com.abc.jdbc.util.print.Print;
import com.abc.jdbc.util.sql.SqlQuery;


public class CommentsDAO {
    // 연결
    private final Connection connection;
    Scanner sc = new Scanner(System.in);
    Print print = new Print();
    SqlQuery sqlQuery = new SqlQuery();

    public CommentsDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // 댓글 달기
    public void addComment(CommentsDTO commentsDTO) {
        String sql = sqlQuery.commentsDAOAddComment();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, commentsDTO.getPostsId());
            preparedStatement.setString(2, commentsDTO.getMembersId());
            preparedStatement.setString(3, commentsDTO.getCommentsText());
            preparedStatement.executeUpdate();
            print.commentDAOAddCommentSuccess();
        } catch (Exception e) {
            print.commentDAOAddCommentError(e);
        }
    }

    // 댓글 보기
    public List<CommentsDTO> getCommentsByPostId(CommentsDTO commentsDTO) {
        List<CommentsDTO> commentsList = new ArrayList<>();
        String sql = sqlQuery.commentsDAOGetCommentsByPostId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, commentsDTO.getPostsId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CommentsDTO comment = new CommentsDTO();
                // 데이터베이스에서 생성된 고유 식별자(ID)를 가져와서 설정
                comment.setId(resultSet.getString("ID"));
                comment.setName(resultSet.getString("NAME"));
                comment.setCommentsText(resultSet.getString("COMMENTSTEXT"));
                comment.setCommentsTime(String.valueOf(resultSet.getTimestamp("COMMENTSTIME")));
                commentsList.add(comment);
            }

            if (commentsList.isEmpty()) {
                print.commentDAOGetCommentsByPostIdCommentsListIsEmpty(commentsDTO.getPostsId());
            } else {
                print.commentDAOGetCommentsByPostIdCommentsListIsNotEmpty(commentsDTO.getPostsId());
                for (CommentsDTO comment : commentsList) {
                    print.commentDAOGetCommentsByPostIdCommentElement(comment);
                }
            }
        } catch (SQLException e) {
            print.commentDAOGetCommentsByPostIdSqlError(e);
        } catch (Exception e) {
            print.commentDAOGetCommentsByPostIdError(e);
        }
        return commentsList;
    }



    // 댓글 수정
    public void commentModify() {
        String sql = sqlQuery.commentsDAOCommentModify();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            print.commentDAOCommentModifySelectNumber();
            int modCommentId = sc.nextInt();
            sc.nextLine();
            print.commentDAOCommentModifyContent();
            String modComment = sc.nextLine();
            preparedStatement.setString(1, modComment);
            preparedStatement.setInt(2, modCommentId);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                print.commentDAOCommentModifyContentSuccess();
            } else {
                print.commentDAOCommentModifyContentFail();
            }
        } catch (Exception e) {
            print.commentDAOCommentModifyError(e);
        }
    }

    // 연결 해제
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            print.commentDAOCloseError(e);
        }
    }
}
