package com.springproject.demo.Service;

import com.springproject.demo.Model.User;
import com.springproject.demo.Model.UserPrinciple;
import com.springproject.demo.dao.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
@Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }


        return new UserPrinciple(user);
    }
}
