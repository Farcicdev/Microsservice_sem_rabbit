package farcicDev.emailSemMq.repository;

import farcicDev.emailSemMq.domain.Emails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Emails, UUID> {
}
