package com.example.project666.Repository;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.TestResult;
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
import java.util.logging.Logger;

class HeadHunterRepositoryTest {
    @Mock
    Logger log;
    @Mock
    SessionFactory sessionFactory;
    @InjectMocks
    HeadHunterRepository headHunterRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterHeadHunter() {
        boolean result = headHunterRepository.registerHeadHunter(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testFindHeadHunterByLogin() {
        HeadHunter result = headHunterRepository.findHeadHunterByLogin("acc");
        Assertions.assertEquals(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles"), result);
    }

    @Test
    void testCreateTest() {
        boolean result = headHunterRepository.createTest(new Tests(0L, "question1", "question2", "question3"), "acc");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetAllTest() {
        List<HeadHunter> result = headHunterRepository.getAllTest("acc");
        Assertions.assertEquals(Arrays.<HeadHunter>asList(new HeadHunter("headhunter_login", "headhunter_password", Arrays.<Tests>asList(new Tests(0L, "question1", "question2", "question3")), "roles")), result);
    }

    @Test
    void testGetTestResults() {
        List<TestResult> result = headHunterRepository.getTestResults();
        Assertions.assertEquals(Arrays.<TestResult>asList(new TestResult()), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme