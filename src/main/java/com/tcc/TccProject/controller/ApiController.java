package com.tcc.TccProject.controller;

import com.tcc.TccProject.dto.response.ApiResponse.ApiResponeInfos.ApiResponse;
import com.tcc.TccProject.dto.response.ApiResponse.ApiResponseQuestions.ApiResponseQuestions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/version")
    public ResponseEntity<String> Version(){
        return ResponseEntity.ok("1.0.0");
    }

    @GetMapping("/infos")
    public ResponseEntity<List<ApiResponse>> getInfosProvas() throws URISyntaxException, IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.enem.dev/v1/exams";

        ApiResponse[] response = restTemplate.getForObject(url, ApiResponse[].class);

        return ResponseEntity.ok(List.of(response));
    }

    @GetMapping("/question")
    public ResponseEntity<ApiResponseQuestions> getQuestionsAleatoria(){
        RestTemplate restTemplate = new RestTemplate();
        //Gera um numero e ano aleatório para agreagar ao endpoint
        Random random = new Random();
        Integer year = random.nextInt(2023 - 2009) + 2009;
        Integer index = random.nextInt(179);

        String url = "https://api.enem.dev/v1/exams/"+year+"/questions/"+index;

        ApiResponseQuestions response = restTemplate.getForEntity(url, ApiResponseQuestions.class).getBody();

        return ResponseEntity.ok(response);
    }
}
