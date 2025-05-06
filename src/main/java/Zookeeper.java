import java.util.ArrayList;
import java.util.List;

public class Zookeeper {
    private String id;
    private List<Visitor> visitors;

    private static int nextID = 1;

    public Zookeeper() {
        id = "Unknown";
        visitors = null;
    }

    public Zookeeper(String id, List<Visitor> visitors) {
        this.id = String.format("%04d", nextID++);
        this.visitors = new ArrayList<>();
    }
}
