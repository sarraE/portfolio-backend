package tn.portfolio.portofolio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.portfolio.portofolio.Entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Long countByReadFalse();
}
