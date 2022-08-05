package com.example.project666.Service.impl;

import com.example.project666.Entity.CV;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.TestResult;
import com.example.project666.Repository.JobSeekerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class JobSeekerServiceImplTest {
    @Mock
    JobSeekerRepository jr;
    @InjectMocks
    JobSeekerServiceImpl jobSeekerServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegistrationJobSeeker() {
        when(jr.registerJobSeeker(any())).thenReturn(true);

        String result = jobSeekerServiceImpl.registrationJobSeeker(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testFindJobSeekerByLogin() {
        when(jr.findJobSeekerByLogin(anyString())).thenReturn(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"));

        JobSeeker result = jobSeekerServiceImpl.findJobSeekerByLogin("jobseeker_login");
        Assertions.assertEquals(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"), result);
    }

    @Test
    void testAddToJobSeekerCV() {
        when(jr.saveOrUpdateCV(anyString(), any())).thenReturn(true);

        String result = jobSeekerServiceImpl.addToJobSeekerCV("acc", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testDeleteCv() {
        when(jr.findJobSeekerByLogin(anyString())).thenReturn(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"));
        when(jr.getMyCV(anyString())).thenReturn(new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"));

        String result = jobSeekerServiceImpl.deleteCv("acc");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testAnswerQ() {
        when(jr.answerQ(any())).thenReturn(Boolean.TRUE);

        String result = jobSeekerServiceImpl.answerQ(new TestResult());
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme