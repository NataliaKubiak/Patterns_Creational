package task1;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address = "";

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        //оставила тут валидацию, тк конструктор не приватный
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше нуля");
        }
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public Person(String name, String surname, String address) {
        this(name, surname);
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return !"".equals(address);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (age == null) {
            throw new NullPointerException("Информация о возрасте отсутствует");
        }
        return age.getAsInt();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        String ageInt;
        if (age != null) {
            ageInt = "" + age.getAsInt();
        } else {
            ageInt = "null";
        }
        return "task1.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + ageInt +
                ", address='" + address + '\'' +
                '}';

    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(getSurname());
        result = 31 * result + Objects.hashCode(getAge());
        result = 31 * result + Objects.hashCode(getAddress());
        return result;
    }
}
