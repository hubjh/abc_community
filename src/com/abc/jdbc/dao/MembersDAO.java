package com.abc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.abc.jdbc.util.DatabaseConnection;
import com.abc.jdbc.dto.MembersDTO;
import com.abc.jdbc.util.print.Print;
import com.abc.jdbc.util.sql.SqlQuery;


// DAO : Data Access Object, 데이터베이스에 접근해 데이터를 조회하거나 수정하기 위해 사용
// DML(select, insert, delete, update...)와 유사한 기능

// 회원가입
public class MembersDAO {
    // 연결
    private final Connection connection;

    public MembersDAO() {
        connection = DatabaseConnection.getConnection();
    }
    Print print = new Print();
    SqlQuery sqlQuery = new SqlQuery();

    // 회원 가입
    public void addMember(MembersDTO membersDTO) {

        String sql = sqlQuery.membersDAOAddMember();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, membersDTO.getInputId());
            preparedStatement.setString(2, membersDTO.getPassword());
            preparedStatement.setString(3, membersDTO.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            print.membersDAOAddMemberError(e);
        }
        print.successAddMember();
    }
    
    //로그인
    public MembersDTO login(MembersDTO membersDTO) {
        MembersDTO loggedInMember = null;
        String sql = sqlQuery.membersDAOLogin();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, membersDTO.getInputId());
            preparedStatement.setString(2, membersDTO.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            // ResultSet 객체에서 다음 행이 존재하는지 확인
            if (resultSet.next()) {

                // 만약 다음 행이 존재한다면, 로그인에 성공한 회원 정보를 가져온다.
                // 로그인한 회원 객체
                loggedInMember = new MembersDTO();

                // ResultSet으로부터 회원 정보를 가져와서 로그인한 회원 객체에 설정
                // 'ID' 필드에서 값을 읽어와 loggedInMember의 'id' 필드에 설정
                loggedInMember.setId(resultSet.getString("ID"));
                loggedInMember.setInputId(resultSet.getString("INPUTID"));
                loggedInMember.setPassword(resultSet.getString("PASSWORD"));
                loggedInMember.setName(resultSet.getString("NAME"));
                print.successLogin();
            }
            // 만약 ResultSet에서 다음 행이 없다면,
            // 로그인에 실패하고 loggedInMember는 여전히 null이다.
            else {
                print.failLogin();
            }
        } catch (Exception e) {
            print.membersDAOLoginError(e);
        }
        return loggedInMember;
    }

    // 모든 회원 조회
    public List<MembersDTO> getAllMembers() {
        List<MembersDTO> membersList = new ArrayList<>();
        String sql = sqlQuery.membersDAOGetAllMembers();
        boolean hasMembers = false; // 등록된 회원이 존재하는지 확인
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hasMembers = true;
                MembersDTO membersDTO = new MembersDTO();
                membersDTO.setId(resultSet.getString("ID"));
                membersDTO.setInputId(resultSet.getString("INPUTID"));
                membersDTO.setPassword(resultSet.getString("PASSWORD"));
                membersDTO.setName(resultSet.getString("NAME"));
                membersList.add(membersDTO);
            }
            if (!hasMembers) {
                print.hasNotAsMembers();
            }
        } catch (Exception e) {
            print.memberDAOGetAllMembersError(e);
        }
        return membersList;
    }

    // 연결 해제
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            print.membersDAOCloseError(e);
        }
    }
}
