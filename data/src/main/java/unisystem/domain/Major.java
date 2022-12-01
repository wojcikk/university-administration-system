package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Major {
    private long id;
    private FieldOfStudy fieldOfStudy;
    private Degree degree;
    private Faculty faculty;

    public Major(FieldOfStudy fieldOfStudy, Degree degree, Faculty faculty) {
        this.fieldOfStudy = fieldOfStudy;
        this.degree = degree;
        this.faculty = faculty;
    }
}
