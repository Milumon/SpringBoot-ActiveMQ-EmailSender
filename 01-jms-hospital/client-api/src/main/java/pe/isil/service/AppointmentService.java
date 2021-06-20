package pe.isil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.isil.model.Appointment;
import pe.isil.repository.AppointmentRepository;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentEventService appointmentEventService;

    public Appointment save(Appointment appointment){
        Appointment appointmentSaved = appointmentRepository.save(appointment);
        appointmentEventService.sendEvent(appointmentSaved);
        return appointmentSaved;
    }

}
