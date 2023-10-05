import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The calculator panel
 *
 * @author Wang Shengfan
 */
public class CalculatorPanel extends JPanel implements ButtonConstants {
    private static final int CALC_WIDTH = 265;
    private static final int CALC_HEIGHT = 375;
    private JLabel calculation;
    private JLabel result;
    private final String[] texts = {
            "MC", "MR", "M+", "M-", "MS",
            "%", "CE", "C", DELETE,
            RECIPROCAL, X_SQUARED, SQUARE_ROOT, DIVISION,
            "7", "8", "9", MULTIPLICATION,
            "4", "5", "6", SUBTRACTION,
            "1", "2", "3", ADDITION,
            CHANGE_SIGN, "0", DECIMAL, EQUALS
    };
    private final JButton[] buttons = new JButton[texts.length];
    private JPanel memoryPanel;
    private JPanel calcPanel;

    /**
     * Constructor for the Calculator Panel: Sets up the GUI
     */
    public CalculatorPanel() {
        init();
    }

    private void init() {
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(CALC_WIDTH, CALC_HEIGHT));

        calculation = new JLabel("", JLabel.RIGHT);
        calculation.setBackground(Color.lightGray);
        calculation.setFont(new Font("Helvetica", Font.PLAIN, 12));
        calculation.setPreferredSize(new Dimension(CALC_WIDTH - 5, 20));
        add(calculation);

        result = new JLabel("0", JLabel.RIGHT);
        result.setPreferredSize(new Dimension(CALC_WIDTH - 5, 50));
        result.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        result.setFont(new Font("Arial", Font.BOLD, 32));
        result.setBackground(Color.white);
        result.setOpaque(true);
        add(result);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(texts[i]);
            buttons[i].setPreferredSize(new Dimension(65, 40));
            buttons[i].setFont(new Font("Helvetica", Font.PLAIN, 13));
            buttons[i].setForeground(Color.darkGray);
            buttons[i].addActionListener(new ButtonListener());
            switch (texts[i]) {
                case "CE", "C" -> buttons[i].setForeground(Color.red);
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->
                        buttons[i].setFont(new Font("Helvetica", Font.BOLD, 13));
                case EQUALS -> buttons[i].setBackground(Color.green);
            }
        }

        memoryPanel = new JPanel();
        memoryPanel.setBackground(Color.lightGray);
        memoryPanel.setLayout(new GridLayout(1, 1, 1, 1));
        for (int i = 0; i < 5; i++) {
            buttons[i].setPreferredSize(new Dimension(48, 30));
            buttons[i].setFont(new Font("Helvetica", Font.PLAIN, 12));
            memoryPanel.add(buttons[i]);
        }
        add(memoryPanel);

        calcPanel = new JPanel();
        calcPanel.setBackground(Color.lightGray);
        calcPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        calcPanel.setLayout(new GridLayout(7, 4, 1, 1));
        for (int i = 5; i < buttons.length; i++)
            calcPanel.add(buttons[i]);
        add(calcPanel);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // an empty body, you will complete it later.
        }
    }

}