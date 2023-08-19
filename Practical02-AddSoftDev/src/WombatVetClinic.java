import java.util.PriorityQueue;
import java.util.Queue;

public class WombatVetClinic {
    public static void main(String[] args) throws SeverityOutOfBoundsException {
        Queue<Wombat> wombatQueue = new PriorityQueue<Wombat>();

        wombatQueue.offer(new Wombat("Socks", 10, 11.3));
        wombatQueue.offer(new Wombat("Barry", 10, 10.8));
        wombatQueue.offer(new Wombat("Jobe", 3, 12.0));
        wombatQueue.offer(new Wombat("Ginger", 15, 3.2));

        while (wombatQueue.peek() != null)
            System.out.println(wombatQueue.poll());
    }
}
