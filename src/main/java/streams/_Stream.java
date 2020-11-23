package streams;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Bob", Gender.PREFER_NOT_TO_SAY)

        );

        //Stream is an abstraction mode
        people.stream()
                //.map() takes a Function, so we put one in on the fly with lambda
                .map(person -> person.name)
                .mapToInt(String::length)
                //.forEach can go on the end of lists/sets/etc, we print using a method reference ::
                .forEach(System.out::println);

        boolean containsFemales = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(containsFemales);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
