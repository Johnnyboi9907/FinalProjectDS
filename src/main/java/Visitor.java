import java.util.*;

public class Visitor extends User implements Comparable<Visitor>{
    private int id;
    private Animal my_animal;
    private LinkedList<Animal> viewed_animals;

    private static int nextID = 1;

    public Visitor() {
        super("Unknown", "Unknown", 0);
        this.id = 0;
        this.my_animal = null;
        this.viewed_animals = null;
    }

    public Visitor(String name, String password, int age, Animal my_animal) {
        super(name, password, age);
        this.id = nextID++;
        this.my_animal = my_animal;
        this.viewed_animals = new LinkedList<>();
        viewed_animals.add(my_animal);
    }

    @Override
    public int compareTo(Visitor o) {
        return o.getAge() - this.getAge();
    }

    public void viewVisitedAnimals() {
        System.out.println("You are currently viewing: " + this.my_animal);
        System.out.println("\nHere is your history of previously viewed animals: ");
        for (Animal animal : viewed_animals) {
            System.out.println(animal);
        }
    }

    public static void sortByAnimal(List<Animal> animals) {
        //TODO use Comparable to sort the Visitors based on my_animal (nickname ascending first, then age descending).
        // Maybe I can use NameComparator and AgeComparator in Animal class for this?
    }

    public void visitAnimal(Animal animal) {
        this.setMy_animal(animal);
        viewed_animals.add(animal);
    }

//    public static List<Animal> searchAnimal(String keyword, List<Animal> animals) {
//        TODO use stream to filter out all Animals that do not contain the keyword, and return all those that do as a List.
//         The searching system searches animals based on their quality. These are the recommended animals for the visitor to meet.
//    }

    @Override
    public String toString() {
        return "Visitor{" + super.toString() +
                ", id: " + id +
                ", Animal: " + my_animal.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Visitor visitor = (Visitor) o;
        return id == visitor.id && Objects.equals(my_animal, visitor.my_animal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, my_animal);
    }

    public int getId() {
        return id;
    }

    public Animal getMy_animal() {
        return my_animal;
    }

    public void setMy_animal(Animal my_animal) {
        this.my_animal = my_animal;
    }
}
