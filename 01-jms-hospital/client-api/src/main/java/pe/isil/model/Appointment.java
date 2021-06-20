package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patientId")
    Patient patient;


    private String disease;
    private String detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAppointment;

    private String timeOfAppointment;

}
