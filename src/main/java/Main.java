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
        List<Animal> animals = new ArrayList<>(10);
        animals.add(l1);
        animals.add(m1);
        animals.add(e1);
        animals.add(p1);

        List<Visitor> visitors = new ArrayList<>();

        menu(animals, visitors);
    }

    public static void menu(List<Animal> animals, List<Visitor> visitors) {
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
            Visitor visitor = new Visitor(name, password, age, new Monkey());
            visitors.add(visitor);

            while (!exit) {
                System.out.println("Select your command: ");
                System.out.println("\n1. Browse all animals\n2. Visit an animal\n3. View history of visited animals\n4. Change password\n5. Change age\n6. View profile\n7. Add new account\n8. Exit.");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        System.out.println("sort animals by name or age?");
                        String choice = scanner.next();
                        if (choice.equalsIgnoreCase("name")) {
                            animals.sort(new Animal.NameComparator());
                        } else if (choice.equalsIgnoreCase("age")) {
                            animals.sort(new Animal.AgeComparator());
                        }
                        for (Animal animal : animals) {
                            System.out.println(animal);
                        }
                        break;
                    case 2: visitor.visitAnimal(animals); break;
                    case 3: visitor.viewVisitedAnimals(); break;
                    case 4: visitor.updatePassword(); break;
                    case 5: visitor.updateAge(); break;
                    case 6:
                        System.out.println(visitor); break;
                    case 7: break; //TODO maybe exit the small while loop and enter a bigger while loop from the start of logging in 
                    case 8:
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
                System.out.println("\n1. View visitors\n2. Visit most popular animal\n3. Add a new animal\n4. Change password\n5. Change age\n6. View profile\n7. Exit");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        for (Visitor v : visitors) {
                            System.out.println(v);
                        } break;
                    case 2:
                    case 3:
                    case 4: zookeeper.updatePassword(); break;
                    case 5: zookeeper.updateAge(); break;
                    case 6:
                        System.out.println(zookeeper); break;
                    case 7:
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
