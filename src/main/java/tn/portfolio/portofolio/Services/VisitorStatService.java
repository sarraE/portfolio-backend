package tn.portfolio.portofolio.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.portfolio.portofolio.Entities.VisitorStat;
import tn.portfolio.portofolio.Repositories.VisitorStatRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VisitorStatService implements IVisitorStatService{
    private VisitorStatRepository visitorStatRepository;
    @Override
    public void recordVisit(String page) {
        VisitorStat stat = visitorStatRepository.findByPage(page)
                .orElse(new VisitorStat());
        stat.setPage(page);
        stat.setCounter(stat.getCounter() == null ? 1L : stat.getCounter() + 1);
        stat.setLastVisit(LocalDateTime.now());
        visitorStatRepository.save(stat);
    }

    @Override
    public Long getcount(String page) {
        return visitorStatRepository.findByPage(page)
                .map(VisitorStat::getCounter)
                .orElse(0L);
    }
}
