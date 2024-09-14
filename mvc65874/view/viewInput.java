package mvc65874.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class viewInput extends JFrame {
    private JTextField cowCodeField = new JTextField(20);

    private JButton submitButton = new JButton("Submit");
    private JButton resetButton = new JButton("Reset");
    private JTextArea resultArea = new JTextArea(5, 20);

    public viewInput() {
        // Set up the GUI layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create and add components to the panel
        panel.add(new JLabel("Cow Codw:"));
        panel.add(cowCodeField);

        panel.add(submitButton);
        panel.add(resetButton);
        panel.add(new JLabel("Result:"));
        panel.add(resultArea);

        // Set up the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.add(panel);

    }

    public int getCowCode() {
        String input = cowCodeField.getText().trim();
        if (input.matches("\\d{8}") && input.charAt(0) != '0') {
            try {
                return Integer.parseInt(input); // Return parsed number if valid
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid 8-digit number.");
                return 0; // Return 0 if the input cannot be parsed
            }
        } else {
            // Show error message if the input is not a valid 8-digit number
            if (input.length() != 8) {
                JOptionPane.showMessageDialog(null, "Error: The cow code must be exactly 8 digits long.");
            } else if (input.charAt(0) == '0') {
                JOptionPane.showMessageDialog(null, "Error: The cow code cannot start with 0.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid 8-digit number.");
            }
            return 0;
        }
    }

    // Display the cowdata in the result area
    public void displayCow(int score) {
        resultArea.setText("");
    }

    // Add action listener to the submit button
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
        System.out.println("click");
    }
}