package com.example.project666.Profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component(value = "profile")
@Profile("profile")
public class pro implements ProfileInt{
    @Override
    public void something() {
        System.out.println("hello Profile");
    }
}
