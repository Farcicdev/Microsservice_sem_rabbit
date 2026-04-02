package farcicDev.emailSemMq.repository;

import farcicDev.emailSemMq.domain.Emails;

public interface EmailSender {
    void sendEmail(Emails email);
}
