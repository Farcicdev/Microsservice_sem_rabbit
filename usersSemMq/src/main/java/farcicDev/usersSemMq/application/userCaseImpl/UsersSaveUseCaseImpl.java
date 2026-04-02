package farcicDev.usersSemMq.application.userCaseImpl;

import farcicDev.usersSemMq.application.exeption.EmailAlreadyExistsException;
import farcicDev.usersSemMq.application.useCase.UsersSaveUseCase;
import farcicDev.usersSemMq.core.UsersGateway.UsersGateway;
import farcicDev.usersSemMq.core.domain.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersSaveUseCaseImpl implements UsersSaveUseCase {

    private final UsersGateway usersGateway;
    private final PasswordEncoder passwordEncoder;

    public UsersSaveUseCaseImpl(UsersGateway usersGateway, PasswordEncoder passwordEncoder) {
        this.usersGateway = usersGateway;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users execute(Users users) {
        //se o email ja estar no banco de dados vai lançar uma exeção
        if (usersGateway.findByEmail(users.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists: " + users.email());
        }

        // Cria um novo objeto Users com a senha codificada
        Users userWithEncodedPasword = new Users(
                users.userId(),
                users.email(),
                users.name(),
                passwordEncoder.encode(users.password()),
                users.role()
        );

        // Salva o usuário com a senha codificada no banco de dados
        return usersGateway.save(userWithEncodedPasword);
    }
}
