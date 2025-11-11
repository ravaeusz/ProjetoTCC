package com.tcc.TccProject.dto.response;

import java.util.List;

public record RankPodiumResponse(Long id,
                                 List<RegisterResponse> user,
                                 Integer pontos){
}
