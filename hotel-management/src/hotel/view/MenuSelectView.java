package hotel.view;

import hotel.controller.MenuSelectController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuSelectView extends JFrame {

    private final JPanel contentPane;
    private final JButton btnInfo;
    private final JButton btnCheckInOut;
    private final JButton btnAdmin;

    public MenuSelectView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1015, 574);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnInfo = new JButton("INFO");
        btnInfo.setFont(new Font("", Font.BOLD, 30));
        btnInfo.setBounds(550, 160, 379, 60);
        contentPane.add(btnInfo);

        btnCheckInOut = new JButton("Check-In & Out");
        btnCheckInOut.setFont(new Font("", Font.BOLD, 30));
        btnCheckInOut.setBounds(80, 220, 379, 220);
        contentPane.add(btnCheckInOut);

        btnAdmin = new JButton("ADMIN");
        btnAdmin.setFont(new Font("", Font.BOLD, 30));
        btnAdmin.setBounds(550, 220, 379, 220);
        contentPane.add(btnAdmin);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("hotel-management/images/bb.jpg"));
        lblNewLabel.setBounds(0, 0, 997, 220);
        contentPane.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(70, 130, 180));
        panel.setBounds(0, 442, 997, 85);
        contentPane.add(panel);

        JLabel lblFromSeasideTo = new JLabel("Grand Hyatt Java");
        lblFromSeasideTo.setForeground(new Color(240, 255, 255));
        lblFromSeasideTo.setFont(new Font("", Font.BOLD, 40));
        panel.add(lblFromSeasideTo);
    }

    public JButton getBtnInfo() {
        return btnInfo;
    }

    public JButton getBtnCheckInOut() {
        return btnCheckInOut;
    }

    public JButton getBtnAdmin() {
        return btnAdmin;
    }

    public static void main(String[] args) {
        MenuSelectView view = new MenuSelectView();
        MenuSelectController controller = new MenuSelectController(view);
        view.setVisible(true);
    }


}