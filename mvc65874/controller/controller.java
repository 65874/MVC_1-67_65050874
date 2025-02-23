package mvc65874.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc65874.model.*;
import mvc65874.view.*;

public class controller {
    private model model;
    private modelWhite modelWh;
    private modelBrown modelBr;
    private viewInput view;
    private viewWhiteCow viewWh;
    private viewBrownCow viewBr;
    private String[] cowData;

    public controller(model model, modelWhite modelWh, modelBrown modelBr, viewInput view, viewBrownCow viewBr,
            viewWhiteCow viewWh) {
        this.model = model;
        this.modelWh = modelWh;
        this.modelBr = modelBr;
        this.view = view;
        this.viewBr = viewBr;
        this.viewWh = viewWh;
        this.view.addSubmitButtonListener(new SubmitButtonListener());
        this.viewWh.addWhMilkingButtonListener(new WhMilkingButtonListener());
        this.viewWh.addLimeButtonListener(new LimeButtonListener());
        this.viewBr.addBrMilkingButtonListener(new BrMilkingButtonListener());
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get cow code from the viewInput
            int cowCode = view.getCowCode();
            cowData = model.getCowByCode(cowCode);
            System.out.println(cowData[0]);
            if (cowData[1].equals("White")) {
                view.setVisible(false);
                viewWh.setVisible(true);
                viewBr.setVisible(false);
                viewWh.displayWhCow(cowData);
            } else {
                view.setVisible(false);
                viewWh.setVisible(false);
                viewBr.setVisible(true);
                viewBr.displayBrCow(cowData);
            }

        }
    }

    private class WhMilkingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get cow code from the viewInput
            view.setVisible(false);
            viewBr.setVisible(false);
            viewWh.setVisible(true);
            viewWh.displayWhCowMilking(cowData, modelWh.milking(cowData));

        }
    }

    private class LimeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get cow code from the viewInput
            modelWh.addlemon();
            view.setVisible(false);
            viewBr.setVisible(false);
            viewWh.setVisible(true);
            viewWh.displayWhCowMilking(cowData, "add lemon");

        }
    }

    private class BrMilkingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get cow code from the viewInput
            viewBr.displayBrCowMilking(cowData, modelBr.milking(cowData));
            view.setVisible(false);
            viewWh.setVisible(false);
            viewBr.setVisible(true);

        }
    }
}