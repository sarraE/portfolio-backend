package tn.portfolio.portofolio.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.portfolio.portofolio.Services.IVisitorStatService;

@RestController
@AllArgsConstructor
<<<<<<< HEAD
//@CrossOrigin(origins = "http://localhost:4200")
=======
>>>>>>> f4a8c969f815e3d4eda25a084275cea2080c9d8a

public class VisitorStatController {
    private IVisitorStatService iVisitorStatService;

    @PostMapping("/recordVisit/{page}")
    void recordVisit(@PathVariable String page){
        iVisitorStatService.recordVisit(page);
    }
    @GetMapping("/getCount/{page}")
    Long getcount(@PathVariable String page){
        return iVisitorStatService.getcount(page);
    }
}
