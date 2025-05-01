import java.util.Objects;

public class Lion extends Animal{
    private String mane_color;

    public Lion(String nickname, Gender gender, int age, String quality, String mane_color) {
        super(nickname, gender, age, quality);
        this.mane_color = mane_color;
    }

    @Override
    public void makeNoise() {
        System.out.println("ROOAAARRRR!!!");
    }

    @Override
    public String toString() {
        return "Lion{" + super.toString() +
                "mane_color='" + mane_color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lion lion = (Lion) o;
        return Objects.equals(mane_color, lion.mane_color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mane_color);
    }

    public String getMane_color() {
        return mane_color;
    }

    public void setMane_color(String mane_color) {
        this.mane_color = mane_color;
    }
}
