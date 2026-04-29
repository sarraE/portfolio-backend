package tn.portfolio.portofolio.Services;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tn.portfolio.portofolio.Entities.Message;

@Service
@AllArgsConstructor
public class EmailService {
    private JavaMailSender mailer;

    @Async
   public void sendEmail(Message message) {
    try {
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
        System.out.println("✅ Email envoyé avec succès !");
    } catch (Exception e) {
        System.err.println("❌ Erreur envoi email: " + e.getMessage());
        e.printStackTrace();
    }
}
}
