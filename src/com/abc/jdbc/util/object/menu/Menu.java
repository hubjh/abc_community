package com.abc.jdbc.util.object.menu;

import com.abc.jdbc.dto.MembersDTO;
import com.abc.jdbc.util.object.login.Status;
import com.abc.jdbc.util.option.Options;
import com.abc.jdbc.util.print.Print;
import com.abc.jdbc.util.user.*;

public class Menu {
    Print print = new Print();    // 터미널에서 메뉴화면들 출력해주는 객체
    Options options = new Options(); // 선택지 골라주는 객체





    public Status loginMenu() {
        Status status = new Status();
        boolean loop = true;

        while (loop) {
            print.loginMenu();                         // 로그인 화면 출력
            int option = (options.number(3));   // 옵션 선택지
            switch (option) {
                case 1: // 회원가입
                    IdPwName idPwName = new IdPwName();
                    idPwName.input();
                    status.setSuccess(true);
                    loop = false;
                    break;
                case 2: // 로그인
                    IdPassword idPassword = new IdPassword();
                    status.setSuccess(true);
                    status.setMembersDTO(idPassword.input()); // return membersDTO
                    loop = false;
                    break;
                case 3: // 종료
                    status.setSuccess(false);
                    status.setMembersDTO(null);
                    loop = false;
                    break;
            }
        }
        return status; // return [loginSuccess, membersDTO]
    }

    public Status boardMenu(MembersDTO membersDTO) {
        Status status = new Status();
        boolean loop = true;
        EnterPost enterPost = new EnterPost();

        while (loop) {
            print.boardMenu();                         // 로그인 화면 출력
            int option = (options.number(3));   // 옵션 선택지
            switch (option) {
                case 1: // 글 쓰기
                    CreatePost createPost = new CreatePost();
                    createPost.input(membersDTO);
                    status.setSuccess(true);
                    break;
                case 2: // 글 목록 보기
                    PostList postList = new PostList();
                    postList.view();
                    status.setSuccess(true);
//                    enterPost.enter();
                    break;
                case 3: // 로그아웃
                    status.setSuccess(false);
                    loop = false;
                    print.logout();
                    break;
            }
        }
        return status; // return [loginSuccess, membersDTO]

    }
}
