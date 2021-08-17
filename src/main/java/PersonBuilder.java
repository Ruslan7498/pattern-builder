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
        this.age = this.age.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getSurnameame() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return this.address;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalArgumentException("Name or surname not entered");
        }
        if (this.age.getAsInt() < 0) {
            throw new IllegalArgumentException("Wrong age");
        }
        return new Person(this);
    }
}
