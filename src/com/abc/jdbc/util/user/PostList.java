package com.abc.jdbc.util.user;

import com.abc.jdbc.dao.PostsDAO;
import com.abc.jdbc.dto.PostsDTO;
import com.abc.jdbc.util.print.Print;

import java.util.List;

public class PostList {
    public void view() {
        PostsDAO postsDAO = new PostsDAO();
        List<PostsDTO> postsList = postsDAO.getAllPosts();
        Print print = new Print();
        if (!postsList.isEmpty()) {
            print.allPostList(postsList);
        }
    }
}
