package tn.portfolio.portofolio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.portfolio.portofolio.Entities.VisitorStat;

import java.util.Optional;

public interface VisitorStatRepository extends JpaRepository<VisitorStat, Long> {
    Optional<VisitorStat> findByPage(String page);

}
