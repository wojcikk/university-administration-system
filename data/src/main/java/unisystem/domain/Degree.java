package unisystem.domain;

public class Degree {
    private long id;
    private final String name;

    public Degree(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Degree(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Degree{" +
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
