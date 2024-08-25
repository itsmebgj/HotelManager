package hotel.controller;

import hotel.view.*;
import hotel.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSelectController {

    private final MenuSelectView view;

    public MenuSelectController(MenuSelectView view) {
        this.view = view;
        initialize();
    }

    private void initialize() {
        view.getBtnInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDisplayInfo();
            }
        });

        view.getBtnCheckInOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCheckInOutPage();
            }
        });

        view.getBtnAdmin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAdminPage();
            }
        });
    }

    private void openDisplayInfo() {
        DisplayInfo displayInfo = new DisplayInfo();
        displayInfo.setVisible(true);
        displayInfo.pack();
        displayInfo.setLocationRelativeTo(null);
        displayInfo.setBounds(100, 100, 800, 500);
    }

    private void openCheckInOutPage() {
        CheckInOutPage checkInOutPage = new CheckInOutPage();
        checkInOutPage.setVisible(true);
        checkInOutPage.pack();
        checkInOutPage.setLocationRelativeTo(null);
        checkInOutPage.setBounds(100, 100, 1200, 800);
        view.setVisible(false);
    }

    private void openAdminPage() {
        AdminPage adminPage = new AdminPage();
        adminPage.setVisible(true);
        adminPage.pack();
        adminPage.setLocationRelativeTo(null);
        adminPage.setBounds(100, 100, 1038, 623);
        view.setVisible(false);
    }

}