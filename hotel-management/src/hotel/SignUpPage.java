package hotel;

import hotel.database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpPage extends JFrame {

    private final JTextField tfNewUsername;
    private final JPasswordField tfNewPwd;
    private final JPasswordField tfConfirmPwd;

    public SignUpPage() {
        super("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNewUsername = new JLabel("New Username:");
        tfNewUsername = new JTextField();

        JLabel lblNewPwd = new JLabel("New Password:");
        tfNewPwd = new JPasswordField();

        JLabel lblConfirmPwd = new JLabel("Confirm Password:");
        tfConfirmPwd = new JPasswordField();

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 닫기
            }
        });

        add(lblNewUsername);
        add(tfNewUsername);
        add(lblNewPwd);
        add(tfNewPwd);
        add(lblConfirmPwd);
        add(tfConfirmPwd);
        add(btnSignUp);
        add(btnCancel);

        pack(); // 윈도우 크기를 컨텐츠에 맞게 조절
        setResizable(false); // 크기 조절 비활성화
        setLocationRelativeTo(null);
    }

    private void signUp() {
        String newUsername = tfNewUsername.getText();
        String newPassword = String.valueOf(tfNewPwd.getPassword());
        String confirmPwd = String.valueOf(tfConfirmPwd.getPassword());

        if (newUsername.equals("") || newPassword.equals("") || confirmPwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!newPassword.equals(confirmPwd)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 중복 확인
        if (isUsernameExists(newUsername)) {
            JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 중복이 없으면 회원가입 진행
//		GetConnection connect=new GetConnection();
        Connection conn= DBConnection.getInstance();

        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user (username, password) VALUES (?, ?)");
            ps.setString(1, newUsername);
            ps.setString(2, newPassword);

            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Sign up successful. You can now log in.", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // 회원가입 페이지 닫기
            } else {
                JOptionPane.showMessageDialog(this, "Error during sign up.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isUsernameExists(String username) {
//		GetConnection connect=new GetConnection();
        Connection conn= DBConnection.getInstance();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username = ?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // 결과가 존재하면 true, 없으면 false 반환
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }
}

