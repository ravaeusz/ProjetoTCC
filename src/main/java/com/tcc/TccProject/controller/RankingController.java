package com.tcc.TccProject.controller;

import com.tcc.TccProject.Service.RankingService;
import com.tcc.TccProject.dto.request.RankingRequest;
import com.tcc.TccProject.dto.response.RankingResponse;
import com.tcc.TccProject.entity.Ranking;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rank")
public class RankingController {

    RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping("/acerto")
    public ResponseEntity<RankingResponse> correctRanking(@Valid  @RequestBody RankingRequest request){
        Optional<Ranking> search = rankingService.getRankingById(request.user_id());

        if (search.isEmpty()) {
            Ranking rank = new Ranking();
            rank.setUser(request.user());
            rank.setPontos(10);

            var save = rankingService.postRanking(rank);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RankingResponse("Registrado no ranking!", rank.getPontos()));
        }
        if (search.isPresent()){
            String save = rankingService.countPoint(request.user_id());
            return ResponseEntity.ok(new RankingResponse(save, search.get().getPontos()));
        }
        return ResponseEntity.notFound().build();
}}
