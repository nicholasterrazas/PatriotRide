package com.patriotride.webbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

//    // below necessary?? maybe autowired handles it
//    public UserController(UserService userService){
//        this.userService = userService;
//    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.createUser(user);
    }


    //@GetMapping("/get")
    @GetMapping("/get")
    public User getUser(@RequestParam String netID) throws ExecutionException, InterruptedException {
        return userService.getUser(netID);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String netID){
        return userService.deleteUser(netID);
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
