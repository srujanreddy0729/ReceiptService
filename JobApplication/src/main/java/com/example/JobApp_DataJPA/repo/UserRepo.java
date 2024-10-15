package com.example.JobApp_DataJPA.repo;


import com.example.JobApp_DataJPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

     User findByUsername(String username);
}
