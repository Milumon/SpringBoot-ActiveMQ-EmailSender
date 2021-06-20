package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pe.isil.model.Appointment;
import pe.isil.util.Formatter;

@Slf4j
@Service
public class AppointmentEventService {

    private final JmsTemplate jmsTemplate;
    private final Formatter formatter;
    private final String appointmentQueueName;

    public AppointmentEventService(JmsTemplate jmsTemplate, Formatter formatter, @Value("${appointment.queue.name}") String appointmentQueueName) {
        this.jmsTemplate = jmsTemplate;
        this.formatter = formatter;
        this.appointmentQueueName = appointmentQueueName;
    }

    public void sendEvent(Appointment appointment) {
        log.info("new appointment = {}",appointment);
        String objectString = formatter.objectToString(appointment);
        jmsTemplate.convertAndSend(appointmentQueueName, objectString);
        log.info("Se envió un mensaje a la cola {}",appointmentQueueName);
    }
}
