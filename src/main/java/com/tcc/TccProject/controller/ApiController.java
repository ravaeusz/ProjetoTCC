package com.tcc.TccProject.controller;

import com.tcc.TccProject.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/version")
    public ResponseEntity<String> Version(){
        return ResponseEntity.ok("1.0.0");
    }

    @GetMapping("/provas")
    public ResponseEntity<List<ApiResponse>> getProvas() throws URISyntaxException, IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.enem.dev/v1/exams";

        ApiResponse[] response = restTemplate.getForObject(url, ApiResponse[].class);

        return ResponseEntity.ok(List.of(response));
    }
}
