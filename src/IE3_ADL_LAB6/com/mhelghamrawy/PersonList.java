package IE3_ADL_LAB6.com.mhelghamrawy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonList {
    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        persons.forEach((person) -> builder.append(person.toString())
                                            .append(System.getProperty("line.separator")));
        return builder.toString();
    }

    public void add(String name, Gender gender, int age) {
        persons.add(new Person(name, gender, age));
    }

    public double getAverageOfAges() {
        int sum = this.persons.stream()
                              .peek(System.out::println)
                              .mapToInt(Person::getAge)
                              .peek(System.out::println)
                              .sum();
        return (double) sum / this.persons.size();
    }

    public List<Person> getPersonsByCondition(Predicate<Person> condition) {
        List<Person> result = this.persons.stream()
                                  .peek(System.out::println)
                                  .filter(condition)
                                  .peek(System.out::println)
                                  .collect(Collectors.toList());
        return result;
    }

    public double getAverageOfAges(Predicate<Person> condition) {
        List<Person> searchList = getPersonsByCondition((person -> person.age > 21 && person.gender == Gender.Female));

        int sum = searchList.stream()
                .peek(System.out::println)
                .mapToInt(Person::getAge)
                .peek(System.out::println)
                .sum();

        return (double) sum / searchList.size();
    }

}
