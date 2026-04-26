package tn.portfolio.portofolio.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.portfolio.portofolio.Entities.Message;
import tn.portfolio.portofolio.Services.IMessageService;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    private IMessageService iMessageService;

    @PostMapping(path = "/sendMessage")
    Message sendMessage(@RequestBody Message message) {
        return iMessageService.sendMessage(message);
    }

    @GetMapping("/getAllMessages")
    public List<Message> getAllMessages(){
        return iMessageService.getAllMessages();
    }
    @GetMapping("/countNotRead")
    public Long countNotRead(){
        return iMessageService.countNotRead();
    }
    @PutMapping("/markedRead/{id}")
    public void markedRead(@PathVariable Long id){
        iMessageService.markedRead(id);
    }
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody Message message){
        iMessageService.sendEmail(message);
    }
}
