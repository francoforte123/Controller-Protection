package Controller.Protection.auth.Service;

import Controller.Protection.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendPasswordResetMail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("f4kemailt3st@gmail.com");
        sms.setReplyTo("f4kemailt3st@gmail.com");
        sms.setSubject("You are subscribed!");
        sms.setText("Your activation code is:" + user.getPasswordResetCode());
        javaMailSender.send(sms);
    }

    public void sendActivationEmail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("f4kemailt3st@gmail.com");
        sms.setReplyTo("f4kemailt3st@gmail.com");
        sms.setSubject("You are subscribed!");
        sms.setText("Your activation code is:" + user.getActivationCode());
        javaMailSender.send(sms);
    }
}
