import java.util.*;

public class Visitor extends User implements Comparable<Visitor>{
    private int id;
    private Animal my_animal;
    private List<Animal> viewed_animals; // this List is to add all visited animals of this visitor

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

    public void visitAnimal(List<Animal> animals) {
        System.out.println("Which animal would you like to visit? (Enter their nickname)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        boolean found = false;
        for (Animal animal : animals) {
            if (answer.equals(animal.getNickname())) {
                this.setMy_animal(animal);
                viewed_animals.add(animal);
                System.out.println("Visit successful!");
                found = true; break;
            }
        }
        if (!found) {
            System.out.println("This animal is not in the zoo.");
        }
    }

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
        return id == visitor.id && Objects.equals(my_animal, visitor.my_animal) && Objects.equals(viewed_animals, visitor.viewed_animals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, my_animal, viewed_animals);
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
