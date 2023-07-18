package com.volunteer.management.service;

import com.volunteer.management.config.CustomUserDetails;
import com.volunteer.management.entity.User;
import com.volunteer.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByAdminId("admin123");
        if(user == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");

        }
        System.out.println("user found" + user.getAdminId());
        return new CustomUserDetails(user);
    }
}

