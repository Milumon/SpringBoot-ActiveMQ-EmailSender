package pe.isil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.isil.model.Patient;
import pe.isil.repository.PatientRepository;


@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientEventService patientEventService;

    public Patient save(Patient patient){
        Patient patientSaved = patientRepository.save(patient);
        patientEventService.sendEvent(patientSaved);
        return patientSaved;
    }
}
