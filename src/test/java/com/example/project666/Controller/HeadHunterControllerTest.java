package com.example.project666.Controller;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.TestResult;
import com.example.project666.Entity.Tests;
import com.example.project666.Service.impl.HeadHunterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class HeadHunterControllerTest {
    @Mock
    HeadHunterServiceImpl headHunterService;
    @InjectMocks
    HeadHunterController headHunterController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterHeadHunter() {
        when(headHunterService.registerHeadHunter(any())).thenReturn("registerHeadHunterResponse");

        ResponseEntity result = headHunterController.registerHeadHunter(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetHeadHunter() {
        when(headHunterService.findHeadHunterByLogin(anyString())).thenReturn(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"));

        ResponseEntity result = headHunterController.getHeadHunter("acc");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateTest() {
        when(headHunterService.createTest(any(), anyString())).thenReturn(new Tests(0L, "question1", "question2", "question3"));

        ResponseEntity result = headHunterController.createTest("acc", new Tests(0L, "question1", "question2", "question3"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllTest() {
        when(headHunterService.getAllTest(anyString())).thenReturn(Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")));

        ResponseEntity result = headHunterController.getAllTest("acc");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetResults() {
        when(headHunterService.getResults()).thenReturn(Arrays.<TestResult>asList(new TestResult()));

        ResponseEntity result = headHunterController.getResults("acc");
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme