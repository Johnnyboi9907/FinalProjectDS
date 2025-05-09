import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VisitorTest {
    @Test
    void searchForAnimalQuality1() {
        Animal l1 = new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" );
        Animal m1 = new Monkey("George", Animal.Gender.MALE, 3, "curious", "chimpanzee");
        Animal e1 = new Elephant("Dumbo", Animal.Gender.MALE, 2, "magical", 500.0);
        Animal p1 = new Penguin("Skipper", Animal.Gender.MALE, 6, "smart", 12);
        List<Animal> animals = new ArrayList<>(10);
        animals.add(l1);
        animals.add(m1);
        animals.add(e1);
        animals.add(p1);

        String keyword = "curious";
        Visitor v = new Visitor();

        Set<String> expected = Set.of("George");
        Set<String> result = v.searchForAnimalQuality(animals, keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void searchForAnimalQuality2() {
        Animal l1 = new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" );
        Animal l2 = new Lion("AAA", Animal.Gender.MALE, 12, "ferocious", "gold" );
        Animal l3 = new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" );
        List<Animal> animals = new ArrayList<>(10);
        animals.add(l1);
        animals.add(l2);
        animals.add(l3);

        String keyword = "ferocious";
        Visitor v = new Visitor();

        Set<String> expected = Set.of("Alex", "AAA");
        Set<String> result = v.searchForAnimalQuality(animals, keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void searchForAnimalQuality3() {
        List<Animal> animals = new ArrayList<>(10);

        String keyword = "ferocious";
        Visitor v = new Visitor();

        Set<String> expected = Set.of();
        Set<String> result = v.searchForAnimalQuality(animals, keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void searchForAnimalQuality4() {
        Animal l1 = new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" );
        Animal l2 = new Lion("AAA", Animal.Gender.MALE, 12, "ferocious", "gold" );
        Animal l3 = new Lion("Alex", Animal.Gender.MALE, 12, "curious", "gold" );
        List<Animal> animals = new ArrayList<>(10);
        animals.add(l1);
        animals.add(l2);
        animals.add(l3);

        String keyword = "ious";
        Visitor v = new Visitor();

        Set<String> expected = Set.of("Alex", "AAA");
        Set<String> result = v.searchForAnimalQuality(animals, keyword);

        Assertions.assertEquals(expected, result);
    }
}
