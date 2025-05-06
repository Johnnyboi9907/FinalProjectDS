import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Zookeeper extends User{
    private String id;

    private static int nextID = 1;

    public Zookeeper() {
        super("Unknown", "Unknown", 0);
        id = "Unknown";
    }

    public Zookeeper(String name, String password, int age) {
        super(name, password, age);
        this.id = String.format("%04d", nextID++);
    }

    public void addNewAnimal() {
        //TODO zookeepers can add a new animal to the zoo
    }

    public void viewVisitors() {
        //TODO zookeepers can view all visitors and the animal they are currently visiting (my_animal)
    }

    public void visitMostPopularAnimal() {
        //TODO find the most popular animal amongst all visitors and go to it
    }

    @Override
    public String toString() {
        return "Zookeeper{" + super.toString() +
                ", id: " + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Zookeeper zookeeper = (Zookeeper) o;
        return Objects.equals(id, zookeeper.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    public String getId() {
        return id;
    }
}
