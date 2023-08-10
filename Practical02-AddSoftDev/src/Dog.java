import java.util.HashSet;
import java.util.Set;

public class Dog {
    private String name;
    private String dogBreed;
    private int regNum;
    private Set<String> owners = new HashSet<>();

    public Dog() {
        name = "unknown";
        dogBreed = "unknown";
        regNum = -1;
    }

    public Dog(String name, String dogBreed, int regNum) {
        this.name = name;
        this.dogBreed = dogBreed;
        this.regNum = regNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public int getRegNum() {
        return regNum;
    }

    public void setRegNum(int regNum) {
        this.regNum = regNum;
    }

    public Set<String> getOwners() {
        return owners;
    }

    public void addOwner(String owner) {
        owners.add(owner);
    }

    @Override
    public String toString() {
        return "Dog " + name + ", Breed = " + dogBreed + ", #owners = " + owners.size() + ", Registration #: " + regNum;
    }
}
