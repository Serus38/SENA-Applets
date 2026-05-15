package Applets3.AppletsMetodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppletMetodos extends JFrame implements ActionListener {

    JLabel lblNumber, lblName, lblBalance, lblRes;
    JTextField txtNumber, txtName, txtBalance;
    JButton btnCrear;
    JTextArea areaRes;

    public AppletMetodos() {

        setTitle("Cuenta Bancaria");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblNumber = new JLabel("Número:");
        lblNumber.setBounds(20, 40, 200, 20);
        txtNumber = new JTextField();
        txtNumber.setBounds(20, 60, 400, 25);


        lblName = new JLabel("Nombre:");
        lblName.setBounds(20, 90, 200, 20);
        txtName = new JTextField();
        txtName.setBounds(20, 110, 400, 25);

        lblBalance = new JLabel("Saldo:");
        lblBalance.setBounds(20, 140, 200, 20);
        txtBalance = new JTextField();
        txtBalance.setBounds(20, 160, 400, 25);

        btnCrear = new JButton("Crear Cuenta");
        btnCrear.setBounds(20, 200, 150, 30);
        btnCrear.addActionListener(this);

        lblRes = new JLabel("Resultado:");
        lblRes.setBounds(20, 240, 200, 20);

        areaRes = new JTextArea();
        areaRes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(areaRes);
        scrollPane.setBounds(20, 260, 400, 200);


        add(lblNumber);
        add(txtNumber);

        add(lblName);
        add(txtName);

        add(lblBalance);
        add(txtBalance);

        add(btnCrear);
        add(lblRes);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String number = txtNumber.getText().trim();
        String name = txtName.getText().trim();
        String balanceText = txtBalance.getText().trim();

        if (!number.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Número solo debe tener dígitos");
            return;
        }

        if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, "Nombre solo debe tener letras");
            return;
        }

        if (!balanceText.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "Saldo solo números");
            return;
        }

        double balance = Double.parseDouble(balanceText);

        Account account = new Account(number, name, balance);

        areaRes.setText(account.showAccountInfo());
    }

    public static void main(String[] args) {
        new AppletMetodos();
    }
}