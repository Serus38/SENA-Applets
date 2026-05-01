import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AppletManager extends JFrame implements ActionListener {

    private JTextField txtX, txtY, txtResult;
    private JButton btnAdd, btnSubtract, btnMultiply, btnDivide, btnClear, sqRtX, sqRtY, yPowerX, xPowerY, xModY, yModX;

    // Constructor to set up the GUI
    public AppletManager() {
        setTitle("Applet Manager - Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Principal panel
        setLayout(new BorderLayout(10, 10));

        // Panel for (X, Y, Result)
        JPanel panelTop = new JPanel(new GridLayout(2, 3, 10, 5));
        panelTop.setPreferredSize(new Dimension(400, 120));

        txtX = new JTextField();
        txtY = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);
        txtResult.setBackground(Color.LIGHT_GRAY);

        panelTop.add(new JLabel("X:", SwingConstants.CENTER));
        panelTop.add(new JLabel("Y:", SwingConstants.CENTER));
        panelTop.add(new JLabel("=", SwingConstants.CENTER));

        panelTop.add(txtY);
        panelTop.add(txtX);
        panelTop.add(txtResult);

        // Panel for buttons
        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 10, 10));

        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnClear = new JButton("CE");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");
        sqRtX = new JButton("√X");
        sqRtY = new JButton("√Y");
        yPowerX = new JButton("Y^X");
        xPowerY = new JButton("X^Y");
        xModY = new JButton("X mod Y");
        yModX = new JButton("Y mod X");

        // Add action listeners
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnClear.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        sqRtX.addActionListener(this);
        sqRtY.addActionListener(this);
        yPowerX.addActionListener(this);
        xPowerY.addActionListener(this);
        xModY.addActionListener(this);
        yModX.addActionListener(this);

        // Add buttons to panel
        panelButtons.add(btnAdd);
        panelButtons.add(btnSubtract);
        panelButtons.add(btnClear);
        panelButtons.add(btnMultiply);
        panelButtons.add(btnDivide);
        panelButtons.add(sqRtX);
        panelButtons.add(sqRtY);
        panelButtons.add(yPowerX);
        panelButtons.add(xPowerY);
        panelButtons.add(xModY);
        panelButtons.add(yModX);

        // Add panels to frame
        add(panelTop, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);

        setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = txtX.getText().isEmpty() ? 0 : Double.parseDouble(txtX.getText());
            double y = txtY.getText().isEmpty() ? 0 : Double.parseDouble(txtY.getText());
            double result = 0;

            if (e.getSource() == btnAdd) {
                result = x + y;
            } else if (e.getSource() == btnSubtract) {
                result = x - y;
            } else if (e.getSource() == btnMultiply) {
                result = x * y;
            } else if (e.getSource() == btnDivide) {
                if (y != 0) {
                    result = x / y;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (e.getSource() == sqRtX) {
                result = Math.sqrt(x);
            } else if (e.getSource() == sqRtY) {
                result = Math.sqrt(y);
            } else if (e.getSource() == yPowerX) {
                result = Math.pow(y, x);
            } else if (e.getSource() == xPowerY) {
                result = Math.pow(x, y);
            } else if (e.getSource() == xModY) {
                result = x % y;
            } else if (e.getSource() == yModX) {
                result = y % x;
            } else if (e.getSource() == btnClear) {
                txtX.setText("");
                txtY.setText("");
                txtResult.setText("");
                return;
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for X and Y", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new AppletManager();
    }

}
