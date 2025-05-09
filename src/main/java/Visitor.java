import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        viewed_animals.add(my_animal);
    }

    @Override
    public int compareTo(Visitor o) {
        return o.getAge() - this.getAge();
    }

    /**
     * prints out the toString method of my_animal (the one you are currently viewing)
     * additionally, prints out all animals inside viewed_animals List, which contains all visited animals by the visitor.
     */
    public void viewVisitedAnimals() {
        System.out.println("You are currently viewing: " + this.my_animal);
        System.out.println("\nHere is your history of previously viewed animals: ");
        for (Animal animal : viewed_animals) {
            System.out.println(animal);
        }
    }

    /**
     * sets my_animal to the Animal which contains the input as their nickname
     * @param animals the List of animals in the zoo
     */
    public void visitAnimal(List<Animal> animals) {
        System.out.println("Which animal would you like to visit? (Enter their nickname)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        boolean found = false;
        for (Animal animal : animals) {
            if (answer.equalsIgnoreCase(animal.getNickname())) {
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

    /**
     * the user inputs a keyword, and a stream must filter out all animals whose quality does not contain the keyword.
     * @param animals the List of animals in the zoo
     * @param keyword the inputted keyword
     * @return a Set of animal nicknames (these animals contain the keyword in their quality)
     */
    public Set<String> searchForAnimalQuality(List<Animal> animals, String keyword) {
        Stream<Animal> stream = animals.stream();
        return stream.filter(animal -> animal.getQuality().contains(keyword))
                .map(Animal::getNickname)
                .collect(Collectors.toSet());
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
