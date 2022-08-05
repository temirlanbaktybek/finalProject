package com.example.project666.AOPConfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

class AspectConfigTest {
    @Mock
    Logger log;
    @InjectMocks
    AspectConfig aspectConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testExecuteLogging() {
        aspectConfig.executeLogging();
    }

    @Test
    void testLogMethodCall() {
        aspectConfig.logMethodCall(null);
    }

    @Test
    void testLogMethodReturn() {
        aspectConfig.logMethodReturn(null, "result");
    }

    @Test
    void testLogMethodExit() {
        aspectConfig.logMethodExit(null);
    }

    @Test
    void testAround() {
        aspectConfig.Around(null);
    }

    @Test
    void testThrowing() {
        aspectConfig.Throwing(null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme