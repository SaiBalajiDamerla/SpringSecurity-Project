package com.springproject.demo.dao.Repo;

import com.springproject.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
