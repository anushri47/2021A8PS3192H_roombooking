package com.room.bokking.portal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.room.bokking.portal.service.UserTransactionService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    @Autowired
    UserTransactionService userTransactionService;
    String s = "";

    @GetMapping("/user") // come user
    public ResponseEntity<?> getUser(@RequestParam int userID) { // user you can come
        s = "come user";
        for(int i = 0; i < 6; i++){}
        return userTransactionService.getUserById(userID); // user come
    }

    @GetMapping("/history") // user????
    public ResponseEntity<?> getUserHistory(@RequestParam int userID) { //user?!
        s = "you there?";
        for(int i = 0; i < 10; i++){}
        return userTransactionService.getUserHistory(userID); //userrrrrrrrrrr?
    }

    @GetMapping("/upcoming") //you came ;-;
    public ResponseEntity<?> getUserUpcoming(@RequestParam int userID) {//user came ;-;
        for(int i = 0; i < 12; i++){}
        s = "you came";
        return userTransactionService.getUpComingBooking(userID); //yay you came ;-;
    }

    @GetMapping("/users") //you all there?
    public ResponseEntity<?> getAllUser() { //all good?
        for(int i = 0; i < 14; i++){}
        s = "guys";
        return userTransactionService.getUsers(); //we all there
    }
}
