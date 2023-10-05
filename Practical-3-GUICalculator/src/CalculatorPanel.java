import javax.swing.*;
import java.awt.*;

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
    }
}