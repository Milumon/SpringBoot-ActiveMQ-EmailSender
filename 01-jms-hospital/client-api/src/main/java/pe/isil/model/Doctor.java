package pe.isil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String firstName;
    private String lastName;
    private String licenceNo;
    private String specialty;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    Set<Appointment> appointments;
}
