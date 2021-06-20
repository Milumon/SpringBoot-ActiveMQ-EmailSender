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
@Table(name = "tbl_patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String firstName;
    private String lastName;
    private String email;
    private Double weight;
    private Double height;
    private String personalDisease;
    private String bloodType;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    Set<Appointment> appointments;
}
