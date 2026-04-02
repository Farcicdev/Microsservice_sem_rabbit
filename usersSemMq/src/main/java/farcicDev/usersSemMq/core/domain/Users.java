package farcicDev.usersSemMq.core.domain;

import java.util.UUID;

public record Users(
        UUID userId,
        String email,
        String name,
        String password,
        Role role
) {
}
