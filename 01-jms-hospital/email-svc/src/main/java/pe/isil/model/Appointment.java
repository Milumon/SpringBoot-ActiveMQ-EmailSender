package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {

    private int appointmentId;
    Doctor doctor;
    Patient patient;
    private String disease;
    private String detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAppointment;
    private String timeOfAppointment;
}
