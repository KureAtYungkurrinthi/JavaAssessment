import java.util.ArrayList;

public class DogRegister {
    private final ArrayList<Dog> dogRegister = new ArrayList<>();

    // Adds a dog to the register
    public void addDog(Dog dog) {
        dogRegister.add(dog);
    }

    // Removes, and returns, the Dog with a registration number of regNum
    // If there is no Dog with that sequence number, null is returned.
    // Include thorough testing code in the main method.
    public Dog deleteDog(int regNum) {
        for (int i = 0; i < dogRegister.size(); i++)
            if (dogRegister.get(i).getRegNum() == regNum) {
                Dog toBeDeleted = dogRegister.get(i);
                dogRegister.remove(i);
                return toBeDeleted;
            }
        return null;
    }

    // Returns the Dog with a registration number of
    // regNum, if it exists, otherwise returns null.
    public Dog getDog(int regNum) {
        for (Dog dog : dogRegister)
            if (dog.getRegNum() == regNum)
                return dog;
        return null;
    }

    // The usual toString method.
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Dog dog : dogRegister)
            out.append(dog.toString()).append("\n");
        return out.toString();
    }
}
