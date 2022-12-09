package unisystem.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "students")
public class Student extends Person implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    public Student(String name, String surname, String gender, long age, String email, Major major) {
        super(name, surname, gender, age);
        this.email = email;
        this.major = major;
    }

    public Student(String name, String surname, String gender, long age, long id, String email, Major major) {
        super(name, surname, gender, age);
        this.id = id;
        this.email = email;
        this.major = major;
    }
}

