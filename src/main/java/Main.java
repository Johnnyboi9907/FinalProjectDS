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
        boolean exit = false;

        if (role == 'v') {
            Visitor visitor = new Visitor(name, password, age, null);

            while (!exit) {
                System.out.println("Select your command: ");
                System.out.println("\n1. Browse all animals\n2. Visit an animal\n3. View history of visited animals\n4. Exit.");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        for (Animal animal : animals) {
                            System.out.println(animal);
                        }
                        break;
                    case 2: visitor.visitAnimal(animals); break;
                    case 3: visitor.viewVisitedAnimals(); break;
                    case 4:
                        System.out.println("Logging out...");
                        exit = true; break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
            scanner.close();

        }

        else if (role == 'z' && age > 16) {
            Zookeeper zookeeper = new Zookeeper(name, password, age);

            while (!exit) {
                System.out.println("Select your command: ");
                System.out.println("\n1. View visitors\n2. Visit most popular animal\n3. Add a new animal\n4. Exit");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("Logging out...");
                        exit = true; break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
            scanner.close();
        }

        else System.out.println("Invalid input.");
    }
}
