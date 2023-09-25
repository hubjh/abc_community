package com.abc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.abc.jdbc.util.DatabaseConnection;
import com.abc.jdbc.dto.PostsDTO;
import com.abc.jdbc.util.print.Print;
import com.abc.jdbc.util.sql.SqlQuery;

public class PostsDAO {
    private final Connection connection;
    public PostsDAO() {
        connection = DatabaseConnection.getConnection();
    }
    Print print = new Print();
    SqlQuery sqlQuery = new SqlQuery();

    // 게시글 작성
    public void addPost(PostsDTO postsDTO) {
        String sql = sqlQuery.postsDAOAddPost();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, postsDTO.getTitle());
            preparedStatement.setString(2, postsDTO.getContent());
            preparedStatement.setString(3, postsDTO.getMembersID());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            print.postDAOAddPostError(e);
        }
    }

    // 모든 게시글 조회
    public List<PostsDTO> getAllPosts() {
        List<PostsDTO> postsList = new ArrayList<>();
        String sql = sqlQuery.postsDAOGetAllPosts();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PostsDTO post = new PostsDTO();
                post.setId(resultSet.getString("ID"));
                post.setTitle(resultSet.getString("TITLE"));
                post.setCurrentTime(String.valueOf(resultSet.getTimestamp("CURRENTTIME")));
                post.setContent(resultSet.getString("CONTENT"));
                post.setMembersID(String.valueOf(resultSet.getInt("MEMBERSID")));
                post.setLikesCounts(String.valueOf(resultSet.getInt("LIKESCOUNTS")));
                postsList.add(post);
            }
        } catch (Exception e) {
            print.postDAOGetAllPostError(e);
        }
        return postsList;
    }

    // 게시글 들어가기
    public List<PostsDTO> enterPost(int postId) {
        List<PostsDTO> postsList = new ArrayList<>();
        String sql = sqlQuery.postsDAOEnterPost();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PostsDTO post = new PostsDTO();
                post.setId(resultSet.getString("ID"));
                post.setTitle(resultSet.getString("TITLE"));
                post.setCurrentTime(String.valueOf(resultSet.getTimestamp("CURRENTTIME")));
                post.setContent(resultSet.getString("CONTENT"));
                post.setMembersID(String.valueOf(resultSet.getInt("MEMBERSID")));
                post.setLikesCounts(String.valueOf(resultSet.getInt("LIKESCOUNTS")));
                postsList.add(post);
            }
        } catch (Exception e) {
            print.postDAOEnterPostError(e);
        }
        return postsList;
    }
    // 글 제목 수정
    public void modifyTitle(PostsDTO postsDTO) {
        String sql = sqlQuery.postsDAOModifyTitle();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, postsDTO.getTitle());
            preparedStatement.setString(2, postsDTO.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                print.postDAOSuccessModifyTitle();
            } else {
                print.postDAOFailModifyTitle();
            }
        } catch (Exception e) {
            print.postDAOModifyTitleError(e);
        }

    }
    // 글 내용 수정
    public void modifyContent(PostsDTO postsDTO) {
        String sql = sqlQuery.postsDAOModifyContent();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, postsDTO.getContent());
            preparedStatement.setString(2, postsDTO.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                print.postDAOSuccessModifyContent();
            } else {
                print.postDAOFailModifyContent();
            }
        } catch (Exception e) {
            print.postDAOModifyContentsError(e);
        }

    }
    
    // 연결 해제
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            print.postDAOCloseError(e);
        }
    }
}
