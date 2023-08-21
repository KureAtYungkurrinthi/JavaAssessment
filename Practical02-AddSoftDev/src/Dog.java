import java.util.HashSet;
import java.util.Set;

public class Dog {
    private static int count = 0;
    private final Set<String> owners = new HashSet<>();
    private final int seqNum;
    private String name;
    private String dogBreed;
    private int regNum;

    public Dog() {
        count++;
        seqNum = count;
        name = "unknown";
        dogBreed = "unknown";
        regNum = -1;
    }

    public Dog(String name, String dogBreed, int regNum) {
        count++;
        seqNum = count;
        this.name = name;
        this.dogBreed = dogBreed;
        this.regNum = regNum;
    }

    public static void printTotal() {
        System.out.println("Total number of dogs bred = " + count);
    }

    public static int getCount() {
        return count;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return dogBreed;
    }

    public void setBreed(String dogBreed) {
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
        return "Dog " + name + ", Breed = " + dogBreed + ", #owners = " + owners.size() + ", Registration #: " + regNum + ", Sequence #: " + seqNum;
    }
}
