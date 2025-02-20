package com.springproject.demo.Service;

import com.springproject.demo.Model.User;
import com.springproject.demo.dao.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisteration {
    @Autowired
    private UserRepo userRepo;

    public String registerUser(User user) {
        userRepo.save(user);
        return "Successfully registered";


    }
}
