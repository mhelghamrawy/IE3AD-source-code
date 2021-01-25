package IE3_ADL_LAB6.com.mhelghamrawy;

import java.util.List;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        personList.add("a", Gender.Female, 21);
        personList.add("b", Gender.Male, 24);
        personList.add("c", Gender.Female, 27);
        personList.add("d", Gender.Male, 20);
        personList.add("e", Gender.Female, 21);
        personList.add("f", Gender.Male, 22);
        personList.add("g", Gender.Female, 19);
        personList.add("h", Gender.Male, 25);
        personList.add("i", Gender.Female, 22);
        personList.add("j", Gender.Male, 22);
        personList.add("k", Gender.Female, 21);
        personList.add("l", Gender.Male, 22);
        personList.add("m", Gender.Female, 21);

        // Task 16.2
        System.out.println(personList.toString());

        // Task 16.3
        System.out.println(personList.getAverageOfAges());

        // Task 16.4
        Predicate<Person> condition = person -> (person.age > 21 && person.gender == Gender.Female);
        List<Person> searchList = personList.getPersonsByCondition(condition);
        System.out.println(searchList);

        // Task 16.5
        System.out.println(personList.getAverageOfAges(condition));

    }
}
