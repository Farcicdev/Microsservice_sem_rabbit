package farcicDev.emailSemMq.controller.dto;

public record EmailRequest(
        String emailTo,
        String subject,
        String body
) {
}
