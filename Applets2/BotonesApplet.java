package Applets2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BotonesApplet extends JFrame implements ActionListener {

    private JTextField txt1, txt2, txtResult;
    private JButton btnAdd, btnSubtract, btnMultiply, btnDivide, btnClear, sqRt1, sqRt2, major, minor;

    public BotonesApplet() {
        setTitle("Calculadora Swing - Extender Resultado");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        JPanel panelTop = new JPanel(new GridLayout(2, 2, 10, 5));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txt1 = new JTextField();
        txt2 = new JTextField();
        txt1.setFont(new Font("Arial", Font.BOLD, 20));
        txt2.setFont(new Font("Arial", Font.BOLD, 20));

        panelTop.add(new JLabel("Número 1:", SwingConstants.CENTER));
        panelTop.add(new JLabel("Número 2:", SwingConstants.CENTER));
        panelTop.add(txt1);
        panelTop.add(txt2);

        JPanel panelCentralContenedor = new JPanel(new BorderLayout(10, 10));
        panelCentralContenedor.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Sub-panel para los botones
        JPanel panelButtonsGrid = new JPanel(new GridLayout(3, 3, 10, 10));

        btnAdd = new JButton("Sumar");
        btnSubtract = new JButton("Restar");
        btnMultiply = new JButton("Multiplicar");
        btnDivide = new JButton("Dividir");
        sqRt1 = new JButton("Raiz de 1");
        sqRt2 = new JButton("Raiz de 2");
        major = new JButton("Mayor");
        minor = new JButton("Menor");
        btnClear = new JButton("Limpiar");

        // Listeners
        JButton[] botones = {btnAdd, btnSubtract, btnMultiply, btnDivide, sqRt1, sqRt2, major, minor, btnClear};
        for (JButton btn : botones) {
            btn.addActionListener(this);
            panelButtonsGrid.add(btn);
        }

        JPanel panelResultadoFila = new JPanel(new BorderLayout(10, 10));
        JLabel lblRes = new JLabel("Resultado: ");
        lblRes.setFont(new Font("Arial", Font.BOLD, 14));
        
        txtResult = new JTextField();
        txtResult.setEditable(false);
        txtResult.setBackground(Color.LIGHT_GRAY);
        txtResult.setFont(new Font("Arial", Font.BOLD, 20));
        txtResult.setHorizontalAlignment(JTextField.LEFT);

        panelResultadoFila.add(lblRes, BorderLayout.WEST);
        panelResultadoFila.add(txtResult, BorderLayout.CENTER); 

        panelCentralContenedor.add(panelButtonsGrid, BorderLayout.CENTER);
        panelCentralContenedor.add(panelResultadoFila, BorderLayout.SOUTH);

        add(panelTop, BorderLayout.NORTH);
        add(panelCentralContenedor, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnClear) {
                txt1.setText("");
                txt2.setText("");
                txtResult.setText("");
                return;
            }

            double num1 = Double.parseDouble(txt1.getText());
            double num2 = 0;
            
            if (!txt2.getText().isEmpty()) {
                num2 = Double.parseDouble(txt2.getText());
            }

            double result = 0;

            if (e.getSource() == btnAdd) {
                result = num1 + num2;
            } else if (e.getSource() == btnSubtract) {
                result = num1 - num2;
            } else if (e.getSource() == btnMultiply) {
                result = num1 * num2;
            } else if (e.getSource() == btnDivide) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (e.getSource() == sqRt1) {
                result = Math.sqrt(num1);
            } else if (e.getSource() == sqRt2) {
                result = Math.sqrt(num2);
            } else if (e.getSource() == major) {
                result = Math.max(num1, num2);
            } else if (e.getSource() == minor) {
                result = Math.min(num1, num2);
            }

            txtResult.setText(String.valueOf(result));
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BotonesApplet();
    }
}