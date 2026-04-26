package tn.portfolio.portofolio.Services;

import tn.portfolio.portofolio.Entities.Message;

import java.util.List;

public interface IMessageService {
    Message sendMessage(Message message);
    List<Message> getAllMessages();
    Long countNotRead();
    void markedRead(Long id);
    void sendEmail(Message message);

}
