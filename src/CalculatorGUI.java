import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

/**
 * This is a demonstration of using stacks to do
 * large number (larger than long) addition and
 * subtraction. This program uses BigInteger only to
 * do input validation.
 *
 * @author Lauren Rose
 * @version 7March19
 *
 * Radford University
 * Department of Information Technology
 */
class CalculatorGUI {

    private final JTextField number1;
    private final JTextField number2;
    private final JLabel result;


    private final CalculatorController controller;

    CalculatorGUI(CalculatorController cont) {
        controller = cont;
        Dimension WINDOW_SIZE = new Dimension(300, 300);
        JFrame frame = new JFrame("Big Integer Calculator");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(WINDOW_SIZE);
        panel.setMinimumSize(WINDOW_SIZE);
        number1 = new JTextField();
        number2 = new JTextField();
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton plus = new JButton("add");
        JButton minus = new JButton("subtract");
        result = new JLabel("Enter a calculation");

        plus.addActionListener(e -> plusClicked());
        minus.addActionListener(e -> minusClicked());

        panel.add(number1);
        panel.add(number2);
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        panel.add(buttonPanel);
        panel.add(result);

        frame.add(panel);
        frame.setPreferredSize(WINDOW_SIZE);
        frame.setMinimumSize(WINDOW_SIZE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void plusClicked() {
        String num1 = number1.getText();
        String num2 = number2.getText();
        try {
            new BigInteger(num1);
            new BigInteger(num2);
            controller.doAddition(num1, num2);
            result.setText(controller.getResult());
        } catch (NumberFormatException e) {
            result.setText("Please enter integers only");
            number1.setText("");
            number2.setText("");
        }
    }

    private void minusClicked() {
        String num1 = number1.getText();
        String num2 = number2.getText();
        try {
            new BigInteger(num1);
            new BigInteger(num2);
            controller.doSubtraction(num1, num2);
            result.setText(controller.getResult());
        } catch (NumberFormatException e) {
            result.setText("Please enter integers only");
            number1.setText("");
            number2.setText("");
        }
    }
}
