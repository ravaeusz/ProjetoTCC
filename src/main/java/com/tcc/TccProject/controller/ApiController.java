package com.tcc.TccProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/version")
    public ResponseEntity<String> Version(){
        return ResponseEntity.ok("1.0.0");
    }
}
