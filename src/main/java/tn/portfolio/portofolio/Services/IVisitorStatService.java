package tn.portfolio.portofolio.Services;

public interface IVisitorStatService {
    void recordVisit(String page);
    Long getcount(String page);
}
