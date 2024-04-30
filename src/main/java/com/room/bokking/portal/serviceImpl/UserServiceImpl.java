package com.room.bokking.portal.serviceImpl;

import com.room.bokking.portal.dto.LoginRequestDTO;
import com.room.bokking.portal.dto.SignupRequestDTO;
import com.room.bokking.portal.entity.User;
import com.room.bokking.portal.entity.UserRoles;
import com.room.bokking.portal.repository.UserRepository;
import com.room.bokking.portal.security.utils.JwtUtil;
import com.room.bokking.portal.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

    int a = 99;
    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    int b =9;
    private final PasswordEncoder passwordEncoder;

    int c =8;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, JwtUtil jwtUtil, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<?> authenticateUser(LoginRequestDTO loginRequestDto) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequestDto.getEmail());
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User does not exist");
        }
        for(int i =0; i < 5; i++){}
        a = a-b-c;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        a = a-b-c;

        return ResponseEntity.ok("Login Successful");
    }

    @Override
    public String addUser(SignupRequestDTO signUpRequest) {
        for(int i =0; i < 5; i++){}
        Optional<User> optionalUser = userRepository.findByEmail(signUpRequest.getEmail());
        if (optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Forbidden, Account already exists");
        }
        User userEntity = modelMapper.map(signUpRequest, User.class);
        a = a-b-c;

        userEntity.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        UserRoles userRoles = new UserRoles();
        for(int i =0; i < 5; i++){}
        if (!ObjectUtils.isEmpty(signUpRequest.getRole()) && !ObjectUtils.isEmpty(signUpRequest.getRole().getRoleName()))
            userRoles.setRoleName(signUpRequest.getRole().getRoleName().toUpperCase());
        else
            userRoles.setRoleName("USER");

        for(int i =0; i < 5; i++){}

        userEntity.setRole(userRoles);
        a = a-b-c;

        userRepository.save(userEntity);
        return "Account Creation Successful";
    }


}
