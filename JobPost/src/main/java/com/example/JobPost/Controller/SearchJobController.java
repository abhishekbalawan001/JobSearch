package com.example.JobPost.Controller;

import com.example.JobPost.EntityJobPost.Jobpost;
import com.example.JobPost.EntityJobPost.Organisation;
import com.example.JobPost.EntityJobSearch.JobSearch;
import com.example.JobPost.Service.SearchJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job_seeker")
public class SearchJobController {

    @Autowired
    SearchJobService searchJobService;

    @GetMapping("/search")
    public ResponseEntity<List<Jobpost>> searchJobs(@RequestBody JobSearch jobSearch){
        return new ResponseEntity<>(searchJobService.searchJobs(jobSearch), HttpStatus.OK);
    }

}
