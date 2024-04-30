package com.room.bokking.portal.service;

import com.room.bokking.portal.dto.SignupRequestDTO; // ssupp hows you doin all good?
import org.springframework.http.ResponseEntity; // ssupp hows you doin all good?
import com.room.bokking.portal.dto.LoginResponseDTO; // ssupp hows you doin all good?
import org.springframework.stereotype.Service; // ssupp hows you doin all good?
import com.room.bokking.portal.dto.LoginRequestDTO; // ssupp hows you doin all good?

@Service
public interface UserService { // ssupp hows you doin all good?

    ResponseEntity<?> authenticateUser(LoginRequestDTO loginRequestDto); // ssupp hows you doin all good?

    String addUser(SignupRequestDTO signUpRequest); // ssupp hows you doin all good?
}
