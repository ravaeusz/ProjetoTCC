package com.tcc.TccProject.repository;

import com.tcc.TccProject.entity.Ranking;
import com.tcc.TccProject.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RankingRepositoy extends JpaRepository<Ranking, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Ranking r SET r.pontos = r.pontos + 10 WHERE r.user = :id")
    void countPoints(@Param("id") User id);

    List<Ranking> findTop3ByOrderByPontosDesc();

    Optional<Ranking> findByUserId(Long userId);


}




