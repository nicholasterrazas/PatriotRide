package com.patriotride.webbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 *  UserController Class:
 *  Parses HTTP requests and directs them to service layer (business logic)
 *
 *  CRUD API
 *  - Create user
 *  - Read user
 *  - Update user
 *  - Delete user
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;


    @PostMapping("/create")
    public String createUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.createUser(user);
    }

    @GetMapping("/get")
    public User getUser(@RequestParam String user_id) throws ExecutionException, InterruptedException {
        return userService.getUser(user_id);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String user_id){
        return userService.deleteUser(user_id);
    }

    @GetMapping("/list")
    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        return userService.getAllUsers();
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
