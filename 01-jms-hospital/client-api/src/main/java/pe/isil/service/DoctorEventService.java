package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pe.isil.model.Doctor;
import pe.isil.util.Formatter;

@Slf4j
@Service
public class DoctorEventService {

    private final JmsTemplate jmsTemplate;
    private final Formatter formatter;
    private final String doctorQueueName;

    public DoctorEventService(JmsTemplate jmsTemplate, Formatter formatter, @Value("${doctor.queue.name}") String doctorQueueName) {
        this.jmsTemplate = jmsTemplate;
        this.formatter = formatter;
        this.doctorQueueName = doctorQueueName;
    }

    public void sendEvent(Doctor doctor) {
        log.info("new doctor = {}",doctor);
        String objectString = formatter.objectToString(doctor);
        jmsTemplate.convertAndSend(doctorQueueName, objectString);
        log.info("Se envió un mensaje a la cola {}",doctorQueueName);
    }
}
