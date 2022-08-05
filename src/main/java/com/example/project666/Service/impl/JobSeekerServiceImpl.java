package com.example.project666.Service.impl;

import com.example.project666.Entity.CV;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.TestResult;
import com.example.project666.Repository.JobSeekerRepository;
import com.example.project666.Service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerRepository jr;


    public String registrationJobSeeker(JobSeeker jobSeeker){
        if(jr.registerJobSeeker(jobSeeker) == false){
            return "Registration failed...";
        }
        else{
            return "Registration success";
        }
    }

    public JobSeeker findJobSeekerByLogin(String jobseeker_login) {
        return jr.findJobSeekerByLogin(jobseeker_login);
    }


    public String addToJobSeekerCV(String acc, CV cv) {
        if(jr.saveOrUpdateCV(acc, cv) == false ){
            return "CV not saved " + cv.getCv_title() + " ";

        }else{
            return "CV saved successfully " + cv.toString();
        }
    }


    public String deleteCv(String acc) {
        if(jr.findJobSeekerByLogin(acc) != null){
            JobSeeker jobSeeker = jr.findJobSeekerByLogin(acc);
            CV temp = jr.getMyCV(acc);
            jr.deleteCv(temp, jobSeeker);
            return "Your CV: DELETED";
        }
        else{
            return "CV not found";
        }
    }

    public String answerQ(TestResult testResult){
        if(jr.answerQ(testResult) == true){
            return "Answers saved";
        }else return "Answers not saved";
    }

    @PostConstruct
    public void postconstruct(){
        System.out.println("Post construct method");
    }

    @PreDestroy
    public void predestroy(){
        System.out.println("Pre destroy method ");
    }
}
