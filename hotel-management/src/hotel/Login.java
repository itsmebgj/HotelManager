package hotel;

import hotel.controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

	public JFrame frame;
	public JTextField userId;
	public JPasswordField userPassword;

	final JLabel Ustar = new JLabel("*");
	final JLabel Pstar = new JLabel("*");

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
		Ustar.setVisible(false);
		Pstar.setVisible(false);
	}

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("", Font.BOLD, 23));
		frame.setBounds(50, 50, 898, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogin = createLabel("LOGIN ", 100, 350, 212, 67, new Font("", Font.BOLD, 32));
		frame.getContentPane().add(lblLogin);

		JLabel lblUsername = createLabel("USERNAME", 300, 324, 155, 50, new Font("", Font.BOLD, 23));
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = createLabel("PASSWORD", 300, 413, 200, 38, new Font("", Font.BOLD, 23));
		frame.getContentPane().add(lblPassword);

		userId = createTextField(new Font("", Font.BOLD, 23));
		frame.getContentPane().add(userId);

		userPassword = createPasswordField(new Font("", Font.BOLD, 23));
		frame.getContentPane().add(userPassword);

		createLoginButton();
		createCancelButton();
		createSignUpButton();

		Ustar.setForeground(Color.RED);
		Ustar.setFont(new Font("", Font.BOLD, 28));
		Ustar.setBounds(699, 347, 46, 21);
		frame.getContentPane().add(Ustar);

		Pstar.setForeground(Color.RED);
		Pstar.setFont(new Font("", Font.BOLD, 28));
		Pstar.setBounds(699, 430, 46, 21);
		frame.getContentPane().add(Pstar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/login.png"));
		label.setBounds(300, 110, 314, 283);
		frame.getContentPane().add(label);

		JLabel lblHotelManagementSystem = createLabel("HOTEL MANAGEMENT SYSTEM", 109, 72, 636, 80, new Font("", Font.BOLD, 40));
		frame.getContentPane().add(lblHotelManagementSystem);
	}

	private JLabel createLabel(String text, int x, int y, int width, int height, Font font) {
		JLabel label = new JLabel(text);
		label.setFont(font);
		label.setBounds(x, y, width, height);
		return label;
	}

	private JTextField createTextField(Font font) {
		JTextField textField = new JTextField();
		textField.setFont(font);
		textField.setBounds(489, 331, 208, 38);
		return textField;
	}

	private JPasswordField createPasswordField(Font font) {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(font);
		passwordField.setBounds(489, 414, 208, 38);
		return passwordField;
	}

	private void createLoginButton() {
		JButton btnLogin = createButton("LOGIN", 288, 147, 50, this::handleLogin);
		frame.getContentPane().add(btnLogin);
	}

	private void createCancelButton() {
		JButton btnCancel = createButton("CANCEL", 588, 155, 51, e -> System.exit(0));
		frame.getContentPane().add(btnCancel);
	}

	private void createSignUpButton() {
		JButton btnSignUp = createButton("SIGN UP", 438, 147, 50, e -> openSignUpPage());
		frame.getContentPane().add(btnSignUp);
	}

	private JButton createButton(String text, int x, int width, int height, ActionListener listener) {
		JButton button = new JButton(text);
		button.addActionListener(listener);
		button.setFont(new Font("", Font.BOLD, 23));
		button.setBounds(x, 513, width, height);
		return button;
	}

	private void handleLogin(ActionEvent e) {
		Ustar.setVisible(false);
		Pstar.setVisible(false);
		if (userId.getText().isEmpty()) {
			Ustar.setVisible(true);
		}
		if (String.valueOf(userPassword.getPassword()).isEmpty()) {
			Pstar.setVisible(true);
		} else {
			LoginController loginController = new LoginController(this);
			loginController.handleLogin();
		}
	}

	private void openSignUpPage() {
		SignUpPage signUpPage = new SignUpPage();
		signUpPage.setVisible(true);
		signUpPage.pack();
		signUpPage.setLocationRelativeTo(null);
	}
}