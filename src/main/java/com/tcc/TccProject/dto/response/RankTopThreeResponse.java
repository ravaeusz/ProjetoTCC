package com.tcc.TccProject.dto.response;

import java.util.List;

public record RankTopThreeResponse(Long id,
                                   List<RegisterResponse> user,
                                   Integer pontos){
}
