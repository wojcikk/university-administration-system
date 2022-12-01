package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FieldOfStudy {
    private long id;
    private String name;

    public FieldOfStudy(String name) {
        this.name = name;
    }
}
