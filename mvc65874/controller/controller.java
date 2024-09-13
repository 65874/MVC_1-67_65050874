package mvc65874.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc65874.model.model;
import mvc65874.view.view;

public class controller {
    private model model;
    private view view;

    public controller(model model, view view) {
        this.model = model;
        this.view = view;

        this.view.addSubmitButtonListener(new SubmitButtonListener());
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get song details from the view
            String songName = view.getSongName();
            int duration = view.getDuration();
            String[] singers = view.getSingers();

            // Calculate the score
            int score = model.calculateScore(singers, duration);

            // Add the song and score to the model (data store)
            model.addSong(songName, duration, singers, score);

            // Display the score to the user
            view.displayScore(score);
        }
    }
}