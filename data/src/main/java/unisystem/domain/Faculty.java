package unisystem.domain;

public class Faculty {
    private long id;
    private final String name;
    private final String address;

    public Faculty(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Faculty(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
