package com.abc.jdbc.util.user;

import com.abc.jdbc.dao.MembersDAO;
import com.abc.jdbc.dto.MembersDTO;
import com.abc.jdbc.util.print.Print;

import java.util.Scanner;

public class IdPassword  {

    public MembersDTO input() {        // true false 로 바꾸고
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        MembersDTO membersDTO = new MembersDTO();
        MembersDAO membersDAO = new MembersDAO();
        print.inputId();
        String id = sc.nextLine();
        membersDTO.setInputId(id);
        print.inputPw();
        String pw = sc.nextLine();
        membersDTO.setPassword(pw);
        membersDTO = membersDAO.login(membersDTO);


        // 여기에 sql에 보내는 클래스, 메서드 추가
        return membersDTO;
    }
}

