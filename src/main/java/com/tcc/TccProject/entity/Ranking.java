package com.tcc.TccProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ranking")
public class Ranking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rk_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "us_id")
    private User user;
    @Column(name = "rk_pontos")
    private Integer pontos;
    @Column(name = "rk_create_at")
    private LocalDate createAT;

}
