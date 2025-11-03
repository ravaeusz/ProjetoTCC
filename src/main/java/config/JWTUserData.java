package config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
