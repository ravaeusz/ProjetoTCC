package com.tcc.TccProject.dto.response;

public record LoginResponse(String token, Long us_id, String email, String escola) {
}
