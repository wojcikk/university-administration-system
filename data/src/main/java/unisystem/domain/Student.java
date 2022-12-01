package unisystem.domain;

import lombok.*;

@AllArgsConstructor
@Data
public class Student {
    private long id;
    private Person person;
    private String email;
    private Major major;

    public Student(Person person, String email, Major major) {
        this.person = person;
        this.email = email;
        this.major = major;
    }
}

