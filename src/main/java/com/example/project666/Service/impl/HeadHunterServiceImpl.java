package com.example.project666.Service.impl;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.TestResult;
import com.example.project666.Entity.Tests;
import com.example.project666.Repository.HeadHunterRepository;
import com.example.project666.Service.HeadHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class HeadHunterServiceImpl implements HeadHunterService {

    Logger logger = Logger.getLogger(HeadHunterServiceImpl.class.getName());

    @Autowired
    private HeadHunterRepository hr;

    public String registerHeadHunter(HeadHunter headHunter){
        if(hr.registerHeadHunter(headHunter) == false){
            return "Registration failed...";
        }
        else{
            return "Registration success";
        }
    }


    public HeadHunter findHeadHunterByLogin(String acc) {
        HeadHunter temp = hr.findHeadHunterByLogin(acc);
        if(temp != null){
            logger.info("Headhunter with login:" + temp.getHeadhunter_login() +" found.");
            return temp;
        }
        else{
            logger.info("Headhunter with login:" + acc + " NOT found.");
            return temp;
        }
    }

    public Tests createTest(Tests tests, String acc){
        if(hr.createTest(tests, acc) == false){
            logger.warning("TEST not created");
            return tests;
        }else{
            logger.info("TEST created");
            return tests;
        }
    }

    public List<Tests> getAllTest(String acc) {
        List<HeadHunter> headHunters = hr.getAllTest(acc);
        List<Tests> temp = new ArrayList<>();
        for (HeadHunter h: headHunters) {
            if (h.getHeadhunter_login().equals(acc)){
                for(int i=0; i<h.getTests().size(); i++){
                    temp.add(h.getTests().get(i));
                }
            }
        }
        if(temp != null){
            logger.info("Test found " + temp.toString());
            return temp;
        }else {
            logger.warning("Test not found");
            return temp;
        }
    }

    public List<TestResult> getResults(){
        return hr.getTestResults();
    }
}
