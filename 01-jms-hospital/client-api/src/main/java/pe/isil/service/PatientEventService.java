package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pe.isil.model.Patient;
import pe.isil.util.Formatter;


@Slf4j
@Service
public class PatientEventService {

    private final JmsTemplate jmsTemplate;
    private final Formatter formatter;
    private final String patientQueueName; 

    public PatientEventService(JmsTemplate jmsTemplate, Formatter formatter, @Value("${patient.queue.name}") String patientQueueName) {
        this.jmsTemplate = jmsTemplate;
        this.formatter = formatter;
        this.patientQueueName = patientQueueName;
    }

    public void sendEvent(Patient patient) {
        log.info("new patient = {}",patient);
        String objectString = formatter.objectToString(patient);
        jmsTemplate.convertAndSend(patientQueueName, objectString);
        log.info("Se envió un mensaje a la cola {}",patientQueueName);
    }
    
}
