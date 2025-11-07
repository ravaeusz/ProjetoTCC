package com.tcc.TccProject.repository;

import com.tcc.TccProject.entity.Ranking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankingRepositoy extends JpaRepository<Ranking, Long> {

    @Query("UPDATE Ranking r SET r.pontos = r.pontos + 1 WHERE r.id = :id")
    void countPoints(@Param("id") Long id);

    List<Ranking> findTop3ByOrderByPontosDesc();

}




