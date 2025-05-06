import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal l1 = new Lion("Alex", Animal.Gender.MALE, 12, "ferocious", "gold" );
        Animal m1 = new Monkey("George", Animal.Gender.MALE, 3, "curious", "chimpanzee");
        Animal e1 = new Elephant("Dumbo", Animal.Gender.MALE, 2, "magical", 500.0);
        Animal p1 = new Penguin("Skipper", Animal.Gender.MALE, 6, "smart", 12);
        List<Animal> animals = new ArrayList<>();
        animals.add(l1);
        animals.add(m1);
        animals.add(e1);
        animals.add(p1);
        animals.sort(new Animal.AgeComparator()); // oldest to youngest

        menu(animals);
    }

    public static void menu(List<Animal> animals) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Log in");
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        System.out.println("Select your role: Visitor (v) or Zookeeper (z).");
        char role = scanner.next().charAt(0);

        if (role == 'v') {
            Visitor visitor = new Visitor(name, password, age, null);
            System.out.println("Select your command: ");
            System.out.println("1. browse all animals\n2. visit an animal\n3. view history of visited animals.");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                case 2: visitor.visitAnimal(animals); break;
            }
        }

        else if (role == 'z') {
            Zookeeper zookeeper = new Zookeeper(name, password, age);
        }

        else System.out.println("Invalid input.");
    }
}
