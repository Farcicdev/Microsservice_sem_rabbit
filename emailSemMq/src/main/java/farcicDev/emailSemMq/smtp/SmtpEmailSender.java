package farcicDev.emailSemMq.smtp;

import farcicDev.emailSemMq.domain.Emails;
import farcicDev.emailSemMq.repository.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SmtpEmailSender implements EmailSender {

    private final JavaMailSender sender;

    private String EmailFrom = "${EMAIL_USERNAME}";

    @Override
    public void sendEmail(Emails email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EmailFrom);
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        sender.send(message);
    }
}
