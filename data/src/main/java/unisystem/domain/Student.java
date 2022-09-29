package unisystem.domain;

public class Student {
    private long id;
    private final String name;
    private final String surname;
    private final String gender;
    private final long age;
    private final String email;

    public Student(long id, String name, String surname, String gender, long age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public Student(String name, String surname, String gender, long age, String email) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public long getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }
}
