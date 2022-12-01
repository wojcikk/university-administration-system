package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Faculty {
    private long id;
    private String name;
    private String address;

    public Faculty(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
