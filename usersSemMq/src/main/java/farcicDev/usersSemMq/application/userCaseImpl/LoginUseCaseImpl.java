package farcicDev.usersSemMq.application.userCaseImpl;

import farcicDev.usersSemMq.application.exeption.EmailAlreadyExistsException;
import farcicDev.usersSemMq.application.exeption.InvalidPasswordException;
import farcicDev.usersSemMq.application.useCase.LoginUseCase;
import farcicDev.usersSemMq.core.UsersGateway.UsersGateway;
import farcicDev.usersSemMq.core.domain.Users;
import farcicDev.usersSemMq.presentation.dto.LoginRequest;
import farcicDev.usersSemMq.presentation.dto.LoginResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginUseCaseImpl implements LoginUseCase {

    private final UsersGateway usersGateway;
    private final PasswordEncoder passwordEncoder;

    public LoginUseCaseImpl(UsersGateway usersGateway, PasswordEncoder passwordEncoder) {
        this.usersGateway = usersGateway;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse execute(LoginRequest loginRequest) {
        Users user = usersGateway.findByEmail(loginRequest.email())
                .orElseThrow(
                        () -> new EmailAlreadyExistsException("Email not E: " + loginRequest.email())
                );
        if(!passwordEncoder.matches(loginRequest.password(), user.password())){
            throw new InvalidPasswordException("Invalid password");
        }
        return new LoginResponse(
                "Login successful for user: ",
                user.email(),
                user.role().name()
        );
    }
}
