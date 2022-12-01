package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private final String name;
    private final String surname;
    private final String gender;
    private final long age;
}
