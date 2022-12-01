package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {
    private long id;
    private Person person;
    private String email;
    private Faculty faculty;

    public Teacher(Person person, String email, Faculty faculty) {
        this.person = person;
        this.email = email;
        this.faculty = faculty;
    }
}
