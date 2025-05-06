import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zookeeper extends User{
    private String id;
    private List<Visitor> visitors;
    private List<Animal> animals;

    private static int nextID = 1;

    public Zookeeper() {
        super("Unknown", "Unknown", 0);
        id = "Unknown";
        visitors = null;
        animals = null;
    }

    public Zookeeper(String name, String password, int age) {
        super(name, password, age);
        this.id = String.format("%04d", nextID++);
        this.visitors = new ArrayList<>();
        this.animals = new LinkedList<>();
    }

    public void addAnimal() {
        //TODO zookeepers can add a new animal to the zoo
    }
}
