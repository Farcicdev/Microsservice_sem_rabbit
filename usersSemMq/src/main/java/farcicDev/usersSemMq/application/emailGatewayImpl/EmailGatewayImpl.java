package farcicDev.usersSemMq.application.emailGatewayImpl;

import farcicDev.usersSemMq.core.UsersGateway.EmailGateway;
import farcicDev.usersSemMq.core.domain.Users;
import farcicDev.usersSemMq.infra.client.EmailClient;
import farcicDev.usersSemMq.infra.client.dto.EmailRequestFeign;
import org.springframework.stereotype.Component;

@Component
public class EmailGatewayImpl implements EmailGateway {

    private final EmailClient emailClient;

    public EmailGatewayImpl(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void sendWelcomeEmail(Users users) {
        EmailRequestFeign emailRequest = new EmailRequestFeign(
                users.email(),
                "Welcome to our service!",
                "Dear " + users.name() + ",\n\nThank you for registering with us. We're excited to have you on board!\n\nBest regards,\nThe Team"
        );
        emailClient.sendEmail(emailRequest);
    }
}
