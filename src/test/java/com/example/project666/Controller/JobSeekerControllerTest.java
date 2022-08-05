package com.example.project666.Controller;

import com.example.project666.Entity.CV;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.TestResult;
import com.example.project666.Service.impl.JobSeekerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class JobSeekerControllerTest {
    @Mock
    JobSeekerServiceImpl jobSeekerService;
    @InjectMocks
    JobSeekerController jobSeekerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegistraionJobSeeker() {
        when(jobSeekerService.registrationJobSeeker(any())).thenReturn("registrationJobSeekerResponse");

        String result = jobSeekerController.registraionJobSeeker(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetJobSeeker() {
        when(jobSeekerService.findJobSeekerByLogin(anyString())).thenReturn(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"));

        ResponseEntity result = jobSeekerController.getJobSeeker("acc");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddCV() {
        when(jobSeekerService.addToJobSeekerCV(anyString(), any())).thenReturn("addToJobSeekerCVResponse");

        ResponseEntity result = jobSeekerController.addCV("acc", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteCv() {
        when(jobSeekerService.deleteCv(anyString())).thenReturn("deleteCvResponse");

        ResponseEntity result = jobSeekerController.deleteCv("acc");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAnswerQ() {
        when(jobSeekerService.answerQ(any())).thenReturn("answerQResponse");

        ResponseEntity result = jobSeekerController.answerQ(new TestResult());
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme