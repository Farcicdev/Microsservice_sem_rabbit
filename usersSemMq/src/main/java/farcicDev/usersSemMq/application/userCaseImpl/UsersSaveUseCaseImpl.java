package farcicDev.usersSemMq.application.userCaseImpl;

import farcicDev.usersSemMq.application.exeption.EmailAlreadyExistsException;
import farcicDev.usersSemMq.application.useCase.UsersSaveUseCase;
import farcicDev.usersSemMq.core.UsersGateway.EmailGateway;
import farcicDev.usersSemMq.core.UsersGateway.UsersGateway;
import farcicDev.usersSemMq.core.domain.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersSaveUseCaseImpl implements UsersSaveUseCase {

    private final UsersGateway usersGateway;
    private final PasswordEncoder passwordEncoder;
    private final EmailGateway sendEmail;

    public UsersSaveUseCaseImpl(UsersGateway usersGateway, PasswordEncoder passwordEncoder, EmailGateway sendEmail) {
        this.usersGateway = usersGateway;
        this.passwordEncoder = passwordEncoder;
        this.sendEmail = sendEmail;
    }

    @Override
    public Users execute(Users users) {
        //se o email ja estar no banco de dados vai lançar uma exeção
        if (usersGateway.findByEmail(users.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists: " + users.email());
        }

        // Cria um novo objeto Users com a senha codificada
        Users encodedUser = new Users(
                users.userId(),
                users.email(),
                users.name(),
                passwordEncoder.encode(users.password()),
                users.role()
        );

        Users saved = usersGateway.save(encodedUser);

        sendEmail.sendWelcomeEmail(saved);

        // Salva o usuário com a senha codificada no banco de dados
        return saved;
    }
}
