public class DogsNamedBarry implements DogCondition {
    @Override
    public boolean satisfies(Dog dog) {
        return dog.getName().equalsIgnoreCase("Barry");
    }
}
