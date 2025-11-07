package com.tcc.TccProject.Service;

import com.tcc.TccProject.entity.Ranking;
import com.tcc.TccProject.repository.RankingRepositoy;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RankingService {

    private final RankingRepositoy rankingRepositoy;

    public RankingService(RankingRepositoy rankingRepositoy) {
        this.rankingRepositoy = rankingRepositoy;
    }

    public Optional<Ranking> getRankingById(Long id){
        Optional<Ranking> rank = rankingRepositoy.findById(id);
        return rank;
    }

    public List<Ranking> getPodiumRanking(){
        List<Ranking> rank = rankingRepositoy.findTop3ByOrderByPontosDesc();
        return rank;
    }

    public Ranking postRanking(Ranking ranking){
        Ranking rank = new Ranking();
        LocalDate date = LocalDate.now();

        rank.setUser(ranking.getUser());
        rank.setPontos(ranking.getPontos());
        rank.setCreateAT(date);

        return rankingRepositoy.save(rank);
    }

    public String countPoint(Long id){
        rankingRepositoy.countPoints(id);
        return "Contabilizado com sucesso";
    }
}
