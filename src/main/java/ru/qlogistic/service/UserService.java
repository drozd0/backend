package ru.qlogistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.qlogistic.entity.User;
import ru.qlogistic.manager.UserManager;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserManager userManager;

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userManager.findUserByUsername(userName);
    }

    public String getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
