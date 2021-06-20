package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import pe.isil.model.Doctor;
import pe.isil.util.Formatter;

@Slf4j
@Service
public class DoctorEventService {

    private final String doctorQueueName = "doctorQueue";
    @Autowired
    private final Formatter formatter;

    public DoctorEventService(Formatter formatter ) {
        this.formatter = formatter;
    }

    @JmsListener(destination = doctorQueueName)
    public void receiveEvent(String doctorString){
        Doctor doctor = formatter.stringToObject(doctorString, Doctor.class);
        log.info("doctor: {}",doctor);
    }


}
