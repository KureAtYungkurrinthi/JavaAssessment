import java.util.Comparator;

class DogBreedComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getBreed().compareTo(o2.getBreed());
    }
}