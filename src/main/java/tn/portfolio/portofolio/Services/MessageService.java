package tn.portfolio.portofolio.Services;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.portfolio.portofolio.Entities.Message;
import tn.portfolio.portofolio.Repositories.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService implements IMessageService{
    private MessageRepository messageRepository;
    private JavaMailSender mailer;
    @Override

        public Message sendMessage(Message message) {
            message.setDispatchDate(LocalDateTime.now());
            Message saved = messageRepository.save(message);
            sendEmail(saved);
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

    @Override
    public void sendEmail(Message message) {

        SimpleMailMessage email = new SimpleMailMessage();


        email.setTo("sarraelkamel99@gmail.com");


        email.setReplyTo(message.getEmail());

        email.setSubject("Nouveau message : " + message.getSubject());

        email.setText(
                "Nom : " + message.getName() + "\n" +
                        "Email : " + message.getEmail() + "\n\n" +
                        message.getContent()
        );

        mailer.send(email);
    }
}
