import java.util.Objects;

public class Penguin extends Animal{
    private double height;

    public Penguin(String nickname, Gender gender, int age, String quality, double height) {
        super(nickname, gender, age, quality);
        this.height = height;
    }

    @Override
    public void makeNoise() {
        System.out.println("Screeching and squawking noise!");
    }

    @Override
    public String toString() {
        return "Penguin{" + super.toString() +
                ", height: " + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Penguin penguin = (Penguin) o;
        return Double.compare(height, penguin.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
