package unisystem.domain;

public class Person {
    private final String name;
    private final String surname;
    private final String gender;
    private final long age;

    public Person(String name, String surname, String gender, long age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
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
}
