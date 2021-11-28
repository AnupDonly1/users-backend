package com.hashes.users.controller;

import com.hashes.users.entity.User;
import com.hashes.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

 @PostMapping("users/add")
 public ResponseEntity<?>  addUser(@RequestBody User user){
     return  new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
 }

    @GetMapping("users")
    public ResponseEntity<?>  getUsers(){
        return  new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<?>  getUserById(@PathVariable String id){
        return  new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);
    }
    @PutMapping("users/{id}")
    public ResponseEntity<?>  updateUser(@PathVariable String id,@RequestBody User user){
        return  new ResponseEntity<User>(userService.update(id,user), HttpStatus.OK);
    }

    @DeleteMapping("users/delete/{id}")
    public void deleteById(@PathVariable String id){
     userService.deleteUser(id);
    }
}
