package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Имя не указано");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null) {
            throw new IllegalArgumentException("Фамилия не указана");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя или фамилия не указаны");
        }
        if (age <= 0) {
            //throw new IllegalStateException("Возраст не может быть отрицательным");
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
            person.setAddress(address);
        }
        return person;
    }
}
