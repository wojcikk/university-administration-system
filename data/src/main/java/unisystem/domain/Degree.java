package unisystem.domain;

import lombok.*;


@AllArgsConstructor
@Data
public class Degree {
    private long id;
    private final String name;

    public Degree(String name) {
        this.name = name;
    }
}
