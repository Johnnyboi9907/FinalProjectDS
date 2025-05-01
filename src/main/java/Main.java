import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Lion l1 = new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" );
        l1.makeNoise();
        Monkey m1 = new Monkey("George", Animal.Gender.MALE, 3, "curious", "chimpanzee");
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(l1);
        animals.add(m1);
        animals.sort(new Animal.AgeComparator()); // oldest to youngest
        System.out.println(animals);
    }
}
