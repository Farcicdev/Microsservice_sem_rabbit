package farcicDev.usersSemMq.infra.client;

import farcicDev.usersSemMq.infra.client.dto.EmailRequestFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "emailClient", url = "${email-service.url}")
public interface EmailClient {

    @PostMapping("/email/send")
    String sendEmail (@RequestBody EmailRequestFeign request);

}
