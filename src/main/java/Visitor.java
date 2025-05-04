import java.util.List;
import java.util.Objects;

public class Visitor extends User{
    private int id;
    private Animal my_animal;
    private List<Animal> animals;

    private static int nextID = 1;

    public Visitor(String name, String password, int age) {
        super(name, password, age);
        this.id = nextID++;
    }

    public static void viewAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.toString());
            System.out.println('\n');
        }
    }

    public static void sortByAnimal(List<Animal> animals) {
        //TODO use Comparable to sort the Visitors based on my_animal (nickname ascending first, then age descending).
        // Maybe I can use NameComparator and AgeComparator in Animal class for this?
    }

    public static void pickAnimal(Animal animal) {
        //TODO my_animal.set(animal)
    }

//    public static List<Animal> searchAnimal(String keyword, List<Animal> animals) {
//        TODO use stream to filter out all Animals that do not contain the keyword, and return all those that do as a List.
//         The searching system searches animals based on their quality. These are the recommended animals for the visitor to meet.
//    }

    @Override
    public String toString() {
        return "Visitor{" + super.toString() +
                ", id: " + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Visitor visitor = (Visitor) o;
        return id == visitor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    public int getId() {
        return id;
    }
}
