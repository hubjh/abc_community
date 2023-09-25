package com.abc.jdbc.util.user;

import com.abc.jdbc.dao.MembersDAO;
import com.abc.jdbc.dto.MembersDTO;
import com.abc.jdbc.util.print.Print;

import java.util.Scanner;

public class IdPwName {
    public void input() {
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

        print.inputNm();
        String nm = sc.nextLine();
        membersDTO.setName(nm);

        membersDAO.addMember(membersDTO);

    }
}