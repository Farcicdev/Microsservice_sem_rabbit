package farcicDev.emailSemMq.service;

import farcicDev.emailSemMq.domain.Emails;
import farcicDev.emailSemMq.repository.EmailRepository;
import farcicDev.emailSemMq.repository.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailSender emailSender;

    private final EmailRepository emailRepository;

    public void sendMail(Emails email) {
        email.setSendDate(LocalDateTime.now());
        email.setEmailStatus(email.getEmailStatus().PROCESSING);

        try {
            emailSender.sendEmail(email);
            email.setEmailStatus(email.getEmailStatus().SENT);
        } catch (Exception e) {
            email.setEmailStatus(email.getEmailStatus().ERROR);
        }

        emailRepository.save(email);
    }
}
