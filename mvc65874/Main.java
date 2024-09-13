package mvc65874;

import mvc65874.view.view;
import mvc65874.controller.controller;
import mvc65874.model.model;

public class Main {
    public static void main(String[] args) {
        // Create the model, view, and controller
        model model = new model();
        view view = new view();
        new controller(model, view);

        // Show the GUI
        view.setVisible(true);
    }
}