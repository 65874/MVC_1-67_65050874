package mvc65874.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class viewBrownCow extends JFrame {
    private JButton milkingButton = new JButton("Milking");
    private JTextArea resultArea = new JTextArea(5, 20);

    public viewBrownCow() {
        // Set up the GUI layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create and add components to the panel
        panel.add(milkingButton);
        panel.add(resultArea);

        // Set up the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.add(panel);
    }

    public void displayBrCow(String[] cowData) {
        if (cowData != null) {
            // Format the cow's data for display
            String cowInfo = "Cow Code: " + cowData[0] + "\n" +
                    "Color: " + cowData[1] + "\n" +
                    "Age: " + cowData[2] + " years, " + cowData[3] + " months" +
                    "Milking Time: " + cowData[4];
            resultArea.setText(cowInfo); // Display the cow's information in the result area
        }
    }

    public void displayBrCowMilking(String[] cowData, String info) {
        if (cowData != null) {
            // Format the cow's data for display
            String cowInfo = info + "\n" +
                    "Cow Code: " + cowData[0] + "\n" +
                    "Color: " + cowData[1] + "\n" +
                    "Age: " + cowData[2] + " years, " + cowData[3] + " months" + "\n" +
                    "Milking Time: " + cowData[4];
            resultArea.setText(cowInfo); // Display the cow's information in the result area
        }
    }

    // Add action listener to the button
    public void addBrMilkingButtonListener(ActionListener listener) {
        milkingButton.addActionListener(listener);
    }

}
