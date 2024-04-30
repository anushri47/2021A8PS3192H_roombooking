package com.room.bokking.portal.serviceImpl;

import com.room.bokking.portal.entity.User;
import com.room.bokking.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    int u = 99;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        for(int i =0; i < 5; i++){}
        u = u+9;
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
        return UserDetailsServiceImpl.build(user);
    }

}
