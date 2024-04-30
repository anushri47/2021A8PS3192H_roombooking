package com.room.bokking.portal.controller;
//doing imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.room.bokking.portal.service.UserService;
import com.room.bokking.portal.dto.LoginRequestDTO;
import org.springframework.http.HttpStatus;
import com.room.bokking.portal.dto.LoginResponseDTO;
import com.room.bokking.portal.dto.SignupRequestDTO;
import org.springframework.http.ResponseEntity;

@RestController
public class AuthController {

    @Autowired
    UserService userService;
    int x =0; //variable check

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDto) { // doing login
        x = 1; //variable check
        for(int i = 0; i < 2; i++){
        }
        return userService.authenticateUser(loginRequestDto);//done login
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequestDTO signUpRequest) { // doing sign up
        x =2; //variable check
        for(int i = 0; i < 3; i++){
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(signUpRequest)); //done signup
    }

}
