package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceAppointment {

    private final JavaMailSender javaMailSender;
    private final String emailFrom;
    private final String emailSubject;
    private final String emailText;


    public EmailServiceAppointment(JavaMailSender javaMailSender,
                                   @Value("${app.email.fromOne}") String emailFrom,
                                   @Value("${app.email.subjectOne}") String emailSubject,
                                   @Value("${app.email.bodyOne}") String emailText) {
        this.javaMailSender = javaMailSender;
        this.emailFrom = emailFrom;
        this.emailSubject = emailSubject;
        this.emailText = emailText;
    }


    public void sendEmail(String emailTo){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(this.emailFrom);
        msg.setTo(emailTo);
        msg.setSubject(this.emailSubject);
        msg.setText(this.emailText);

        javaMailSender.send(msg);
        log.info("Se envió el email de bienvenida a {}", emailTo);
    }


}
