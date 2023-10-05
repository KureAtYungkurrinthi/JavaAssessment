import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
    private final String[] labels = {
            "MC", "MR", "M+", "M-", "MS",
            "%", "CE", "C", DELETE,
            RECIPROCAL, X_SQUARED, SQUARE_ROOT, DIVISION,
            "7", "8", "9", MULTIPLICATION,
            "4", "5", "6", SUBTRACTION,
            "1", "2", "3", ADDITION,
            CHANGE_SIGN, "0", DECIMAL, EQUALS
    };
    private final JButton[] buttons = new JButton[labels.length];
    private JPanel memoryPanel;
    private JPanel calcPanel;
    private double num1 = 0;
    private double num2 = 0;
    private String op = null;
    private boolean equalPressed = false;

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
            buttons[i] = new JButton(labels[i]);
            buttons[i].setPreferredSize(new Dimension(65, 40));
            buttons[i].setFont(new Font("Helvetica", Font.PLAIN, 13));
            buttons[i].setForeground(Color.darkGray);
            buttons[i].addActionListener(new ButtonListener());
            switch (labels[i]) {
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
            DecimalFormat df = new DecimalFormat("0.########");
            String resultText = result.getText();
            String buttonLabel = e.getActionCommand();
            switch (buttonLabel) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->
                        result.setText((resultText.equals("0") || equalPressed) ? buttonLabel : (resultText + buttonLabel));
                case DECIMAL -> {
                    if (!resultText.endsWith(DECIMAL)) {
                        result.setText(resultText + buttonLabel);
                    }
                }
                case CHANGE_SIGN ->
                        result.setText(resultText.startsWith("-") ? resultText.substring(1, resultText.length() + 1) : "-" + resultText);
                case "%" ->
                        result.setText(df.format(((op.equals(ADDITION) || op.equals(SUBTRACTION)) ? (num1 * Double.parseDouble(resultText)) : (Double.parseDouble(resultText))) / 100));
                case ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION -> {
                    num1 = Double.parseDouble(resultText);
                    op = buttonLabel;
                    calculation.setText(df.format(num1) + " " + op);
                    result.setText("0");
                }
                case SQUARE_ROOT, X_SQUARED, RECIPROCAL -> {
                    num1 = Double.parseDouble(resultText);
                    op = buttonLabel;
                    calculation.setText(switch (op) {
                        case SQUARE_ROOT -> "√(";
                        case X_SQUARED -> "sqr(";
                        case RECIPROCAL -> "1/(";
                        default -> "";
                    } + df.format(num1) + ")");
                    result.setText(df.format(calculate(op, num1)));
                }
                case EQUALS -> {
                    num2 = Double.parseDouble(resultText);
                    calculation.setText(calculation.getText() + " " + df.format(num2) + " " + EQUALS);
                    result.setText(df.format(calculate(op, num1, num2)));
                    equalPressed = true;
                }
                case DELETE ->
                        result.setText(resultText.length() == 1 ? "0" : resultText.substring(0, resultText.length() - 1));
                case "C", "CE" -> {
                    num1 = 0;
                    num2 = 0;
                    op = null;
                    calculation.setText("");
                    result.setText("0");
                }
            }
        }

        private double calculate(String op, double num1, double num2) {
            return switch (op) {
                case ADDITION -> num1 + num2;
                case SUBTRACTION -> num1 - num2;
                case MULTIPLICATION -> num1 * num2;
                case DIVISION -> num1 / num2;
                default -> 0;
            };
        }

        private double calculate(String op, double num1) {
            return switch (op) {
                case SQUARE_ROOT -> Math.sqrt(num1);
                case X_SQUARED -> num1 * num1;
                case RECIPROCAL -> 1 / num1;
                default -> 0;
            };
        }
    }

}