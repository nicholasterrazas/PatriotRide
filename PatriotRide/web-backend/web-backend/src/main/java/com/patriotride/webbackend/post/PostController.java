package com.patriotride.webbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


/**
 *  PostController Class:
 *  Parses HTTP requests and directs them to service layer (business logic)
 *
 *  CRUD API
 *  - Create post
 *  - Read post
 *  - Update post
 *  - Delete post
 *
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    public PostService postService;

    @PostMapping("/create")
    public String createPost(@RequestBody Post post) throws ExecutionException, InterruptedException {
        return postService.createPost(post);
    }


    @GetMapping("/get")
    public Post getPost(@RequestParam String post_id) throws ExecutionException, InterruptedException {
        return postService.getPost(post_id);
    }

    @PutMapping("/update")
    public String updatePost(@RequestBody Post post) throws ExecutionException, InterruptedException {
        return postService.updatePost(post);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String post_id){
        return postService.deletePost(post_id);
    }

    // Tests Below
    // |    |    |
    // v    v    v

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Get Endpoint is working");
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
