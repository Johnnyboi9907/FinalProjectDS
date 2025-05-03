import java.util.Objects;
import java.util.Scanner;

public abstract class User implements UpdateAccountInterface {
    private String name;
    private String password;
    private int age;
    private int id;

    public static int nextID = 1;

    public User(String name, String password, int age, int id) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.id = nextID++;
    }

    @Override
    public void updatePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter current password: ");
        String old_password = scanner.next();
        if (old_password.equals(password)) {
            System.out.println("Enter new password: ");
            String new_password = scanner.next();
            this.setPassword(new_password);
        } else System.out.println("Invalid password.");
    }

    @Override
    public void updateAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter current age: ");
        int old_age = scanner.nextInt();
        if (old_age == age) {
            System.out.println("Enter new age: ");
            int new_age = scanner.nextInt();
            this.setAge(new_age);
        } else System.out.println("Invalid age.");
    }

    @Override
    public String toString() {
        return "{name: " + name +
                ", password: " + password +
                ", age: " + age +
                ", id: " + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && id == user.id && Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, age, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
