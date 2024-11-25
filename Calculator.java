import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    // Components of the calculator
    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, clrButton, delButton;
    private JPanel panel;

    // Variables for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize the display
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        add(display);

        // Initialize the buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].setFocusable(false);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("Del");

        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton, equButton, clrButton, delButton};

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setFocusable(false);
        }

        // Set up the panel for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add panel and clear/delete buttons to the frame
        add(panel);
        clrButton.setBounds(50, 420, 145, 40);
        delButton.setBounds(205, 420, 145, 40);
        add(clrButton);
        add(delButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle number and decimal button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }

        // Handle operator button clicks
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        // Handle the equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num2 != 0 ? num1 / num2 : 0; // Avoid division by zero
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }

        // Handle clear button
        if (e.getSource() == clrButton) {
            display.setText("");
        }

        // Handle delete button
        if (e.getSource() == delButton) {
            String currentText = display.getText();
            display.setText(currentText.length() > 0 ? currentText.substring(0, currentText.length() - 1) : "");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
