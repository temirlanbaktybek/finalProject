package com.example.project666.Service.impl;

import com.example.project666.Entity.CV;
import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.Tests;
import com.example.project666.Repository.AdminRepository;
import com.example.project666.Repository.JobSeekerRepository;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AdminServiceImplTest {
    @Mock
    AdminRepository adminRepository;
    @Mock
    Logger logger;
    @Mock
    JobSeekerRepository jobSeekerRepository;
    @InjectMocks
    AdminServiceImpl adminServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDeleteUserService() {
        when(adminRepository.deleteUSER(anyString())).thenReturn(true);
        when(adminRepository.deleteUSERcv(anyString())).thenReturn(true);

        String result = adminServiceImpl.deleteUserService("acc");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetALLUsers() {
        when(adminRepository.getALLUsers()).thenReturn(Arrays.<JobSeeker>asList(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles")));

        List<JobSeeker> result = adminServiceImpl.getALLUsers();
        Assertions.assertEquals(Arrays.<JobSeeker>asList(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", new CV("cv_title", "name", "address", 0, "cv_skills", "cv_work_exp"), "roles")), result);
    }

    @Test
    void testGetAllHeadHunters() {
        when(adminRepository.getAllHeadHunter()).thenReturn(Arrays.<HeadHunter>asList(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles")));

        List<HeadHunter> result = adminServiceImpl.getAllHeadHunters();
        Assertions.assertEquals(Arrays.<HeadHunter>asList(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles")), result);
    }

    @Test
    void testDeleteHeadHunters() {
        when(adminRepository.deleteHEADHUNTER(anyString())).thenReturn(true);

        String result = adminServiceImpl.deleteHeadHunters("acc");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBatchOp() {
        when(adminRepository.batchOp()).thenReturn("batchOpResponse");

        String result = adminServiceImpl.batchOp();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme