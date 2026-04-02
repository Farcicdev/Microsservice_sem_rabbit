package farcicDev.usersSemMq.application.useCase;

import farcicDev.usersSemMq.presentation.dto.LoginRequest;
import farcicDev.usersSemMq.presentation.dto.LoginResponse;

public interface LoginUseCase {

    LoginResponse execute(LoginRequest loginRequest);

}
