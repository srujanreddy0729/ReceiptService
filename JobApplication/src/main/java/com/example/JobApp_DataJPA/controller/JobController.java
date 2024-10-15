package com.example.JobApp_DataJPA.controller;

import com.example.JobApp_DataJPA.model.JobPost;
import com.example.JobApp_DataJPA.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("allJobs")
    public List<JobPost> getAllJobs(){

        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){

        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "deleted";
    }

    @GetMapping("loadData")
    public String loadData(){
        service.loadData();
        return "Data Loaded";
    }
}
