package com.example.JobApp_DataJPA.service;


import com.example.JobApp_DataJPA.model.User;
import com.example.JobApp_DataJPA.model.UserDetailsImpl;
import com.example.JobApp_DataJPA.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1=repo.findByUsername(username);

        if(user1 == null){
            System.out.println("Username 404");
            throw new UsernameNotFoundException("Username 404");
        }
        return new UserDetailsImpl(user1);
    }
}
