package unisystem.domain;

public class Teacher {
    private long id;
    private final Person person;
    private final String email;
    private final Faculty faculty;



    public Teacher(long id, Person person, String email, Faculty faculty) {
        this.id = id;
        this.person = person;
        this.email = email;
        this.faculty = faculty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public String getEmail() {
        return email;
    }

    public Faculty getFaculty() {
        return faculty;
    }
}
