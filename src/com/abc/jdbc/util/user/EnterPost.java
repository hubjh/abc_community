package com.abc.jdbc.util.user;

import com.abc.jdbc.dao.PostsDAO;
import com.abc.jdbc.dto.PostsDTO;
import com.abc.jdbc.util.print.Print;

import java.util.List;
import java.util.Scanner;

public class EnterPost {
    public void enter(PostsDAO postsDAO) {
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        // 댓글 작성 및 좋아요 누르기 위해 글 선택
        print.whichEnterPost();
        int post = sc.nextInt();
        boolean isPost = true;
        while (isPost) {
            List<PostsDTO> enter = postsDAO.enterPost(post);
            print.enteredPost(post);
            if (enter.isEmpty()) {
                print.emptyPost(post);
                break;
            }
            for (PostsDTO e : enter) { // 향상된 for 문
                print.postNumber(post);
                print.viewPostDTO(e);
            }
        }
    }
}
