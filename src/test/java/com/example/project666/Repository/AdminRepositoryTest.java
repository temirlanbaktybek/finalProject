package com.example.project666.Repository;

import com.example.project666.Entity.Admin;
import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.Tests;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AdminRepositoryTest {
    @Mock
    SessionFactory sessionFactory;
    @Mock
    JobSeekerRepository jr;
    @Mock
    HeadHunterRepository hr;
    @InjectMocks
    AdminRepository adminRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateAdmin() {
        adminRepository.createAdmin(new Admin("adminLogin", "adminPassword", "roles"));
    }

    @Test
    void testDeleteUSER() {
        when(jr.findJobSeekerByLogin(anyString())).thenReturn(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", null, "roles"));

        boolean result = adminRepository.deleteUSER("acc");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testDeleteUSERcv() {
        boolean result = adminRepository.deleteUSERcv("acc");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetALLUsers() {
        List<JobSeeker> result = adminRepository.getALLUsers();
        Assertions.assertEquals(Arrays.<JobSeeker>asList(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", null, "roles")), result);
    }

    @Test
    void testGetAllHeadHunter() {
        List<HeadHunter> result = adminRepository.getAllHeadHunter();
        Assertions.assertEquals(Arrays.<HeadHunter>asList(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles")), result);
    }

    @Test
    void testDeleteHEADHUNTER() {
        when(hr.findHeadHunterByLogin(anyString())).thenReturn(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"));

        boolean result = adminRepository.deleteHEADHUNTER("acc");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testBatchOp() {
        String result = adminRepository.batchOp();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme