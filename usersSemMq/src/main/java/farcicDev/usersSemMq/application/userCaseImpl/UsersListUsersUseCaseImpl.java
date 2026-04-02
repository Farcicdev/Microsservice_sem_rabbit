package farcicDev.usersSemMq.application.userCaseImpl;

import farcicDev.usersSemMq.application.useCase.UsersListUserUseCase;
import farcicDev.usersSemMq.core.UsersGateway.UsersGateway;
import farcicDev.usersSemMq.core.domain.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersListUsersUseCaseImpl implements UsersListUserUseCase {

    private final UsersGateway usersGateway;

    public UsersListUsersUseCaseImpl(UsersGateway usersGateway) {
        this.usersGateway = usersGateway;
    }

    @Override
    public List<Users> execute() {
        return usersGateway.findAll();
    }
}
