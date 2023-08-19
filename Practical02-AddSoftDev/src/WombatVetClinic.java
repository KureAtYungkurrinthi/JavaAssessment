import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class WombatVetClinic {
    public static void main(String[] args) {
        Queue<Wombat> wombatQueue = new PriorityQueue<Wombat>();
        Scanner in = new Scanner(System.in);
        boolean notQuit = true;
        while (notQuit) {
            String input = in.nextLine().trim();
            if (input.equalsIgnoreCase("QUIT"))
                notQuit = false;
            else if (input.equalsIgnoreCase("PROCESS"))
                while (wombatQueue.peek() != null)
                    System.out.println(wombatQueue.poll());
            else {
                try {
                    Scanner line = new Scanner(input);
                    wombatQueue.add(new Wombat(line.next(), line.nextInt(), line.nextDouble()));
                } catch (SeverityOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
