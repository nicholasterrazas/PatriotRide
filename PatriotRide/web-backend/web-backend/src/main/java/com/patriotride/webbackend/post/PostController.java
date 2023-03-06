package com.patriotride.webbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

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
    public Post getPost(@RequestParam String postID) throws ExecutionException, InterruptedException {
        return postService.getPost(postID);
    }

    @PutMapping("/update")
    public String updatePost(@RequestBody Post post) throws ExecutionException, InterruptedException {
        return postService.updatePost(post);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String netID){
        return postService.deletePost(netID);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Get Endpoint is working");
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
