import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

public class ColorsInterface extends JFrame {
    private JList<String> colorList;
    private JPanel colorPanel;
    private Color selectedColor = Color.WHITE;

    // Define color names and their corresponding Color objects
    private String[] colors = { "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta" };
    private Color[] colorValues = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA };

    // Constructor to set up the GUI
    public ColorsInterface() {
        setTitle("Applet Colors Interface");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        colorList = new JList<>(colors);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add a listener to update the color panel when a color is selected
        colorList.addListSelectionListener(e -> {
            int index = colorList.getSelectedIndex();
            if (index != -1) {
                selectedColor = colorValues[index];
                colorPanel.setBackground(selectedColor);
            }
        });

        // Create a custom JPanel to display the selected color
        colorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(selectedColor);
                g.fillRect(50, 50, 300, 300);
            }
        };

        // Create a simple JPanel to display the selected color
        colorPanel = new JPanel();
        colorPanel.setBackground(selectedColor);

        add(new JScrollPane(colorList), BorderLayout.WEST);
        add(colorPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorsInterface ci = new ColorsInterface();
            ci.setVisible(true);
        });
    }
}
