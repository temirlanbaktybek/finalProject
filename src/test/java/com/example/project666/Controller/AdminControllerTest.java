package com.example.project666.Controller;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.Tests;
import com.example.project666.Service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class AdminControllerTest {
    @Mock
    AdminServiceImpl adminService;
    @InjectMocks
    AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDeleteUSER() {
        when(adminService.deleteUserService(anyString())).thenReturn("deleteUserServiceResponse");

        ResponseEntity result = adminController.deleteUSER("acc");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllUSER() {
        when(adminService.getALLUsers()).thenReturn(Arrays.<JobSeeker>asList(new JobSeeker("JobSeekerLogin", "JobSeekerPassword", null, "roles")));

        ResponseEntity result = adminController.getAllUSER();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetHeadHunter() {
        when(adminService.getAllHeadHunters()).thenReturn(Arrays.<HeadHunter>asList(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(null), "roles")));

        ResponseEntity result = adminController.getHeadHunter();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteHeadHunter() {
        when(adminService.deleteHeadHunters(anyString())).thenReturn("deleteHeadHuntersResponse");

        ResponseEntity result = adminController.deleteHeadHunter("acc");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testBathOP() {
        when(adminService.batchOp()).thenReturn("batchOpResponse");

        ResponseEntity result = adminController.bathOP();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme