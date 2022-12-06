package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class Person {
    private String name;
    private String surname;
    private String gender;
    private long age;
}
