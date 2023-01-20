package com.example.JobPost.Controller;

import com.example.JobPost.EntityJobPost.Jobpost;
import com.example.JobPost.EntityJobPost.Organisation;
import com.example.JobPost.Service.PostJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employer")
public class PostjobController {

    @Autowired
    PostJobService postJobService;

    @PostMapping("/register")
    public ResponseEntity<Organisation> register(@Valid @RequestBody Organisation organisation){
        return new ResponseEntity<>(postJobService.register(organisation), HttpStatus.CREATED);
    }

    @PostMapping("/create_jobpost")
    public ResponseEntity<Jobpost> createPost(@Valid @RequestBody Organisation organisation){
        return new ResponseEntity<>(postJobService.createJobpost(organisation), HttpStatus.CREATED);
    }

}
