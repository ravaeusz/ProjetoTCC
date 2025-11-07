package com.tcc.TccProject.dto.request;

import com.tcc.TccProject.entity.User;
import jakarta.validation.constraints.NotNull;

public record RankingRequest(@NotNull Long user_id,
                             @NotNull Integer pontos) {
}
