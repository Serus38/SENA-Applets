package Applets2;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class AppletDeslizador extends JFrame {

    private JSlider sld1, sld2, sld3;
    private DrawingPanel areaDibujo;

    public AppletDeslizador() {
        setTitle("AppletDeslizador");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- PANEL SUPERIOR ---
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelSuperior.setBackground(new Color(236, 233, 216)); 

        sld1 = crearDeslizador();
        sld2 = crearDeslizador();
        sld3 = crearDeslizador();

        panelSuperior.add(sld1);
        panelSuperior.add(sld2);
        panelSuperior.add(sld3);

        // --- ÁREA DE DIBUJO ---
        areaDibujo = new DrawingPanel();

        // Listeners 
        ChangeListener listener = e -> areaDibujo.repaint();
        sld1.addChangeListener(listener);
        sld2.addChangeListener(listener);
        sld3.addChangeListener(listener);

        add(panelSuperior, BorderLayout.NORTH);
        add(areaDibujo, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JSlider crearDeslizador() {
        JSlider slid = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
        slid.setPreferredSize(new Dimension(80, 30));
        return slid;
    }

    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int v1 = sld1.getValue();
            int v2 = sld2.getValue();
            int v3 = sld3.getValue();

            
            g.setColor(new Color(v1, v2, v3));
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.PLAIN, 14));

            int centroX = getWidth() / 2 - 50;
            g.drawString("deslizador 1 =" + v1, centroX, 80);
            g.drawString("deslizador 2 =" + v2, centroX, 200);
            g.drawString("deslizador 3 =" + v3, centroX, 320);
        }
    }

    public static void main(String[] args) {
        new AppletDeslizador();
    }
}