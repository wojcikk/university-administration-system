package unisystem.domain;

public class Major {
    private long id;
    private final FieldOfStudy fieldOfStudy;
    private final Degree degree;
    private final Faculty faculty;

    public Major(long id, FieldOfStudy fieldOfStudy, Degree degree, Faculty faculty) {
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
        this.degree = degree;
        this.faculty = faculty;
    }

    public Major(FieldOfStudy fieldOfStudy, Degree degree, Faculty faculty) {
        this.fieldOfStudy = fieldOfStudy;
        this.degree = degree;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", fieldOfStudy=" + fieldOfStudy +
                ", degree=" + degree +
                ", faculty=" + faculty +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public Degree getDegree() {
        return degree;
    }

    public Faculty getFaculty() {
        return faculty;
    }
}
