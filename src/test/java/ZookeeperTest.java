import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZookeeperTest {
    @Test
    void viewNumberOfVisitorsPerAnimal1() {
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("John", "pass", 17, new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" )));
        visitors.add(new Visitor("Michael", "abc", 12, new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" )));
        visitors.add(new Visitor("Nick", "def", 16, new Monkey("George", Animal.Gender.MALE, 3, "curious", "chimpanzee")));

        Zookeeper z = new Zookeeper();
        Map<String, Integer> expected = Map.of("Alex", 2, "George", 1);
        Map<String, Integer> result = z.viewNumberOfVisitorsPerAnimal(visitors);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void viewNumberOfVisitorsPerAnimal2() {
        List<Visitor> visitors = new ArrayList<>();

        Zookeeper z = new Zookeeper();
        Map<String, Integer> expected = Map.of();
        Map<String, Integer> result = z.viewNumberOfVisitorsPerAnimal(visitors);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void viewNumberOfVisitorsPerAnimal3() {
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("John", "pass", 17, new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" )));
        visitors.add(new Visitor("Michael", "abc", 12, new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" )));
        visitors.add(new Visitor("Nick", "def", 16, new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" )));

        Zookeeper z = new Zookeeper();
        Map<String, Integer> expected = Map.of("Alex", 3);
        Map<String, Integer> result = z.viewNumberOfVisitorsPerAnimal(visitors);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void viewNumberOfVisitorsPerAnimal4() {
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("John", "pass", 17, new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" )));
        visitors.add(new Visitor("Michael", "abc", 12, new Elephant("Dumbo", Animal.Gender.MALE, 2, "magical", 500.0)));
        visitors.add(new Visitor("Nick", "def", 16, new Monkey("George", Animal.Gender.MALE, 3, "curious", "chimpanzee")));

        Zookeeper z = new Zookeeper();
        Map<String, Integer> expected = Map.of("Alex", 1, "Dumbo", 1, "George", 1);
        Map<String, Integer> result = z.viewNumberOfVisitorsPerAnimal(visitors);
        Assertions.assertEquals(expected, result);
    }
}
