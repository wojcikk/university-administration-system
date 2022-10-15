package unisystem.domain;

public class Student {
    private long id;
    private final Person person;
    private final String email;
    private final Major major;

    public Student(Person person, String email, Major major) {
        this.person = person;
        this.email = email;
        this.major = major;
    }

    public Student(long id, Person person, String email, Major major) {
        this.id = id;
        this.person = person;
        this.email = email;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", person=" + person +
                ", email='" + email + '\'' +
                ", major=" + major +
                '}';
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

    public Major getMajor() {
        return major;
    }
}
