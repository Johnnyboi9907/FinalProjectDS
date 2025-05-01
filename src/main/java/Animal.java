import java.util.Comparator;
import java.util.Objects;

public abstract class Animal  {
    private String nickname;
    private Gender gender;
    private int age;
    private String quality;

    enum Gender {
        MALE, FEMALE
    }

    public Animal(String nickname, Gender gender, int age, String quality) {
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.quality = quality;
    }

    public void makeNoise() {
        System.out.println("Makes some generic sound.");
    }

    public static class AgeComparator implements Comparator<Animal>{
        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.age - o1.age;
        }
    }

    public static class NameComparator implements Comparator<Animal>{
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.nickname.compareToIgnoreCase(o2.nickname);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nickname: " + nickname + '\'' +
                ", gender: " + gender +
                ", age: " + age +
                ", quality: " + quality + '\'' +
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
}
