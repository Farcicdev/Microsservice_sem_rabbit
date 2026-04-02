package farcicDev.emailSemMq.controller;

import farcicDev.emailSemMq.Mapper.MapperEmail;
import farcicDev.emailSemMq.controller.dto.EmailRequest;
import farcicDev.emailSemMq.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    private final MapperEmail mapperEmail;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendMail(mapperEmail.toEmail(emailRequest));
        return "Email sent successfully!";
    }

}
