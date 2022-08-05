package com.example.project666.Controller;


import com.example.project666.Entity.HeadHunter;
import com.example.project666.Service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@EnableScheduling
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @DeleteMapping("/delete/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteUSER(@RequestBody String acc){
        return ResponseEntity.ok().body(adminService.deleteUserService(acc));
    }

    @GetMapping("/get/user")
    @ResponseStatus(HttpStatus.OK)
    @Scheduled(initialDelay=5000, fixedDelay=2500)
    public ResponseEntity getAllUSER(){
        return ResponseEntity.ok().body(adminService.getALLUsers());
    }


    @GetMapping("/get/headhunter")
    @ResponseStatus(HttpStatus.OK)
    @Scheduled(fixedDelay=5000)
    public ResponseEntity getHeadHunter(){
        List<HeadHunter> temp = adminService.getAllHeadHunters();
        return ResponseEntity.ok().body(temp);
    }

    @DeleteMapping("/delete/headhunter")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteHeadHunter(@RequestBody String acc){
        return ResponseEntity.ok().body(adminService.deleteHeadHunters(acc));
    }

    @GetMapping("/update/batch")
    @Scheduled(fixedRate=5000)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity bathOP(){
        return ResponseEntity.ok().body(adminService.batchOp());
    }
}
