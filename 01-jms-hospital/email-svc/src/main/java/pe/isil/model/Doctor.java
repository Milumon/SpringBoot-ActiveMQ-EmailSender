package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String licenceNo;
    private String specialty;

}
