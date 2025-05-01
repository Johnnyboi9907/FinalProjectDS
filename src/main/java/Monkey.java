import java.util.Objects;

public class Monkey extends Animal{
    private String breed;

    public Monkey(String nickname, Gender gender, int age, String quality, String breed) {
        super(nickname, gender, age, quality);
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println("OU OU AH AH AH!!!");
    }

    @Override
    public String toString() {
        return "Monkey{" + super.toString() +
                ", breed: " + breed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monkey monkey = (Monkey) o;
        return Objects.equals(breed, monkey.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
