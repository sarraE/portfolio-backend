package tn.portfolio.portofolio.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.portfolio.portofolio.Entities.Message;
import tn.portfolio.portofolio.Entities.Project;
import tn.portfolio.portofolio.Services.IProjectService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "https://portfolio-frontend-pznn.vercel.app")
public class ProjectController {
    public IProjectService iProjectService;

    @GetMapping("/getAllProjects")
    List<Project> getAllProjects(){
        return iProjectService.getAllProjects();
    }
    @GetMapping("/getProjectById/{title}")
    Project getProjectById(@PathVariable String title){
        return iProjectService.getProjectBytitle(title);
    }
    @PostMapping(path = "/createProject",consumes = {MULTIPART_FORM_DATA_VALUE})
    Project createProject(@RequestParam MultipartFile image, @RequestParam String title,@RequestParam String description,@RequestParam String technologies,
                          @RequestParam String githubLink,@RequestParam String demoLink,@RequestParam int ordre,@RequestParam LocalDate creationDate) throws IOException{
        return iProjectService.createProject(image,title,description,technologies,githubLink,demoLink,ordre,creationDate);
    }
    @PutMapping(path = "/updateProject/{idProject}",consumes = {MULTIPART_FORM_DATA_VALUE})
    Project updateProject(@PathVariable Long idProject,@RequestParam MultipartFile image,@RequestParam String title,@RequestParam String description,@RequestParam String technologies,
                          @RequestParam  String githubLink,@RequestParam String demoLink,@RequestParam int ordre,@RequestParam LocalDate creationDate) throws IOException{
        return iProjectService.updateProject(idProject,image,title,description,technologies,githubLink,demoLink,ordre,creationDate);
    }
    @DeleteMapping("/deleteProject/{idProject}")
    void deleteProject (@PathVariable Long idProject){
        iProjectService.deleteProject(idProject);
    }
}
