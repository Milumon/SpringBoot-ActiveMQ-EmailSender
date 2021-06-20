package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import pe.isil.model.Patient;
import pe.isil.util.Formatter;

@Slf4j
@Service
public class PatientEventService {

    private final String patientQueueName = "patientQueue";
    @Autowired
    private final Formatter formatter;
    private final EmailService emailService;


    public PatientEventService(Formatter formatter, EmailService emailService) {
        this.formatter = formatter;
        this.emailService = emailService;
    }

    @JmsListener(destination = patientQueueName)
    public void receiveEvent(String patientString){
        Patient patient = formatter.stringToObject(patientString, Patient.class);
        log.info("patient: {}",patient);
        emailService.sendEmail(patient.getEmail());
    }


}
