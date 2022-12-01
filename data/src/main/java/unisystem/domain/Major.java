package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Table(name = "majors")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "fieldOfStudy_id")
    private FieldOfStudy fieldOfStudy;
    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Major(FieldOfStudy fieldOfStudy, Degree degree, Faculty faculty) {
        this.fieldOfStudy = fieldOfStudy;
        this.degree = degree;
        this.faculty = faculty;
    }
}
