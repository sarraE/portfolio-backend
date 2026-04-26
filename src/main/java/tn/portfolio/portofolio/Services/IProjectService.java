package tn.portfolio.portofolio.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import tn.portfolio.portofolio.Entities.Project;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IProjectService {

    List<Project> getAllProjects();
    Project getProjectBytitle(String title);
    Project createProject(MultipartFile image, String title, String description, String technologies,
                          String githubLink, String demoLink, int ordre, LocalDate creationDate) throws IOException;
    Project updateProject(Long idProject,MultipartFile image, String title, String description, String technologies,
                          String githubLink, String demoLink, int ordre,LocalDate creationDate) throws IOException;
    void deleteProject (Long idProject);
}
