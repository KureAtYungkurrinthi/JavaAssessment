public class Dog {
    private String name;
    private String dogBreed;
    private int regNum;

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

    @Override
    public String toString() {
        return "Dog " + name + ", Breed = " + dogBreed + ", Registration #: " + regNum;
    }
}
