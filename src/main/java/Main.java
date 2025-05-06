import java.util.ArrayList;

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

        Visitor v1 = new Visitor("John", "password", 18, l1);
        System.out.println(v1); // my_animal is a lion
        v1.visitAnimal(m1);
        System.out.println(v1); // my_animal is a monkey
        v1.viewVisitedAnimals();
    }
}
