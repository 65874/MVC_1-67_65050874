package mvc65874.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class viewWhiteCow extends JFrame {
    private JButton milkingButton = new JButton("Milking");
    private JButton addLimeButton = new JButton("Add Lime");
    private JTextArea resultArea = new JTextArea(5, 20);

    public viewWhiteCow() {
        // Set up the GUI layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create and add components to the panel
        panel.add(milkingButton);
        panel.add(addLimeButton);
        panel.add(new JLabel("Result:"));
        panel.add(resultArea);

        // Set up the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.add(panel);
    }

    // Display the cowdata in the result area
    public void displayWhCow(String[] cowData) {
        if (cowData != null) {
            // Format the cow's data for display
            String cowInfo = "Cow Code: " + cowData[0] + "\n" +
                    "Color: " + cowData[1] + "\n" +
                    "Age: " + cowData[2] + " years, " + cowData[3] + " months" + "\n" +
                    "Milking Time: " + cowData[4];
            resultArea.setText(cowInfo); // Display the cow's information in the result area
        }
    }

    public void displayWhCowMilking(String[] cowData, String info) {
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
    public void addWhMilkingButtonListener(ActionListener listener) {
        milkingButton.addActionListener(listener);
    }

    public void addLimeButtonListener(ActionListener listener) {
        addLimeButton.addActionListener(listener);
        System.out.println("addlime");
    }
}
