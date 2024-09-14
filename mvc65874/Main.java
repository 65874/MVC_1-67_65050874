package mvc65874;

import mvc65874.view.*;
import mvc65874.controller.controller;
import mvc65874.model.*;

public class Main {
    public static void main(String[] args) {
        // Create the model, view, and controller
        model model = new model();
        modelWhite modelWh = new modelWhite(model);
        modelBrown modelBr = new modelBrown();

        viewInput view = new viewInput();
        viewWhiteCow viewWh = new viewWhiteCow();
        viewBrownCow viewBr = new viewBrownCow();
        new controller(model, modelWh, modelBr, view, viewBr, viewWh);

        // Show the GUI
        view.setVisible(true);
        // viewWh.setVisible(true);
        // viewBr.setVisible(true);
    }
}