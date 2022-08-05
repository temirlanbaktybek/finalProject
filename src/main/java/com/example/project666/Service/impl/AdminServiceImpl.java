package com.example.project666.Service.impl;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Repository.AdminRepository;
import com.example.project666.Repository.JobSeekerRepository;
import com.example.project666.Service.AdminService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    Logger logger = Logger.getLogger(AdminServiceImpl.class.getName());

    @Autowired
    private JobSeekerRepository jobSeekerRepository;


    public String deleteUserService(String acc){
        if(adminRepository.deleteUSER(acc) == true && adminRepository.deleteUSERcv(acc) == true){
            return "Deleted user with login: " + acc;
        }else{
            return "Failed with deleting user with login:" + acc;
        }
    }

    public List<JobSeeker> getALLUsers() {
        List<JobSeeker> temp = adminRepository.getALLUsers();
        logger.info("GET users " + temp.toString());
        return temp;
    }

    public List<HeadHunter> getAllHeadHunters(){
        return adminRepository.getAllHeadHunter();
    }

    public String deleteHeadHunters(String acc){
        if(adminRepository.deleteHEADHUNTER(acc) == true){
            return "deleted headHunter with login:" + acc;
        }else{
            return "Failed with deleting headhunter with logun:" + acc;
        }
    }

    public String batchOp(){
        return adminRepository.batchOp();
    }

}
