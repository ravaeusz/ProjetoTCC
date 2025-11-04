package com.tcc.TccProject.dto.request;

import jakarta.validation.constraints.NotNull;

public record RankingRequest(@NotNull Long id_user) {
}
