package com.example.JobApp_DataJPA.repo;

import com.example.JobApp_DataJPA.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

}
