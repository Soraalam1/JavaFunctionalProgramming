package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        System.out.println("//Imperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person: people){
            if (Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female : females){
            System.out.println(female);
        }

        System.out.println("//Declarative approach");
        //stream is an abstract mode where we tell it what we want
        people.stream()
                //filter all the females
                .filter(person -> Gender.FEMALE.equals(person.gender))
                //put them in a list, NOT even needed since we're just printing
                .collect(Collectors.toList())
                //print everything
                .forEach(System.out::println);

        //Predicate is returns a boolean value, you can just do it in line
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List<Person> femalesDeclarativeList = people.stream()
                                .filter(personPredicate)
                                .collect(Collectors.toList());

        femalesDeclarativeList.forEach(System.out::println);
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
        MALE, FEMALE
    }
}
