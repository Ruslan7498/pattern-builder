public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println(mom.toString());

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom.getName() + " есть сын, " + son);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.getMessage();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }
}
