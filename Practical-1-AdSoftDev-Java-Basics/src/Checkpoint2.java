import java.util.ArrayList;
import java.util.Scanner;

public class Checkpoint2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Line> lineStore = new ArrayList<>();
        boolean hasNextLine = true;
        int counter = 1;

        while (hasNextLine) {
            System.out.println(counter + ": Enter a line");
            String text = in.nextLine();
            if (text.equals("STOP"))
                hasNextLine = false;
            else {
                Line msg = new Line();
                msg.setText(text);
                msg.setSeqNum(counter++);
                lineStore.add(msg);
            }
        }

        for (int i = 1; i <= lineStore.size(); i++) {
            System.out.println(lineStore.get(lineStore.size() - i));
        }
    }
}
