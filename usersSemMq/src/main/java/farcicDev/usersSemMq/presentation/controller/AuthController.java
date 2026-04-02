package farcicDev.usersSemMq.presentation.controller;

import farcicDev.usersSemMq.application.useCase.LoginUseCase;
import farcicDev.usersSemMq.presentation.dto.LoginRequest;
import farcicDev.usersSemMq.presentation.dto.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request){
        LoginResponse login = loginUseCase.execute(request);
        return ResponseEntity.ok(login);
    }
}
