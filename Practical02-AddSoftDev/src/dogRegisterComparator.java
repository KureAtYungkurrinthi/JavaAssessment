import java.util.Comparator;

class dogRegisterComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getDogBreed().compareTo(o2.getDogBreed());
    }
}