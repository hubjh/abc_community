package com.abc.jdbc.util.user;

import com.abc.jdbc.dao.PostsDAO;
import com.abc.jdbc.dto.MembersDTO;
import com.abc.jdbc.dto.PostsDTO;
import com.abc.jdbc.util.print.Print;

import java.util.Scanner;

public class CreatePost {
    public void input(MembersDTO userDTO) {
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        PostsDTO myPostsDTO = new PostsDTO();
        PostsDAO postsDAO = new PostsDAO();
        print.inputTitle();
        String title = sc.next();
        print.inputContent();
        String content = sc.next();
        myPostsDTO.setTitle(title);
        myPostsDTO.setContent(content);
        myPostsDTO.setMembersID(userDTO.getId());
        postsDAO.addPost(myPostsDTO);
        print.successCreatePost();
    }
}
