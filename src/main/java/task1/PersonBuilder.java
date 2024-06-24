package task1;

import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше нуля");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Укажите имя человека");
        } else if (surname == null) {
            throw new IllegalStateException("Укажите фамилию человека");
        }
        if (age != null) {
            int ageInt = age.getAsInt();
            return new Person(name, surname, ageInt, address);
        }
        return new Person(name, surname, address);
    }
}
