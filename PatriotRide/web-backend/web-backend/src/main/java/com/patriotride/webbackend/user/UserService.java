package com.patriotride.webbackend.user;

import com.patriotride.webbackend.post.Post;
import com.patriotride.webbackend.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 *  UserService Class:
 *  handles business logic for the User class
 *
 *  TODO: Email validation, rating calculation, rating validation (0<rating<5), more?
 *
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService postService;

    public String createUser(User user) throws ExecutionException, InterruptedException {
        // things like email validation might go here
        //      example:
        //      if (validEmail(user.getEmail))
        //          return userRepository.createUser(user);
        //      else
        //          return ("Invalid email: " + user.getEmail);

        return userRepository.createUser(user);
    }

    public User getUser(String user_id) throws ExecutionException, InterruptedException {
        return userRepository.getUser(user_id);
    }

    public String updateUser(User user) throws ExecutionException, InterruptedException {
        // BUSINESS LOGIC HERE: check or modify user, then update user using below method

        return userRepository.updateUser(user);
    }

    public String deleteUser(String user_id){
        return userRepository.deleteUser(user_id);
    }

    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        return userRepository.getAllUsers();
    }

    public String publishPost(String user_id, Post post) throws ExecutionException, InterruptedException {

        // get user, add post to user's post list, then update user
        User publisher = userRepository.getUser(user_id);
        List<Post> posts = publisher.getPosts();
        posts.add(post);
        userRepository.updateUser(publisher);

        // add post to "posts" database
        postService.createPost(post);

        return publisher.getFirstName() + " successfully published post: \"" + post.getMessage()+ "\"";
    }

    // other methods that have to do with User business logic goes here
    // e.g. public boolean validEmail(String email){ return true; }

}
