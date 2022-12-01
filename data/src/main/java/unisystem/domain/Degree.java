package unisystem.domain;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@Data
@Entity
@Table(name="degrees")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String name;

    public Degree(String name) {
        this.name = name;
    }
}
