package farcicDev.emailSemMq.Mapper;

import farcicDev.emailSemMq.controller.dto.EmailRequest;
import farcicDev.emailSemMq.domain.Emails;
import org.springframework.stereotype.Component;

@Component
public class MapperEmail {

    public Emails toEmail(EmailRequest requestEmail) {
        return Emails.builder()
                .emailTo(requestEmail.emailTo())
                .subject(requestEmail.subject())
                .body(requestEmail.body())
                .build();
    }

}
