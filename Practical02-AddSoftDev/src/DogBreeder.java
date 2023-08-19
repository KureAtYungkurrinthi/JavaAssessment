import java.util.Collection;

public class DogBreeder {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting dog application");
        Dog.printTotal();

        Dog mydog1 = new Dog();
        Dog mydog2 = new Dog("Fluffy", "Poodle", 3496);
        System.out.println(mydog1);
        System.out.println(mydog2);

        // Task 2
        mydog1.setName("Fido");
        mydog1.addOwner("Anne");
        mydog1.addOwner("Bob");
        mydog2.addOwner("Martha");
        System.out.println(mydog1);
        System.out.println(mydog1.getName());
        System.out.println(mydog2.getName());
        Dog.printTotal();

        // Task 4
        System.out.println("\nStarting dog register");

        // Modify the main method so that it creates a DogRegister object,
        // adds lots of dogs to it and demonstrates that your methods are correct.
        DogRegister register = new DogRegister();
        Dog mydog3 = new Dog("Charlie", "Siberian Husky", 101);
        Dog mydog4 = new Dog("Bella", "Tugou", 102);
        Dog mydog5 = new Dog("Luna", "Tugou", 103);
        Dog mydog6 = new Dog("Lucy", "Shiba Inu", 104);
        register.addDog(mydog1);
        register.addDog(mydog2);
        register.addDog(mydog3);
        register.addDog(mydog4);
        register.addDog(mydog5);
        register.addDog(mydog6);
        System.out.println(register);
        Dog.printTotal();

        // Testing retrieving a dog
        Dog retrievedDog = register.getDog(101);
        System.out.println("\nRetrieved dog: " + retrievedDog);

        // Testing deletion
        Dog deletedDog = register.deleteDog(-1);
        System.out.println("\nDeleted dog: " + deletedDog);
        System.out.println("Register after deletion: \n" + register);

        // Testing deletion when no Dog has that registration number
        Dog nonExistedDog = register.deleteDog(111);
        System.out.println("\nTrying to delete non-existed dog: " + nonExistedDog);

        // Testing getting dogs with a specific name sequence
        Collection<Dog> dogsWithName = register.getDogsWhoseNameContains("Lu");
        System.out.println("\nDogs with names containing 'Lu': " + dogsWithName);

        // Task 5
        // Testing re-orders (sorts) the register
        register.GroupByBreed();
        System.out.println("\nRegister after grouping: \n" + register);


    }
}
