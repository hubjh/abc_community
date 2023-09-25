package com.abc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.abc.jdbc.dto.MembersDTO;
import com.abc.jdbc.util.DatabaseConnection;
import com.abc.jdbc.dto.LikesDTO;
import com.abc.jdbc.dao.MembersDAO;
import com.abc.jdbc.util.print.Print;
import com.abc.jdbc.util.sql.SqlQuery;

public class LikesDAO {
    // 연결
    private final Connection connection;
    private final MembersDAO LoginMembersDAO;
    Print print = new Print();
    SqlQuery sqlQuery = new SqlQuery();

    public LikesDAO(MembersDAO membersDAO) {
        connection = DatabaseConnection.getConnection();
        this.LoginMembersDAO = membersDAO;
    }

    // 좋아요 추가
    public void addLike(LikesDTO likesDTO) {
        String sql = sqlQuery.likesDAOAddLike();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, likesDTO.getPostsId());
            preparedStatement.setString(2, likesDTO.getMembersId());
            preparedStatement.executeUpdate();
            print.likesDAOPressLike();
        } catch (SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException) {
            print.likesDAOAlreadyPressLike();
        }
        catch (Exception e){
            print.likesDAOAddLikeError(e);
        }
    }
}
