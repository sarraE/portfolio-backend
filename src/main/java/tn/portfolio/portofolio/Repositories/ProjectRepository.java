package tn.portfolio.portofolio.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.portfolio.portofolio.Entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    public Project findProjectByTitle(String title);
}
