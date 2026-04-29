package tn.portfolio.portofolio.Services;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.portfolio.portofolio.Entities.Message;
import tn.portfolio.portofolio.Repositories.MessageRepository;
import org.springframework.scheduling.annotation.Async;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService implements IMessageService{
    private MessageRepository messageRepository;
    private JavaMailSender mailer;
     private EmailService emailService;
    @Async
    @Override

         public Message sendMessage(Message message) {
        message.setDispatchDate(LocalDateTime.now());
        Message saved = messageRepository.save(message);
        emailService.sendEmail(saved);
        return saved;
    }


    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Long countNotRead() {

        return messageRepository.countByReadFalse();
    }

    @Override
    public void markedRead(Long id) {

        Message msg = messageRepository.findById(id).orElseThrow();
        msg.setRead(true);
        messageRepository.save(msg);
    }

   
}
