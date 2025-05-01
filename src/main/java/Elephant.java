import java.util.Objects;

public class Elephant extends Animal{
    private double weight;

    public Elephant(String nickname, Gender gender, int age, String quality, double weight) {
        super(nickname, gender, age, quality);
        this.weight = weight;
    }

    @Override
    public void makeNoise() {
        System.out.println("Loud trumpet noise!");
    }

    @Override
    public String toString() {
        return "Elephant{" + super.toString() +
                ", weight: " + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Elephant elephant = (Elephant) o;
        return Double.compare(weight, elephant.weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
