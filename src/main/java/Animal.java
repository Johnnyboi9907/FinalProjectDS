import java.util.Comparator;
import java.util.Objects;

public abstract class Animal {
    private String nickname;
    private Gender gender;
    private int age;
    private String quality;

    enum Gender {
        MALE, FEMALE
    }

    public Animal() {
        this.nickname = "Bob";
        this.gender = Gender.MALE;
        this.age = 0;
        this.quality = "boring";
    }

    public Animal(String nickname, Gender gender, int age, String quality) {
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.quality = quality;
    }

    /**
     * run-time polymorphism. To be overridden in every Animal subclass.
     */
    public void makeNoise() {
        System.out.println("Makes some generic sound.");
    }

    /**
     * Comparator which sorts an ArrayList of Animal by age descending.
     */
    public static class AgeComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.age - o1.age;
        }
    }

    /**
     * Comparator which sorts an ArrayList of Animal by nickname ascending.
     */
    public static class NameComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.nickname.compareToIgnoreCase(o2.nickname);
        }
    }

    @Override
    public String toString() {
        return "{nickname: " + nickname +
                ", gender: " + gender +
                ", age: " + age +
                ", quality: " + quality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(nickname, animal.nickname) && gender == animal.gender && Objects.equals(quality, animal.quality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, gender, age, quality);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Gender getGender() {
        return gender;
    }
}
