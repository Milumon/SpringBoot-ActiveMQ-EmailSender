package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import pe.isil.model.Appointment;
import pe.isil.util.Formatter;

@Slf4j
@Service
public class AppointmentEventService {

    private final String appointmentQueueName = "appointmentQueue";
    @Autowired
    private final Formatter formatter;
    private final EmailServiceAppointment emailServiceAppointment;


    public AppointmentEventService(Formatter formatter, EmailServiceAppointment emailServiceAppointment) {
        this.formatter = formatter;
        this.emailServiceAppointment = emailServiceAppointment;
    }

    @JmsListener(destination = appointmentQueueName)
    public void receiveEvent(String appointmentString){
        Appointment appointment = formatter.stringToObject(appointmentString, Appointment.class);

        emailServiceAppointment.sendEmail(appointment.getPatient().getEmail());
        log.info("appointment: {}",appointment);
        log.info(appointment.getPatient().getEmail());

    }


}
