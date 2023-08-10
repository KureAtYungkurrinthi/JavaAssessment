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

        mydog1.setName("Fido");
        mydog1.addOwner("Anne");
        mydog1.addOwner("Bob");
        mydog2.addOwner("Martha");
        System.out.println(mydog1);
        System.out.println(mydog2);
        System.out.println(mydog1.getName());
        System.out.println(mydog2.getName());
    }
}
