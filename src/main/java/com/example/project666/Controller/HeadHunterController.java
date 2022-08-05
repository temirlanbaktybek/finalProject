package com.example.project666.Controller;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.Tests;
import com.example.project666.Service.impl.HeadHunterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/headhunter")
public class HeadHunterController {

    @Autowired
    private HeadHunterServiceImpl headHunterService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity registerHeadHunter(@RequestBody HeadHunter headHunter){
        return ResponseEntity.ok().body(headHunterService.registerHeadHunter(headHunter));
    }

    @GetMapping("/{acc}")
    public ResponseEntity getHeadHunter(@PathVariable String acc){
        return ResponseEntity.ok().body(headHunterService.findHeadHunterByLogin(acc));
    }

    @PostMapping("/{acc}/test")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createTest(@PathVariable String acc, @RequestBody Tests tests){
        return ResponseEntity.ok().body(headHunterService.createTest(tests, acc));
    }

    @GetMapping("/{acc}/test")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllTest(@PathVariable String acc){
        return ResponseEntity.ok().body(headHunterService.getAllTest(acc));
    }

    @GetMapping("/{acc}/test/res")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getResults(@PathVariable String acc){
        return ResponseEntity.ok().body(headHunterService.getResults());
    }
}
