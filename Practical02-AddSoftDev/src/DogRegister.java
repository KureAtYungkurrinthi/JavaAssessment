import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DogRegister {
    private final List<Dog> dogRegister = new ArrayList<>();

    // Adds a dog to the register
    public void addDog(Dog dog) {
        dogRegister.add(dog);
    }

    // Returns the Dog with a registration number of
    // regNum, if it exists, otherwise returns null.
    public Dog getDog(int regNum) {
        for (Dog dog : dogRegister)
            if (dog.getRegNum() == regNum) return dog;
        return null;
    }

    // Returns the current dog register
    public List<Dog> getRegister() {
        return dogRegister;
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

    // Returns a Collection<Dog> containing all the Dogs whose name contains
    // charSequence.  Does not change the contents of the register.
    // Include thorough testing code in the main method.
    public Collection<Dog> getDogsWhoseNameContains(String charSequence) {
        List<Dog> output = new ArrayList<>();
        for (Dog dog : dogRegister)
            if (dog.getName().contains(charSequence)) output.add(dog);
        return output;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < dogRegister.size(); i++) {
            output.append(dogRegister.get(i));
            if (i < dogRegister.size() - 1) output.append("\n");
        }
        return output.toString();
    }
}
