public class DogBreeder {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting dog application");

        Dog mydog1 = new Dog();
        Dog mydog2 = new Dog("Fluffy", "Poodle", 3496);
        System.out.println(mydog1);
        System.out.println(mydog2);
    }
}
