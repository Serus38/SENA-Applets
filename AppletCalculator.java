import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AppletCalculator extends JFrame implements ActionListener {
    private JTextField screen;
    private double firstOperand = 0;
    private String operator = "";
    private boolean isNewInput = true;

    public AppletCalculator() {
        setTitle("Applet Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));


        // Create the display screen (It's not editable and right-aligned)
        screen = new JTextField("0");
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setFont(new Font("Arial", Font.BOLD, 40));
        add(screen, BorderLayout.NORTH);

        // Create the button panel with a grid layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "C", "", "", "←",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            ".", "0", "/", "="
        };

        for (String text : buttons) {
            if (text.isEmpty()) {
                buttonPanel.add(new JLabel(""));
            } else {
                JButton button = new JButton(text);
                button.addActionListener(this);
                buttonPanel.add(button);
            }
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle clear and backspace operations
        if (Character.isDigit(command.charAt(0))){
            if (isNewInput || screen.getText().equals("0")) {
                screen.setText(command);
                isNewInput = false;
            } else {
                screen.setText(screen.getText() + command);
            }
        }

        // Handle operator buttons
        else if (command.equals(".")){
            if (!screen.getText().contains(".")) {
                screen.setText(screen.getText() + ".");
                isNewInput = false;
            }
        }
        else if (command.equals("←")) {
            String currentText = screen.getText();
            if (currentText.length() > 1) {
                screen.setText(currentText.substring(0, currentText.length() - 1));
            } else {
                screen.setText("0");
                isNewInput = true;
            }
        }
        else if (command.equals("C")) {
            screen.setText("0");
            firstOperand = 0;
            operator = "";
            isNewInput = true;
        
        } else if (command.equals("CE")) {
            screen.setText("0");
            isNewInput = true;
        }
        else if (command.equals("=")){
            calculate(Double.parseDouble(screen.getText()));
            operator = "";
            isNewInput = true;
        }
        else {
            firstOperand = Double.parseDouble(screen.getText());
            operator = command;
            isNewInput = true;
        }
    }

    private void calculate(double secondOperand) {
        switch (operator) {
            case "+":
                screen.setText(String.valueOf(firstOperand + secondOperand));
                break;
            case "-":
                screen.setText(String.valueOf(firstOperand - secondOperand));
                break;
            case "×":
                screen.setText(String.valueOf(firstOperand * secondOperand));
                break;
            case "÷":
                if (secondOperand != 0) {
                    screen.setText(String.valueOf(firstOperand / secondOperand));
                } else {
                    screen.setText("Error");
                }
                break;
        }
        screen.setText(screen.getText().replaceAll("\\.0$", "")); // Remove trailing .0 for integers
    }
    

    public static void main(String[] args) {
        new AppletCalculator();
    }

    
}
