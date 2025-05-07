import java.util.*;

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
        visitors.add(new Visitor("John", "pass", 17, l1));
        visitors.add(new Visitor("Michael", "LOL123", 18, l1));
        visitors.add(new Visitor("Nick", "abc456", 40, m1));
        visitors.add(new Visitor("George", "password", 30, e1));

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
                System.out.println("\n1. Browse all animals\n2. Visit an animal\n3. View history of visited animals\n4. Change password\n5. Change age\n6. View profile\n7. Exit.");
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
                    case 7:
                        System.out.println("Logging out...");
                        exit = true; break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
            scanner.close();

        }

        else if (role == 'z' && age > 18) {
            Zookeeper zookeeper = new Zookeeper(name, password, age);

            while (!exit) {
                System.out.println("Select your command: ");
                System.out.println("\n1. Browse all visitors\n2. View the number of visitors per animal\n3. Visit most popular animal\n4. Add a new animal\n5. Change password\n6. Change age\n7. View profile\n8. Exit");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        Collections.sort(visitors);
                        for (Visitor visitor : visitors) {
                            System.out.println(visitor.getName() + ", age " + visitor.getAge() + ", id " + visitor.getId() + ", is currently visiting " + visitor.getMy_animal().getNickname() + ".");
                        } break;
                    case 2:
                        Map<String, Integer> map = zookeeper.viewNumberOfVisitorsPerAnimal(visitors);
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue() + " visitors");
                        } break;
                    case 3: break;
                    case 4: break;
                    case 5: zookeeper.updatePassword(); break;
                    case 6: zookeeper.updateAge(); break;
                    case 7:
                        System.out.println(zookeeper); break;
                    case 8:
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
