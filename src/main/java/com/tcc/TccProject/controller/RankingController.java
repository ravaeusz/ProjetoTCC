package com.tcc.TccProject.controller;

import com.tcc.TccProject.Service.RankingService;
import com.tcc.TccProject.config.AuthConfig;
import com.tcc.TccProject.dto.request.RankingRequest;
import com.tcc.TccProject.dto.response.RankPodiumResponse;
import com.tcc.TccProject.dto.response.RankingResponse;
import com.tcc.TccProject.dto.response.RegisterResponse;
import com.tcc.TccProject.entity.Ranking;
import com.tcc.TccProject.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/rank")
public class RankingController {

    private final RankingService rankingService;
    private final AuthConfig authConfig;

    public RankingController(RankingService rankingService, AuthConfig authConfig) {
        this.rankingService = rankingService;
        this.authConfig = authConfig;
    }

    @PostMapping("/acerto")
    public ResponseEntity<RankingResponse> correctRanking(@Valid  @RequestBody RankingRequest request){
        Optional<Ranking> search = rankingService.findRankByUserId(request.user_id());


        if (search.isPresent()){
            
            User user = authConfig.getUserById(request.user_id());
            String save = rankingService.countPoint(user);
            return ResponseEntity.ok(new RankingResponse(save, search.get().getPontos()));
        }

        if (search.isEmpty()) {


            User user = authConfig.getUserById(request.user_id());

            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new RankingResponse("Usuário não encontrado", 0));
            }

            Ranking rank = new Ranking();
            rank.setUser(user);
            rank.setPontos(10);

            var save = rankingService.postRanking(rank);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RankingResponse("Registrado no ranking!", rank.getPontos()));
        }

        return ResponseEntity.notFound().build();
    }



    @GetMapping("/ranktop")
    public ResponseEntity<List<RankPodiumResponse>> getTopThree(){
        List<Ranking> saves = rankingService.getPodiumRanking();

        List<RankPodiumResponse> response = saves.stream()
                .map(r -> new RankPodiumResponse(
                        r.getId(),
                        List.of(new RegisterResponse(
                                r.getUser().getNome(),
                                r.getUser().getEmail(),
                                r.getUser().getEscola()
                        )),
                        r.getPontos()
                )).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/generalrank")
    public ResponseEntity<List<RankPodiumResponse>> generalRank(){
        List<Ranking> saves = rankingService.getGeneralRank();

        List<RankPodiumResponse> response = saves.stream()
                .map(r -> new RankPodiumResponse(
                        r.getId(),
                        List.of(new RegisterResponse(
                                r.getUser().getNome(),
                                r.getUser().getEmail(),
                                r.getUser().getEscola()
                        )),
                        r.getPontos()
                )).toList();
        return ResponseEntity.ok(response);
    }


}


