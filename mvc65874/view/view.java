package mvc65874.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class view extends JFrame {
    private JTextField songNameField = new JTextField(20);
    private JTextField durationField = new JTextField(10);
    private JTextField singer1Field = new JTextField(15);
    private JTextField singer2Field = new JTextField(15);
    private JTextField singer3Field = new JTextField(15);
    private JButton submitButton = new JButton("Submit");
    private JTextArea resultArea = new JTextArea(5, 20);

    public view() {
        // Set up the GUI layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create and add components to the panel
        panel.add(new JLabel("Song Name:"));
        panel.add(songNameField);

        panel.add(new JLabel("Duration (seconds):"));
        panel.add(durationField);

        panel.add(new JLabel("Singer 1:"));
        panel.add(singer1Field);

        panel.add(new JLabel("Singer 2 (optional):"));
        panel.add(singer2Field);

        panel.add(new JLabel("Singer 3 (optional):"));
        panel.add(singer3Field);

        panel.add(submitButton);
        panel.add(new JLabel("Result:"));
        panel.add(resultArea);

        // Set up the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.add(panel);

    }

    public String getSongName() {
        return songNameField.getText();
    }

    public int getDuration() {
        try {
            return Integer.parseInt(durationField.getText());
        } catch (NumberFormatException e) {
            return 0; // Return 0 if the input is invalid
        }
    }

    public String[] getSingers() {
        String singer1 = singer1Field.getText().trim();
        String singer2 = singer2Field.getText().trim();
        String singer3 = singer3Field.getText().trim();

        if (!singer2.isEmpty() && !singer3.isEmpty()) {
            return new String[] { singer1, singer2, singer3 };
        } else if (!singer2.isEmpty()) {
            return new String[] { singer1, singer2 };
        } else {
            return new String[] { singer1 };
        }
    }

    // Display the score in the result area
    public void displayScore(int score) {
        resultArea.setText("Calculated Song Score: " + score);
    }

    // Add action listener to the submit button
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
        System.out.println("click");
    }
}