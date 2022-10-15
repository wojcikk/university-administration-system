package unisystem.domain;

public class FieldOfStudy {
    private long id;
    private final String name;

    public FieldOfStudy(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public FieldOfStudy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FieldOfStudy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
