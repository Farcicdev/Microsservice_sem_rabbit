package farcicDev.usersSemMq.infra.client.dto;

public record EmailRequestFeign(
        String emailTo,
        String subject,
        String body
) {
}
