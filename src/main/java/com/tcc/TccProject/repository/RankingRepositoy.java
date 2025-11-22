package com.tcc.TccProject.repository;

import com.tcc.TccProject.entity.Ranking;
import com.tcc.TccProject.entity.User;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RankingRepositoy extends JpaRepository<Ranking, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Ranking r SET r.pontos = r.pontos + 10 WHERE r.user = :user")
    void countPoints(@Param("user") @NotNull User user);

    List<Ranking> findTop3ByOrderByPontosDesc();

    @Query("SELECT r FROM Ranking r WHERE r.user.id = :userId")
    Optional<Ranking> findByUserId(@Param("userId") Long userId);

}





