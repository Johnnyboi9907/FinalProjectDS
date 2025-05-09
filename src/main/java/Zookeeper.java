import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * Overridden method from UpdateAccountInterface which prevents the Zookeeper from changing age to less than 18 years old.
     */
    @Override
    public void updateAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter current age: ");
        int old_age = scanner.nextInt();
        if (old_age == this.getAge()) {
            System.out.println("Enter new age: ");
            int new_age = scanner.nextInt();
            if (old_age != new_age && new_age >= 18) {
                this.setAge(new_age);
                System.out.println("Successfully updated age!");
            } else System.out.println("Invalid input. New age matches old age or new age is less than 18 years old.");
        } else System.out.println("Invalid age.");
    }

    /**
     * Zookeeper inputs a name, gender, age, quality and species. Then, java writes this to a file using TEXTIO (one row)
     */
    public void writeNewAnimalRecommendation() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the animal's name?");
        String name = input.next();
        System.out.println("What is the animal's gender? (m or f)");
        char choice = input.next().charAt(0);
        Animal.Gender gender;
        if (choice == 'm') {
            gender = Animal.Gender.MALE;
        } else if (choice == 'f') {
            gender = Animal.Gender.FEMALE;
        } else gender = Animal.Gender.MALE;
        System.out.println("What is the animal's age?");
        int age = input.nextInt();
        System.out.println("What is the animal's quality?");
        String quality = input.next();
        System.out.println("What kind of animal is it? (Existing species or new one)");
        String species = input.next();

        File file = new File("src/main/java/NewAnimals.csv");
        String[] new_animal = {name, String.valueOf(gender), String.valueOf(age), quality, species};
        try (FileWriter fw = new FileWriter(file, true)){
            for (String str : new_animal) {
                fw.write(str + ", ");
            }
            fw.write("\n");
        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
        }
    }

    /**
     * maps the animal nickname to the number of visitors currently visiting this animal.
     * @param visitors the List of visitors
     * @return a map, where the key is the nickname of the animal(String) and the value is the number of visitors visiting this animal(Integer).
     */
    public Map<String, Integer> viewNumberOfVisitorsPerAnimal(List<Visitor> visitors) {
        Map<String, Integer> map = new TreeMap<>();
        for (Visitor visitor : visitors) {
            Animal animal = visitor.getMy_animal();
            if (animal != null) {
                String nickname = animal.getNickname();
                map.put(nickname, map.getOrDefault(nickname, 0) + 1);
            }
        }
        return map;
    }

    /**
     * uses the above method to get the animal with the most visitors.
     * @param map the returned map from the above method
     */
    public void visitMostPopularAnimal(Map<String, Integer> map) {
        String max_key = null;
        int max_value = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max_value) {
                max_value = entry.getValue();
                max_key = entry.getKey();
            }
        }
        System.out.println(max_key + " is the most popular animal with " + max_value + " visitors.");
        System.out.println("...");
        System.out.println("You have visited " + max_key + ".");
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
