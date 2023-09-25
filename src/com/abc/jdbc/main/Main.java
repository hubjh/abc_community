package com.abc.jdbc.main;

import com.abc.jdbc.util.object.login.Status;
import com.abc.jdbc.util.object.menu.Menu;
import com.abc.jdbc.util.print.Print;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Print print = new Print();
        boolean loop = true;
        while (loop) {
            // 로그인 메인 화면
            Status logineduser = menu.loginMenu();
            if (!(logineduser.isSuccess())) {        // login 메인 화면에서 종료 입력시 logineduser.isSuccess() = false를 return 받으면 프로그램 종료
                print.exit();
                break;
            }
            // 로그인 성공
            if (logineduser.getMembersDTO() != null) {
                // 게시판 화면
                menu.boardMenu(logineduser.getMembersDTO());
            }
        }
    }
}


//        Scanner sc = new Scanner(System.in);
//        MembersDAO membersDAO = new MembersDAO();
//        MembersDTO loginMember = null; // 현재 로그인한 사용자
//        PostsDTO postsDTO = new PostsDTO();
//        PostsDAO postsDAO = new PostsDAO();
//        LikesDAO likesDAO = new LikesDAO(membersDAO);
//        CommentsDAO commentsDAO = new CommentsDAO();
//
//        while (true) {
//            if (loginMember == null) { // 로그인하지 않은 경우
//                PrintMenu.notLoginMenu();
//            } else { // 로그인한 경우
//                PrintMenu.loginMenu();
//            }
//
//            System.out.print("메뉴를 선택하세요 : ");
//            int choice = sc.nextInt();
//            System.out.println();
//            if (loginMember == null) { // 로그인하지 않은 경우
//                switch (choice) {
//                    case 1: // 로그인
//                        // 입력
//                        MembersDTO inputMember = new MembersDTO();
//                        System.out.print("아이디 입력: ");
//                        String inputId = sc.next();
//                        System.out.print("비밀번호 입력: ");
//                        String password = sc.next();
//                        // 새로운 회원 객체, 입력된 아이디와 비밀번호를 새롭게 생성된 회원 객체에 설정
//                        inputMember.setInputId(inputId);
//                        inputMember.setPassword(password);
//                        loginMember = membersDAO.login(inputMember);
//                        if (loginMember != null) {
//                            System.out.println("로그인 성공!");
//                        } else {
//                            System.out.println("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
//                        }
//                        break;
//
//                    case 2: // 회원 가입
//                        System.out.print("아이디 입력: ");
//                        inputId = sc.next();
//                        System.out.print("비밀번호 입력: ");
//                        password = sc.next();
//                        System.out.print("이름 입력: ");
//                        String name = sc.next();
//                        MembersDTO membersDTO = new MembersDTO(inputId, password, name);
//                        membersDAO.addMember(membersDTO);
//                        System.out.println("회원이 추가되었습니다.");
//                        break;
//
//                    case 3: // 종료
//                        membersDAO.close();
//                        sc.close(); // 스캐너를 먼저 닫습니다.
//                        System.out.println("프로그램을 종료합니다.");
//                        System.exit(0);
//                        break;
//
//                    default:
//                        System.out.println("올바른 숫자를 입력해주세요.");
//                        break;
//                }
//            } else { // 로그인한 경우
//                switch (choice) {
//                    case 1: // 글 작성하기
//                        System.out.print("글 제목 입력: ");
//                        String title = sc.next();
//                        System.out.print("글 내용 입력: ");
//                        String content = sc.next();
//                        PostsDTO myPostsDTO = new PostsDTO(title, content, loginMember.getId());
//                        postsDAO.addPost(myPostsDTO);
//                        System.out.println("글이 작성되었습니다.");
//                        break;
//
//                    case 2:
//                        // 글 목록
//                        List<PostsDTO> postsList = postsDAO.getAllPosts();
//                        if (!postsList.isEmpty()) {
//                            System.out.println("<모든 글 목록>");
//                            for (PostsDTO post : postsList) { // 향상된 for 문
//                                System.out.println("글 번호 : " + post.getId());
//                                System.out.println("글 제목 : " + post.getTitle());
//                                System.out.println("-".repeat(20));
//                            }
//
//                            // 댓글 작성 및 좋아요 누르기 위해 글 선택
//                            System.out.print("몇번 글에 들어갈까요? : ");
//                            int post = sc.nextInt();
//                            boolean isPost = true;
//                            while (isPost) {
//                                List<PostsDTO> enter = postsDAO.enterPost(post);
//                                System.out.println(post + "번 글에 들어 왔습니다.");
//                                System.out.println(".A__A    ✨\uD83C\uDF82✨    A__A\n" +
//                                        "( •⩊•)   _______   (•⩊• )\n" +
//                                        "(>\uD83C\uDF70>)   |           |   (<\uD83D\uDD2A<)\n");
//                                if(enter.isEmpty()){
//                                    System.out.println(post+"번 게시글은 존재하지 않습니다.");
//                                    break;
//                                }
//                                for (PostsDTO e : enter) { // 향상된 for 문
//                                    System.out.println("<" + post+ "번 글>");
//                                    System.out.println("글 번호 : " + e.getId());
//                                    System.out.println("글 제목 : " + e.getTitle());
//                                    System.out.println("글 작성 시간 : " + e.getCurrentTime());
//                                    System.out.println("글 내용 : " + e.getContent());
//                                    System.out.println("작성자 : " + e.getMembersID());
//                                    System.out.println("추천수 : " + e.getLikesCounts());
//                                    System.out.println("-".repeat(20));
//                                    System.out.println();
//                                }
//                                System.out.print("[1]댓글 작성 [2]댓글 수정 [3]댓글 보기 [4] 좋아요 [5] 글 제목수정 [6] 글 내용수정 [7] 글 삭제 [8] 나가기 :");
//                                int action = sc.nextInt();
//                                switch (action) {
//                                    case 1: // 댓글 작성
//                                        System.out.print("댓글을 입력해주세요 : ");
//                                        String comment = sc.next();
//                                        commentsDAO.addComment(new CommentsDTO(Integer.toString(post), loginMember.getId(), comment, loginMember.getName()));
//                                        break;
//                                    case 2: // 댓글 수정
//                                        commentsDAO.commentModify();
//                                        break;
//                                    case 3: // 댓글 보기
//                                        commentsDAO.getCommentsByPostId(new CommentsDTO(Integer.toString(post), loginMember.getId()));
//                                        break;
//                                    case 4: // 좋아요
//                                        likesDAO.addLike(new LikesDTO(Integer.toString(post), loginMember.getId()));
//                                        break;
//                                    case 5: // 글 제목 수정
//                                        System.out.print("수정할 제목을 입력해주세요: ");
//                                        String postTitle = sc.next();
//                                        postsDAO.modifyTitle(new PostsDTO(Integer.toString(post), postTitle));
//                                        break;
////                                    case 6: // 글 내용 수정
////                                        System.out.print("수정할 내용을 입력해주세요: ");
////                                        String postContent = sc.next();
////                                        postsDAO.modifyContent(new PostsDTO(Integer.toString(post), postContent));
////                                        break;
//                                    case 7: // 글 삭제
//                                        break;
//
//                                    case 8:
//                                        isPost = false;
//                                        break;
//                                    default:
//                                        break;
//                                }
//
//                            }
//                        } else {
//                            System.out.println("등록된 글이 없습니다.");
//                        }
//                        break;
//
//                    case 3:
//                        loginMember = null; // 로그아웃
//                        break;
//                    default:
//                        System.out.println("올바른 숫자를 입력해주세요.");
//                        break;
//                }
//            }
//        }
//    }
//}
