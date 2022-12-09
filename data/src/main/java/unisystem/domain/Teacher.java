package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "teachers")
public class Teacher extends Person implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Teacher(String name, String surname, String gender, long age, String email, Faculty faculty) {
        super(name, surname, gender, age);
        this.email = email;
        this.faculty = faculty;
    }

    public Teacher(String name, String surname, String gender, long age, long id, String email, Faculty faculty) {
        super(name, surname, gender, age);
        this.id = id;
        this.email = email;
        this.faculty = faculty;
    }
}
