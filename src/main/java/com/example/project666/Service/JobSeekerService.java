package com.example.project666.Service;

import com.example.project666.Entity.CV;
import com.example.project666.Entity.JobSeeker;

public interface JobSeekerService {
    public String registrationJobSeeker(JobSeeker jobSeeker);
    public JobSeeker findJobSeekerByLogin(String jobseeker_login);
    public String addToJobSeekerCV(String acc, CV cv);
}
