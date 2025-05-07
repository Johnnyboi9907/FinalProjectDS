import java.util.*;

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

    public void addNewAnimal(List<Animal> animals) {
        //TODO zookeepers can add a new animal to the zoo. TEXTIO??
    }

    public void visitMostPopularAnimal(List<Animal> animals, List<Animal> visitors) {
        //TODO find the most popular animal amongst all visitors and go to it. make a map: key = animal nickname, value = how many visitors per animal.

    }

    public Map<String, Integer> viewNumberOfVisitorsPerAnimal(List<Visitor> visitors) {
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;
        for (Visitor visitor : visitors) {
            Animal animal = visitor.getMy_animal();
            if (animal != null) {
                String nickname = animal.getNickname();
                map.put(nickname, map.getOrDefault(nickname, 0) + 1);
            }
        }
        return map;
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
