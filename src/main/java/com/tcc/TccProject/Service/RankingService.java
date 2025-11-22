package com.tcc.TccProject.Service;

import com.tcc.TccProject.entity.Ranking;
import com.tcc.TccProject.entity.User;
import com.tcc.TccProject.repository.RankingRepositoy;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RankingService {

    private final RankingRepositoy rankingRepositoy;

    public RankingService(RankingRepositoy rankingRepositoy) {
        this.rankingRepositoy = rankingRepositoy;
    }

    public Optional<Ranking> getRankingById(Long userId) {
        return rankingRepositoy.findById(userId);
    }


    public List<Ranking> getPodiumRanking(){
        return rankingRepositoy.findTop3ByOrderByPontosDesc();
    }

    public List<Ranking> getGeneralRank(){
        return rankingRepositoy.findAll();
    }

    public Optional<Ranking> findRankByUserId(Long id){
        return rankingRepositoy.findByUserId(id);
    }

    public Ranking postRanking(Ranking ranking){
        return rankingRepositoy.save(ranking);
    }

    public String countPoint(@NotNull User user){
        rankingRepositoy.countPoints(user);
        return "Contabilizado com sucesso";
    }


}
