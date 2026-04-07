package farcicDev.usersSemMq.core.UsersGateway;

import farcicDev.usersSemMq.core.domain.Users;

public interface EmailGateway {

    void sendWelcomeEmail(Users users);

}
