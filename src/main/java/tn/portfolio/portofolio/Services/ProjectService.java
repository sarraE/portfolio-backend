package tn.portfolio.portofolio.Services;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.portfolio.portofolio.Entities.Project;
import tn.portfolio.portofolio.Repositories.ProjectRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService implements IProjectService {
    private ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectBytitle(String title) {
        return projectRepository.findProjectByTitle(title);
    }



    @Override
    public Project createProject(MultipartFile image,String title,String description,String technologies,
                                 String githubLink,String demoLink,int ordre, LocalDate creationDate) throws IOException {
        Project project = new Project();
        String filename = StringUtils.cleanPath(image.getOriginalFilename());
        if (filename.contains("..")) {
            System.out.println("!!! Not a valid File");
        }
        project.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        project.setTitle(title);
        project.setDescription(description);
        project.setTechnologies(technologies);
        project.setGithubLink(githubLink);
        project.setDemoLink(demoLink);
        project.setOrdre(ordre);
        project.setCreationDate(creationDate);
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long idProject,MultipartFile image, String title, String description, String technologies,
                                 String githubLink, String demoLink, int ordre, LocalDate creationDate) throws IOException{
        Project project = projectRepository.findById(idProject).orElseThrow(() -> new RuntimeException("Projet non trouvé"));
        String filename = StringUtils.cleanPath(image.getOriginalFilename());
        if (filename.contains("..")) {
            System.out.println("!!! Not a valid File");
        }
        project.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        project.setTitle(title);
        project.setDescription(description);
        project.setTechnologies(technologies);
        project.setGithubLink(githubLink);
        project.setDemoLink(demoLink);
        project.setOrdre(ordre);
        project.setCreationDate(creationDate);
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long idProject) {

        projectRepository.deleteById(idProject);
    }
}
