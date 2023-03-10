package com.patriotride.webbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 *  PostService Class:
 *  handles business logic for the Post class
 *
 *  TODO: Need to add more attributes for posts: likes, dislikes, owner, time posted?
 *
 */
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public String createPost(Post post) throws ExecutionException, InterruptedException {
        return postRepository.createPost(post);
    }

    public Post getPost(String post_id) throws ExecutionException, InterruptedException {
        return postRepository.getPost(post_id);
    }

    public String updatePost(Post post) throws ExecutionException, InterruptedException {
        return postRepository.updatePost(post);
    }

    public String deletePost(String post_id){
        return postRepository.deletePost(post_id);
    }

    public List<Post> getAllPosts() throws ExecutionException, InterruptedException {
        return postRepository.getAllPosts();
    }
}
