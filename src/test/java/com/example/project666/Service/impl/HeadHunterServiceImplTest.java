package com.example.project666.Service.impl;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.TestResult;
import com.example.project666.Entity.Tests;
import com.example.project666.Repository.HeadHunterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class HeadHunterServiceImplTest {
    @Mock
    Logger logger;
    @Mock
    HeadHunterRepository hr;
    @InjectMocks
    HeadHunterServiceImpl headHunterServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterHeadHunter() {
        when(hr.registerHeadHunter(any())).thenReturn(true);

        String result = headHunterServiceImpl.registerHeadHunter(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testFindHeadHunterByLogin() {
        when(hr.findHeadHunterByLogin(anyString())).thenReturn(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"));

        HeadHunter result = headHunterServiceImpl.findHeadHunterByLogin("acc");
        Assertions.assertEquals(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"), result);
    }

    @Test
    void testCreateTest() {
        when(hr.createTest(any(), anyString())).thenReturn(true);

        Tests result = headHunterServiceImpl.createTest(new Tests(0L, "question1", "question2", "question3"), "acc");
        Assertions.assertEquals(new Tests(0L, "question1", "question2", "question3"), result);
    }

    @Test
    void testGetAllTest() {
        when(hr.getAllTest(anyString())).thenReturn(Arrays.<HeadHunter>asList(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles")));

        List<Tests> result = headHunterServiceImpl.getAllTest("acc");
        Assertions.assertEquals(Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), result);
    }

    @Test
    void testGetResults() {
        when(hr.getTestResults()).thenReturn(Arrays.<TestResult>asList(new TestResult()));

        List<TestResult> result = headHunterServiceImpl.getResults();
        Assertions.assertEquals(Arrays.<TestResult>asList(new TestResult()), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme