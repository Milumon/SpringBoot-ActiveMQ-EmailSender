package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

    private int patientId;
    private String firstName;
    private String lastName;
    private String email;
    private Double weight;
    private Double height;
    private String personalDisease;
    private String bloodType;
}
