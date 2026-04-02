package farcicDev.usersSemMq.application.useCase;

import farcicDev.usersSemMq.core.domain.Users;

public interface UsersSaveUseCase {

    //criar
    Users execute(Users users);
}
