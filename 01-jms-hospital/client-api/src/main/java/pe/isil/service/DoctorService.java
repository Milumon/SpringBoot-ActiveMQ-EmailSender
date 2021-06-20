package pe.isil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.isil.model.Doctor;
import pe.isil.repository.DoctorRepository;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorEventService doctorEventService;

    public Doctor save(Doctor doctor){
        Doctor doctorSaved = doctorRepository.save(doctor);
        doctorEventService.sendEvent(doctorSaved);
        return doctorSaved;
    }

}
