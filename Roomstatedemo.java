package hotel;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.Color;

public class Roomstatedemo extends JFrame {
	private JTextField reservedNameField;
	private JTextField reservedLengthField;
	private JTextField reservedHowManyField;
	private JTextField reservedPhoneField;
	private JTextField stayNameField;
	private JTextField stayLenghtField;
	private JTextField stayHowManyField;
	private JTextField stayPhoneField;
	
	public Roomstatedemo() {
		setSize(807,642);
		getContentPane().setLayout(null);
		
		JButton button301 = new JButton("301");
		button301.setBounds(71, 211, 116, 42);
		getContentPane().add(button301);
		
		JButton button302 = new JButton("302");
		button302.setBounds(195, 211, 116, 42);
		getContentPane().add(button302);
		
		JButton button402 = new JButton("402");
		button402.setBounds(195, 159, 116, 42);
		getContentPane().add(button402);
		
		JButton button401 = new JButton("401");
		button401.setBounds(71, 159, 116, 42);
		getContentPane().add(button401);
		
		JButton button502 = new JButton("502");
		button502.setBounds(195, 107, 116, 42);
		getContentPane().add(button502);
		
		JButton button501 = new JButton("501");
		button501.setBounds(71, 107, 116, 42);
		getContentPane().add(button501);
		
		JButton button503 = new JButton("503");
		button503.setBounds(323, 107, 116, 42);
		getContentPane().add(button503);
		
		JButton button504 = new JButton("504");
		button504.setBounds(447, 107, 116, 42);
		getContentPane().add(button504);
		
		JButton button403 = new JButton("403");
		button403.setBounds(323, 159, 116, 42);
		getContentPane().add(button403);
		
		JButton button404 = new JButton("404");
		button404.setBounds(447, 159, 116, 42);
		getContentPane().add(button404);
		
		JButton button303 = new JButton("303");
		button303.setBounds(323, 211, 116, 42);
		getContentPane().add(button303);
		
		JButton button304 = new JButton("304");
		button304.setBounds(447, 211, 116, 42);
		getContentPane().add(button304);
		
		JButton button505 = new JButton("505");
		button505.setBounds(575, 107, 116, 42);
		getContentPane().add(button505);
		
		JButton button405 = new JButton("405");
		button405.setBounds(575, 159, 116, 42);
		getContentPane().add(button405);
		
		JButton button305 = new JButton("305");
		button305.setBounds(575, 211, 116, 42);
		getContentPane().add(button305);
		
		JButton button201 = new JButton("201");
		button201.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button201.setBounds(71, 263, 116, 42);
		getContentPane().add(button201);
		
		JButton button202 = new JButton("202");
		button202.setBounds(195, 263, 116, 42);
		getContentPane().add(button202);
		
		JButton button203 = new JButton("203");
		button203.setBounds(323, 263, 116, 42);
		getContentPane().add(button203);
		
		JButton button204 = new JButton("204");
		button204.setBounds(447, 263, 116, 42);
		getContentPane().add(button204);
		
		JButton button205 = new JButton("205");
		button205.setBounds(575, 263, 116, 42);
		getContentPane().add(button205);
		
		JLabel lblNewLabel = new JLabel("객실 번호");
		lblNewLabel.setBounds(71, 396, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("객실 종류");
		lblNewLabel_1.setBounds(71, 421, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("최소 인원");
		lblNewLabel_2.setBounds(71, 446, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("최대 인원");
		lblNewLabel_1_1.setBounds(71, 471, 57, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("침대 수");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(71, 496, 57, 15);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox roomStateComboBox = new JComboBox();
		roomStateComboBox.setModel(new DefaultComboBoxModel(new String[] {"공실", "예약", "투숙"}));
		roomStateComboBox.setToolTipText("");
		roomStateComboBox.setBounds(158, 517, 116, 23);
		getContentPane().add(roomStateComboBox);
		
		JLabel lblNewLabel_3 = new JLabel("객실 상태");
		lblNewLabel_3.setBounds(71, 521, 57, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblSelectDate = new JLabel("Select Date");
		lblSelectDate.setFont(new Font("굴림", Font.BOLD, 13));
		lblSelectDate.setBounds(71, 62, 77, 15);
		getContentPane().add(lblSelectDate);
		
		JLabel lblNewLabel_4_1 = new JLabel("Room State Management");
		lblNewLabel_4_1.setFont(new Font("돋움", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(267, 10, 270, 42);
		getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4 = new JLabel("<투숙자 정보>");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_4.setBounds(597, 366, 116, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("성함");
		lblNewLabel_1_2.setBounds(557, 396, 57, 15);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("기간");
		lblNewLabel_2_1.setBounds(557, 427, 57, 15);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("인원");
		lblNewLabel_1_1_2.setBounds(557, 457, 57, 15);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("전화번호");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setBounds(557, 489, 57, 15);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("<예약자 정보>");
		lblNewLabel_4_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_2.setBounds(366, 366, 101, 15);
		getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("성함");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setBounds(323, 395, 57, 15);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("기간");
		lblNewLabel_2_1_1.setBounds(323, 426, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("인원");
		lblNewLabel_1_1_2_1.setBounds(323, 459, 57, 15);
		getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("전화번호");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1.setBounds(323, 491, 57, 15);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		reservedNameField = new JTextField();
		reservedNameField.setColumns(10);
		reservedNameField.setBounds(395, 394, 116, 21);
		getContentPane().add(reservedNameField);
		
		reservedLengthField = new JTextField();
		reservedLengthField.setColumns(10);
		reservedLengthField.setBounds(395, 425, 116, 21);
		getContentPane().add(reservedLengthField);
		
		reservedHowManyField = new JTextField();
		reservedHowManyField.setColumns(10);
		reservedHowManyField.setBounds(395, 456, 116, 21);
		getContentPane().add(reservedHowManyField);
		
		reservedPhoneField = new JTextField();
		reservedPhoneField.setColumns(10);
		reservedPhoneField.setBounds(395, 487, 116, 21);
		getContentPane().add(reservedPhoneField);
		
		stayNameField = new JTextField();
		stayNameField.setColumns(10);
		stayNameField.setBounds(626, 392, 116, 21);
		getContentPane().add(stayNameField);
		
		stayLenghtField = new JTextField();
		stayLenghtField.setColumns(10);
		stayLenghtField.setBounds(626, 423, 116, 21);
		getContentPane().add(stayLenghtField);
		
		stayHowManyField = new JTextField();
		stayHowManyField.setColumns(10);
		stayHowManyField.setBounds(626, 454, 116, 21);
		getContentPane().add(stayHowManyField);
		
		stayPhoneField = new JTextField();
		stayPhoneField.setColumns(10);
		stayPhoneField.setBounds(626, 485, 116, 21);
		getContentPane().add(stayPhoneField);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("<객실 정보>");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_2_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_4_2_1.setBounds(128, 364, 92, 15);
		getContentPane().add(lblNewLabel_4_2_1);
		
		JTextArea bedNumberText = new JTextArea();
		bedNumberText.setBounds(147, 491, 127, 20);
		getContentPane().add(bedNumberText);
		
		JTextArea maxPeopleText = new JTextArea();
		maxPeopleText.setBounds(147, 466, 127, 20);
		getContentPane().add(maxPeopleText);
		
		JTextArea minPeopleText = new JTextArea();
		minPeopleText.setBounds(147, 441, 127, 20);
		getContentPane().add(minPeopleText);
		
		JTextArea roomTypeText = new JTextArea();
		roomTypeText.setBounds(147, 416, 127, 20);
		getContentPane().add(roomTypeText);
		
		JTextArea roomNumberText = new JTextArea();
		roomNumberText.setBounds(147, 391, 127, 20);
		getContentPane().add(roomNumberText);
		
		JButton saveDataButton = new JButton("저장");
		saveDataButton.setForeground(Color.BLACK);
		saveDataButton.setBackground(Color.WHITE);
		saveDataButton.setFont(new Font("굴림", Font.BOLD, 13));
		saveDataButton.setBounds(670, 559, 72, 34);
		getContentPane().add(saveDataButton);
		setVisible(true);
	}
}

