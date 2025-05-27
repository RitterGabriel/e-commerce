package com.domain.ecommerce.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank String name,
        @Email @NotBlank String email,
        @NotBlank String password,
        @NotNull UserRole role
) {
}
