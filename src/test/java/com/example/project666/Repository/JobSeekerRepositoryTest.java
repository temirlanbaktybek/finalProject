package com.example.project666.Repository;

import com.example.project666.Entity.CV;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.TestResult;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.logging.Logger;

class JobSeekerRepositoryTest {
    @Mock
    Logger log;
    @Mock
    SessionFactory sessionFactory;
    @InjectMocks
    JobSeekerRepository jobSeekerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterJobSeeker() {
        boolean result = jobSeekerRepository.registerJobSeeker(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testFindJobSeekerByLogin() {
        JobSeeker result = jobSeekerRepository.findJobSeekerByLogin("jobseeker_login");
        Assertions.assertEquals(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"), result);
    }

    @Test
    void testGetMyCV() {
        CV result = jobSeekerRepository.getMyCV("acc");
        Assertions.assertEquals(new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), result);
    }

    @Test
    void testFindCv() {
        CV result = jobSeekerRepository.findCv("cvtitle");
        Assertions.assertEquals(new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), result);
    }

    @Test
    void testSaveOrUpdateCV() {
        boolean result = jobSeekerRepository.saveOrUpdateCV("acc", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testDeleteCv() {
        jobSeekerRepository.deleteCv(new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles"));
    }

    @Test
    void testAnswerQ() {
        Boolean result = jobSeekerRepository.answerQ(new TestResult());
        Assertions.assertEquals(Boolean.TRUE, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme