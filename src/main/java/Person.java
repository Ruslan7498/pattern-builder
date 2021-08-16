import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    /*
        public Person(String name, String surname) {
            if (name == null || surname == null) {
                throw new IllegalArgumentException("Name and surname not entered");
            }
            this.name = name;
            this.surname = surname;
        }

        public Person(String name, String surname, OptionalInt age) {
            if (name == null || surname == null) {
                throw new IllegalArgumentException("Name and surname not entered");
            }
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
    */
    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurnameame();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
        if (this.name == null || this.surname == null) {
            throw new IllegalArgumentException("Name or surname not entered");
        }
        if (this.age.getAsInt() < 0) {
            throw new IllegalArgumentException("Wrong age");
        }
    }

    public boolean hasAge() {
        if (this.age.isPresent()) return true;
        return false;
    }

    public boolean hasAddress() {
        if (this.address.equals(null)) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age.of(age.getAsInt() + 1);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.getSurname())
                .setAddress(this.getAddress())
                .setAge(0);
    }

    @Override
    public String toString() {
        return "Name: " + name
                + "\nSurname: " + surname
                + "\nAge: " + age.getAsInt()
                + "\nAddress: " + address;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}