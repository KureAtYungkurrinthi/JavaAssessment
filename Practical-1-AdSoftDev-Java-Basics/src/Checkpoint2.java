import java.util.Scanner;

public class Checkpoint2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String msg1, msg2, msg3;
        int counter = 0;

        counter++;
        System.out.println(counter + ": Enter a line");
        msg1 = in.nextLine();

        counter++;
        System.out.println(counter + ": Enter another line");
        msg2 = in.nextLine();

        counter++;
        System.out.println(counter + ": Enter the last line");
        msg3 = in.nextLine();

        System.out.println(msg3 + ", " + msg2 + ", " + msg1);
    }
}
