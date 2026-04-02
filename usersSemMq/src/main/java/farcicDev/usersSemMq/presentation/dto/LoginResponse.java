package farcicDev.usersSemMq.presentation.dto;

public record LoginResponse (
        String message,
        String email,
        String role
){
}
