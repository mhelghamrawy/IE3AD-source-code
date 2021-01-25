package IE3_ADL_LAB6.com.mhelghamrawy;

public class Person {
    public final String name;
    public final Gender gender;
    public final int age;

    public Person(String name, Gender gender,int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.gender + " " + this.age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
