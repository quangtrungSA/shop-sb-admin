package vn.edu.leading.shop.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.UserModel;

/**
 * Service for sending emails.
 * <p>
 * We use the @Async annotation to send emails asynchronously.
 */
@Service
public class MailService {
     private JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendMail(UserModel user) throws Exception{
        //send Mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("lyvanquangtrung@gmail.com");
        mail.setSubject("Welcome to My Website");
        mail.setText("Hello, " + user.getFirstName() + " This is a cool email notificaiton");
        javaMailSender.send(mail);
    }
}
