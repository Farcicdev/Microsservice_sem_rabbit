package farcicDev.usersSemMq.presentation.dto;

import farcicDev.usersSemMq.core.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsersRequest(
        @NotBlank
        @Email(message = "Invalid email format")
        String email,
        @NotBlank
        @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
        String name,
        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password,
        @NotNull(message = "Role is required")
        Role role
) {
}
