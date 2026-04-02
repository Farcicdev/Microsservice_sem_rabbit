package farcicDev.usersSemMq.presentation.dto;

import farcicDev.usersSemMq.core.domain.Role;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UsersRespose(
        UUID userId,
        String email,
        String name,
        Role role
) {

}
