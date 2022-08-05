package com.example.project666.Controller;


import com.example.project666.Entity.CV;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.TestResult;
import com.example.project666.Service.impl.JobSeekerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/jobseeker")
public class JobSeekerController {

    private JobSeekerServiceImpl jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerServiceImpl jobSeekerService){
        this.jobSeekerService = jobSeekerService;
    }


    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    public String registraionJobSeeker(@RequestBody JobSeeker jobSeeker){
        return jobSeekerService.registrationJobSeeker(jobSeeker);
    }

    @GetMapping("/{acc}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getJobSeeker(@PathVariable String acc){
        return ResponseEntity.ok().body(jobSeekerService.findJobSeekerByLogin(acc));
    }

    @PostMapping("/{acc}/cvadd")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addCV(@PathVariable String acc, @RequestBody CV cv){
        return ResponseEntity.ok().body(jobSeekerService.addToJobSeekerCV(acc, cv));
    }

    @DeleteMapping("/{acc}/cvdelete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteCv(@PathVariable String acc){
        return ResponseEntity.ok().body(jobSeekerService.deleteCv(acc));
    }

    @PostMapping("/{acc}/answer")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity answerQ(@RequestBody TestResult testResult){
        return ResponseEntity.ok(jobSeekerService.answerQ(testResult));
    }
}
