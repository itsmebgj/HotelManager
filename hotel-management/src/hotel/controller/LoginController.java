package hotel.controller;

import hotel.Login;
import hotel.database.DBConnection;
import hotel.view.MenuSelectView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    private final Login login;
    private final JFrame frame;

    public LoginController(Login login) {
        this.login = login;
        this.frame = login.frame;
    }

    public void handleLogin() {
        Connection conn = DBConnection.getInstance();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username= ? AND password=? ");
            ps.setString(1, login.userId.getText());
            ps.setString(2, String.valueOf(login.userPassword.getPassword()));

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                MenuSelectView menuSelectView = new MenuSelectView();
                MenuSelectController menuSelectController = new MenuSelectController(menuSelectView);
                menuSelectView.setVisible(true);
                menuSelectView.pack();
                menuSelectView.setLocationRelativeTo(null);
                menuSelectView.setBounds(50, 50, 1015, 574);

                frame.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Error", "Please check user name / password", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException p) {
            p.printStackTrace();
        }
    }
}
