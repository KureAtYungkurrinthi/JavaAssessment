# Practical 2

## Part 1

### Task 1

Create the following class.

1. `Dog` - this class contains:
	1. private instance variable `name` of type `String` which is initialised to `"unknown"`
	2. a private instance variable, `dogBreed`, of type `String` initialised to `"unknown"`
	3. a private instance variable, `regNum`, of type `int` initialised to `-1`
	4. a method called `toString` that has no formal parameters and returns the dog’s name, breed and registration
	   number, as a String, in the following format: <br>

   <pre><code>Dog <i>name</i>, Breed = <i>dogBreed</i>, Registration #: <i>regNum</i></code></pre>

   where the words in _italics_ should be replaced with the values of the corresponding instance variables.

2. Modify the `main` method of `DogBreeder` so that it:
	1. Prints the message **"Starting dog application"**
	2. Defines a variable called `myDog` of type `Dog`, initialised to a new `Dog` object.
	3. Prints the value of `myDog` (causing the `toString` method to be called on the object referred to by `myDog`).

   Run the project. The following output should be produced:  <br>
   <pre><code>Starting dog application  
   Dog unknown, Breed = unknown, Registration #: -1
   </code></pre>

3. Add getter and setter methods, for all the instance variables, to the class `Dog`.
4. Add the following to the end of the main method contained in the class `DogBreeder`:
	1. using the appropriate setter method, set the instance variable `regNum` contained in the object referred to by
	   `myDog` to 3946.
	2. using the appropriate setter method, set the instance variable `breed` contained in `myDog` to `"Poodle"`.
	3. using the appropriate setter method, set the instance variable `name` contained in `myDog` to `"Fluffy"`
	4. Print the value of `myDog`
5. Run the application. The following output should be produced:  <br>
   <pre><code>Starting dog application  
   Dog unknown, Breed = unknown, Registration #: -1  
   Dog Fluffy, Breed = Poodle, Registration #: 3496 </code></pre>

6. Extend the definition of the class `Dog` to include a constructor with the following formal parameters, for example,
	1. `name` of type `String`
	2. `breed`, of type `String`
	3. `regNum` type `int`

   The constructor should assign each of the formal parameter to the class's respective instance variables. You can
   use the prefix `this` to disambiguate the instance variable. For example, `this.regNum` should be assigned to the
   value of `regNum`. For example,
     ```java
          new Dog("Fluffy","Poodle",3496);  
     ```

   constructs a new Dog object.   
   **Note that**  
   defining your own constructor, effectively un-defines the default constructor (`Dog()`).
7. Extend the definition of the class `Dog` to include a default constructor, namely,
   ```java 
     Dog() {}
   ```  
8. Modify the main method in the definition of the class `DogBreeder` to perform only the following:
	1. Print the message **Starting dog application**
	2. Define a variable called `myDog1` of type `Dog` and initialise it to a new `Dog` object using the default
	   constructor.
	3. Define a variable called `myDog2` of type `Dog` and initialise it to a new `Dog` object constructed with the
	   actual parameters `"Fluffy"`, `"Poodle"` and `3496`.
	4. Print the value of `myDog1`
	5. Print the value of `myDog2`
9. Run the application. The following output should be produced:  <br>
   <pre><code>Starting dog application  
   Dog unknown, Breed = unknown, Registration #: -1  
   Dog Fluffy, Breed = Poodle, Registration #: 3496
   </code></pre>

---

### Task 2

1. The class Dog should be extended/modified to include the following:
	1. Add an instance variable to store the names of the owners of a dog. The owners are usually the members
	   of a family and all family members have unique names. Use a `Set<String>` named owners to store the owners
	   names. Using a `Set` ensures we have owners with unique names. Adding “_Anne_” twice should only result in
	   one owner.
	2. Add a method called `addOwner` to add owners of a dog.
	3. Add a method called `getOwners` that returns the `Set<String>` of owners.
	4. Modify the `toString` methods to include the number of owners, as in  <br>

   <pre><code>Dog Fluffy, Breed = Poodle, #owners = _N_, Registration #: 3496</code></pre>  <br>
   where _N_ is the actual number of owners. <br><br>

2. Add statements to the end of the main method to do the following:
	1. Change the name of `myDog1` to `"Fido"` (invoke the `setName` method in the object referred to by `myDog1`).
	2. Add `“Anne”` and `“Bob”` as owners of `myDog1`
	3. Add `“Martha”` as the owner of `myDog2`
	4. Print the value of `myDog1` and then `myDog2`
	5. Print the names of `myDog1` and `myDog2` (invoke the `getName` method on the objects referred to by `myDog1` and
	   `myDog2` respectively and `print` out the results).  <br><br>
	   Run the application. The following output should be produced:

   <pre><code>Starting dog application
   Dog unknown, Breed = unknown, #owners = 0, Registration #: -1
   Dog Fluffy, Breed = Poodle, #owners = 0, Registration #: 3496
   Dog Fido, Breed = unknown, #owners = 2, Registration #: -1
   Dog Fluffy, Breed = Poodle, #owners = 1, Registration #: 3496
   Fido
   Fluffy
   </code></pre>

---

### Task 3

1. The class `Dog` should be extended/modified to include the following:
	1. A **static variable** named `count` that is a count of the total number of `Dog` objects created. It should
	   increase when each new dog is created (that is, in the both Dog constructors).
	2. A getter method for the `count` variable
	3. A static method called `printTotal` which outputs the total number of dogs created.
	   For example,  
	   <br><tt>Total number of dogs bred = 2</tt>  <br><br>
	4. A sequence number of each dog should be stored (an instance variable named `seqNum`) and returned with the
	   other dog information as part of the `Dog` class's `toString` method. The sequence number is the value of the
	   static count defined above (total number of dogs) at the time the dog is created, For example, the dog below was
	   created when
	   the static count had a value of 2 (Sequence #: 2)  <br>
	   <br><tt>Dog Fluffy, Breed = Poodle, #owners = 1, Registration #: 3496, Sequence #: 2</tt>  <br><br>
	5. A getter for the `seqNum` variable.
2. Add statements to the `main` method to do the following:
	1. Invoke the `printTotal` method at the start and end of the main method
3. Run the application. The following output should be produced: <br>
   <pre><code>Starting dog application
   Total number of dogs bred = 0
   Dog unknown, Breed = unknown, #owners = 0, Registration #: -1, Sequence #: 1
   Dog Fluffy, Breed = Poodle, #owners = 0, Registration #: 3496, Sequence #: 2
   Dog Fido, Breed = unknown, #owners = 2, Registration #: -1, Sequence #: 1
   Fido
   Fluffy
   Total number of dogs bred = 2
   </code></pre>

---

### Task 4

1. Create a new class called `DogRegister` that stores dogs. Provide the following methods:  <br>

   ```java
   public void addDog(Dog dog)     // Adds a dog to the register
   public Dog getDog(int regNum) // Returns the Dog with a registration number of  
   // regNum, if it exists, otherwise returns null.
   public String toString()        // The usual toString method.  
   public List<Dog> getRegister() // Returns the current dog register
   ```
2. Modify the main method so that it creates a `DogRegister` object, adds lots of dogs to it and demonstrates that your
   methods are correct. That is, add statements that call the methods and outputs the resulting changes, so you can
   check that the methods are behaving as they should.

3. Add the following method to the class `DogRegister`:
   ```java
     public Dog deleteDog(int regNum)
     // Removes, and returns, the Dog with a registration number of regNum
     // If there is no Dog with that registration number, null is returned.
     // Include thorough testing code in the main method.
   ```

   Note that your implementations of addDog and getDog should still function correctly after deleting a Dog.

4. Add the following method to the class `DogRegister`:
   ```java
    public Collection<Dog> getDogsWhoseNameContains(String charSequence)
    // Returns a Collection<Dog> containing all the Dogs whose name contains
    // charSequence.  Does not change the contents of the register.
   // Include thorough testing code in the main method.
   ```

---

### Task 5

1. Add the following method to the class `DogRegister`:
   ```java
    public void GroupByBreed()
    // Re-orders (sorts) the register so that all dogs with the same breed are
    // together (that is, in sequential indexes).
    //
    // Include thorough testing code in the main method.
   ```

2. Add the following method to the class `DogRegister`:
   ```java
    public Collection<Dog> getByCondition(DogCondition c)
   ```

   Returns a `Collection<Dog>` containing all the Dogs which satisfy the `DogCondition c`.   `DogCondition` is an
   **Interface** (**_that you need to create_**) that contains a single (abstract) method called `satisfies` that takes
   a
   `Dog` as a parameter and returns true or false (a `boolean`). The Dogs returned from `getByCondition` are those for
   which the method returns **true** when it is applied to them. You will also need to create a class that  
   **implements**  the `DogCondition` interface to test your method. For example

   ```java
     DogRegister dg = new DogRegister();
     //... add lots of dog
     DogCondition dc = new DogsNamedBarry(); // satisfies is true for dogs named Barry
     Collection<Dog> dogsNamedBarry = dg.getByCondition(dc);
   ```
   Include thorough testing code in your main method.

---

## Part 2

### Getting Started

This part of the practical will lead you through the creation of various classes to give you some insight into how
**Stacks** and **Queues** can be used to process data. The first part uses a `Stack` to solve the classic compiler
problem of parsing a string for the correct syntax of brackets. The second part uses a `Queue`, and a `PriorityQueue`
for ordering Wombats in a veterinary clinic.

<!--Note that checkpoints 16 - 18 can be done independently of checkpoints 19 - 20. That is, if you get stuck on 
checkpoint 18 you can move on checkpoint 19 as 19 does not build upon 18.-->

**It is important that you fully read the instructions before you start to code!**

### Task 1

The task of parsing a file for correctness is an essential part of any programmer toolkit. to check for a balanced set
of brackets in a file, a Stack can be used, and the following algorithm implemented:

- The source file is read character by character
- Each time an opening '{' is read it is pushed onto the stack
- Each time a closing '}' is read the stack is popped
- If the stack is empty when a closing '}' is read then there must be a missing '{'
- If the stack is not empty at the end of the file then there must be a missing closing '}'

Create the following class.

1. `BracketChecker` - this class contains:
	1. an instance variable `stack` of type `Stack<Character>` which is initialised it to new `Stack<>()`
	2. an instance variable to store the opening bracket types, an array of char's `char[] opening`
	3. an instance variable to store the closing bracket types, an array of char's `char[] closing`
	4. add a constructor that sets the values of `opening` and `closing`
	5. a single method `check` that takes a single formal parameter of type `String` and returns a `boolean`, i.e.
   ```java
     public boolean check(String text) {
        return false; 
     }
   ```
2. Modify the main method of `BracketTester` so that it:
	1. Prints the message "Starting Bracket Checker application"
	2. Declares a `char` array named `opening` that contains a single `char` -> '{', and a corresponding `char` array
	   named `closing` that contains a single `char` -> '}'
	3. Defines a variable called `checker` of type `BracketChecker`, initialised to a new `BracketChecker` object.
	4. Defines a variable called `in` of type `Scanner`, initialised to new `Scanner(
	   System.in)`. This will allow input from the keyboard.
	5. Calls `in.nextLine()` and passes the result to the `check` method of
	   `checker`
	6. Prints the result of the method call.
		1. if it is true then "Syntax Correct"
		2. if it is false then "Syntax Error"

   Run the project. The following output should be produced (example input, **{{}}** is shown <mark>highlighted</mark>
   below):

    <pre><code>Starting Bracket Checker application
    <mark>{{}}</mark>
    Syntax Error
     </code></pre>

   **NOTE:** this program will always print *Syntax Error* as the stub method `check` always returns `false`

3. Fully Implement the `check` method in `BracketChecker` so that it examines each character

   **Hint** use `.charAt(int index)` in the `String` passed as a parameter<br><br>
	1. if it is an opening '{', push it onto the stack, i.e. if the charAt(index) == opening[0]
	2. if it is a closing '}', i.e. if the charAt(index) == closing[0] , and,
		1. the stack is empty, then return false
		2. else pop the stack, .pop()
	3. any other character is ignored (not pushed onto the stack)
	4. when the end of the string is reached
		1. if the stack is empty, then return true
		2. if the stack is not empty, then return false<br><br>
4. Add a `while` loop to main method in `BracketTester.java` so that multiple lines can be entered for checking<br><br>
5. Add a print statement at the end stating `Exiting Checker`<br><br>
6. Run the application. The following output should be produced (example input is <mark>highlighted</mark>):

    <pre><code> Starting Bracket Checker application
    <mark>{{}}</mark>
    Syntax Correct
    <mark>{{}</mark>
    Syntax Error
    <mark>{"Hello{}World"}</mark>
    Syntax Correct<br>
    Exiting Checker
    </code></pre>

### Task 2

Most programs that process data will read from a file and not from the keyboard to check hundreds, thousands, or even
more lines. This checkpoint changes the main method to read from a file.

1. Change the constructor of the `Scanner` object in the `main` method to use the `File` version
   ```java
   String filePath = "brackets01.txt"; 
   Scanner in = new Scanner(new FileReader(filePath));
   ```
2. This should create an error in your code about not handling the `FileNotFoundException`. Add a `throws` clause to
   your `main` method definition.
3. If you execute this code now (go on, do it) you will most likely receive the following error:
   <pre><code>
   <span style="color:red">Exception in thread "main" java.io.FileNotFoundException: brackets01.txt (The system cannot find the file specified)</span>
   </code></pre>
   This means your program cannot find the `brackets01.txt` file. To fix this problem,
	1. You need to include the correct path to `brackets01.txt`.
	2. The file is contained in the "assets" folder of the project
	3. Type in the correct path for `brackets01.txt`<br>
	   **Hint:**
	   Go to the BracketTester Run configuration and check that the working directory is set to the `assets`
	   directory i.e. the Working directory path should be:
	   `<wherever you saved the project>\Practical02-AddSoftDev-DogRegister\BracketTester\assets`

	   Execute your program again. Your program should not throw the same exception. If it does ask your demonstrator
	   for assistance.<br><br>
4. Add a print statement in your main method to print each line that is about to be processed by the `check`
   method<br><br>
5. The last line in `brackets01.txt` is an empty line so your program should work in a similar way as it does to the
   keyboard input method. It should produce the following output in response to the input file:
   <pre><code>{}{} 
   Syntax Correct 
   {{}} 
   Syntax Correct 
   {}} 
   Syntax Error 
   {} Syntax Correct 
   Exiting Checker</code></pre>
   if it does not then modify your code to correct any issues. For example, you may need to modify your looping
   condition or how you check for the end of user input (end of file).<br><br>
6. Open the `brackets01.txt` file and add more lines for your `BracketChecker` to test your program further.

   **Hint:** Remember to keep at least one empty line as the last line in your file

A common way to process sequential data is to buffer it in a queue for subsequent processing. Also, it is good to know
that a syntax error occurred, but it would be more helpful to know where it occurred.

1. Add a queue declaration to your main method that contains objects of type `String`. You can choose which queue
   implementation to use (e.g. `ArrayDeque`, `LinkedList`)<br><br>
2. Read each line from the file and store it in the newly declared queue (using the `offer` method)<br><br>
3. Process each item in the queue using the `poll` method and calling the `check` method of your BracketChecker
   variable. You should now have two loops - one to read in and buffer the data, and another to process the data in the
   buffer. Your program should produce the same output at the previous checkpoint.

   **Hint:** You will need to change the condition in the original while loop to process the data in the buffer not the
   file as before.

To report where the error occurred your `BracketChecker` class will need to store the index of the character where the
error occurred so that it can be retrieved in the event of an error.

1. Add a private instance variable of type `int` in the `BracketChecker` class called `position`.<br><br>
2. Add a getter method for this new instance variable<br><br>
3. In the `check` method where you decided that an error has occurred (e.g. you return false) assign the current index
   into the string to the `position` instance variable.<br><br>
4. When a syntax error is found in the main method by a call to `check`, report the error and indicate the `position`.
   Call this code after printing the line, e.g.

   ```java
   ... 
   BracketChecker checker = new BracketChecker(); 
   boolean isCorrect = checker.check(line); 
   ...
   for (int i = 0; i < checker.getPosition(); i++) {
   System.out.print(" ");
   }
   System.out.println("|"); 
   System.out.println("Syntax Error at position " + checker.getPosition());
   ```
5. Run the application. The output below should be produced if the original `brackets01.txt`. Add more lines to the text
   file to test your program

<pre><code>Starting Bracket Checker application
    {}{}
    Syntax Correct
    {{}}
    Syntax Correct
    {}}
      |
    Syntax Error at position 2
    {}
    Syntax Correct
    Exiting Checker
</code></pre>

---

### Task 3

<span style="color: red">**Caution: Tricky!**</span>

To make the BracketChecker class more general we can check for more than just '{' and '}'

1. Modify the BracketChecker class to include the following
	1. add a private method to check if a character is an opening character, use the code below
	   ```java
		/**
		* Determine if the parameter 'in' is in the opening array and returns
		* the position if found.
		*
		* @param in the character to check
		* @return the position in the array if found, -1 otherwise
		*/
		  private int isOpening(char in) {
			for (int ci = 0; ci < opening.length; ci++) {
				if (in == opening[ci]) {
				return ci;
				}
			}
			return -1; // character not found
		  }
	   ```
	2. add a private method to check if a character is a closing character copy-and-paste/reuse the `
	   isOpening` code
	3. use the `isOpening` and `isClosing` methods in the check method to see if the current character is an opening or
	   closing bracket (e.g. `isOpening` returns a value > -1)
	4. to determine if there is a correct bracket sequence you need to check the top of stack (using `
	   .peek()`) to see if a current closing bracket matches the top of the stack. For example,
	   ```java
		 int cli = isClosing(line.charAt(c));
		 char top = s.peek();
		 if (top != opening[cli]) {
		 // ERROR, not matching brackets
		 }
	   ```
3. Add the following brackets to the `opening` and `closing` arrays.

    ```java
    char[] opening = {'{','(', '[', '<'};
    char[] closing = {'}',')', ']', '>'};
    ```
4. `brackets02.txt` is in the assets folder, so change the `filePath` and use this new file. Run the application.
   The below output should be produced.
    <pre><code>
    {}{} 
    Syntax Correct 
    {{()}} 
    Syntax Correct 
    {}} 
      | 
    Syntax Error at position 2 
    {} 
    Syntax Correct
    ({})
    Syntax Correct 
    {)
     | 
    Syntax Error at position 1 
    Exiting Checker
    </code></pre>
5. Add more bracket combinations and more lines to the file to test out your application. The file `brackets03.txt`,
   available in the assets folder, contains '{', '(', '<', and '[' combinations for `opening` and `closing`.

### Task 4

These last two tasks use the queue data structure to assist in ordering Wombat in a veterinary clinic. The first
processes Wombats in a traditional first come, first served basis (FIFO, in terms of programmatic insertion).

1. Create a new class called `Wombat`
	1. add an `String` instance variable `name` to store the name of the Wombat
	2. add an `int` instance variable `severity` to store the severity of the injuries for the Wombat (1 - least severe,
	   10 - most severe)
	3. add a `double` instance variable `time` to store the time of arrival (in fractional hours of the day) of the
	   Wombat
	4. add a constructor that sets all three instance variables, with the order of the formal parameters of name,
	   severity, and time.
	5. add getter and setters
	6. add an appropriate `toString` method with the format "`name, severity, time`"
2. Modify the main method in `WombatVetClinic` to include the following code
    ```java
    Queue<Wombat> wombatQueue = new ArrayDeque<Wombat>();
   
    wombatQueue.add(new Wombat("Fluffy",5,10.5));
    wombatQueue.add(new Wombat("Socks",10,11.3));
    wombatQueue.add(new Wombat("Barry",10,10.8));
    wombatQueue.add(new Wombat("Jobe",3,12.0));
    wombatQueue.add(new Wombat("Ginger",15,3.2));
   
    System.out.println(wombatQueue);
    ```
3. Use a loop to `poll` each Wombat from the queue and print their details. The output should be as follows:
    ```
    Fluffy, 5, 10.5
    Socks, 10, 11.3
    Barry, 10, 10.8
    Jobe, 3, 12.0
    Ginger, 15, 3.2
    ```

A veterinary clinic may want to process its current `Wombat` queue in the order of severity, i.e. more severe Wombats (
higher `severity` value) are processed first. A `PriorityQueue` can be used to automatically sort the queue based on the
priority of severity.

1. Change the implementation of the `wombatQueue` variable to be a `PriorityQueue`. Run you code. You should get an
   error in the output window similar to:

   <pre><code><span style="color: red">
   Exception in thread "main" java.lang.ClassCastException: practical03vets.Wombat cannot be cast to java.lang.Comparable
       at java.base/java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:642)
       at java.base/java.util.PriorityQueue.siftUp(PriorityQueue.java:638)
       at java.base/java.util.PriorityQueue.offer(PriorityQueue.java:329)
       at java.base/java.util.PriorityQueue.add(PriorityQueue.java:310)
       at WombatDriver.main(WombatDriver.java:11)
   Java Result: 1
   </span></code></pre>

   This error means that `Wombat` does not implement the `Comparable` interface

2. Make your Wombat class implement the `Comparable` interface, that is
   `public class Wombat implements Comparable<Wombat>`
   Implement all abstract methods. Implement the `compareTo` so that the `Wombat` with the highest `severity` is given
   the highest priority (polled from the queue first).
3. Your program should output something similar to below with the original set of Wombats. Add more Wombats to your
   Wombat queue to test out the ordering of the priority queue
    ```
    Ginger, 15, 3.2 
    Socks, 10, 11.3 
    Barry, 10, 10.8 
    Fluffy, 5, 10.5 
    Jobe, 3, 12.0
    ```
4. Wombats that have the same severity level are grouped together and are retrieved from the queue in any order
   (from the API: "ties are broken arbitrarily"). Wombats with the same `severity` should order so that the Wombat with
   the earliest `time` should have a higher priority. Modify the `compareTo` method to operate in this way. The output
   from the original set of Wombats should now be (note the order of Barry and Socks):
    ```
    Ginger, 15, 3.2
    Barry, 10, 10.8
    Socks, 10, 11.3
    Fluffy, 5, 10.5
    Jobe, 3, 12.0
    ```

### Task 5

1. Some Wombats, such as Ginger, may try to jump the queue by have a severity higher than the maximum of 10. To counter
   this, create a new exception that is raised when an out-of-bounds severity is detected.
	1. create a new class that extends the `Exception` class called `SeverityOutOfBoundsException`
	2. in the Wombat constructor check the that the value of `severity` is greater than 0 and less than 11, that is in
	   the range [1 10]
	3. if `severity` is out of bounds throw an instance of your newly created exception class and make the message
	   "Severity is not within 1-10"
	4. add the necessary `throws` clauses to your methods
	5. If you still have Ginger in your list of Wombats you should receive an exception similar to the following
	   <pre><code><span style="color: red;">
	   Exception in thread "main" SeverityOutOfBoundsException: Severity is not within 1-10 at Wombat.<init>(Wombat.java:12)
	   at WombatDriver.main(WombatDriver.java:15)<br>
	   Process finished with exit code 1
	   </span></code></pre>
2. To make the application more usable get Wombat data from the user via the keyboard.
	1. add a `Scanner` object to read from the keyboard (`System.in`)
	2. keep reading from the keyboard until the user enters `QUIT` (case independent)
	3. use another `Scanner` object to extract the `name`, `severity`, and
	   `time` from each line entered

	   **Hint:** use `.next()`, `.nextInt()`, and `.nextDouble()`

	4. if the users enters `PROCESS` (case independent) then the queue should be processed/emptied.
	5. add a `try-catch` your `main` method to catch the out-of-bounds exception. Print an informative message and
	   continue accepting user input. Example output is shown below. User Input in **bold**
    <pre><code> <b>Sweeps 4 10.3
    Fluffy 9 11.3
    Socks 9 10.3
    Ginger 15 4.5</b>
    Severity it not within 1-10
    <b>PROCESS</b>
    Socks, 9, 10.3
    Fluffy, 9, 11.3
    Sweeps, 4, 10.3
    <b>QUIT</b>
    </code></pre>