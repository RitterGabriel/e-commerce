package com.domain.ecommerce.models;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank String email,
        @NotBlank String password
) {}
