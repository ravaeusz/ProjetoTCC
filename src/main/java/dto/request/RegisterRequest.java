package dto.request;

import jakarta.validation.constraints.NotNull;

public record RegisterRequest(@NotNull String nome,
                              @NotNull String email,
                              @NotNull String senha) {
}
