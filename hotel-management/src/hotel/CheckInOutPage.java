package hotel;

import hotel.controller.MenuSelectController;
import hotel.database.DBConnection;
import hotel.view.MenuSelectView;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CheckInOutPage extends JFrame {

	private final JTextField name;
	private final JTextField addr;
	private final JTextField phone;
	private final JTextField roomType;
	private final JTextField bedType;
	private final JTextField price;
	private final JTable table;
	private final JTextField days;
	private final JTextField total;
	private final JTextArea textArea;
    private final JLabel nameError;
    private final JLabel addrError;
    private final JLabel phoneError;
	private final JTextField roomNo;
    final SimpleDateFormat simpledateformat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
	final Date date = new Date();

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                CheckInOutPage frame = new CheckInOutPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	public CheckInOutPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				displayRooms();
				hideErrorLabels();
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 1236, 700);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME ");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("", Font.BOLD, 20));
		lblName.setBounds(32, 142, 107, 32);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("", Font.BOLD, 20));
		lblAddress.setBounds(32, 187, 107, 25);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNum = new JLabel("PHONE NUM ");
		lblPhoneNum.setFont(new Font("", Font.BOLD, 20));
		lblPhoneNum.setBounds(25, 229, 164, 25);
		contentPane.add(lblPhoneNum);
		Connection conn= DBConnection.getInstance();
        JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("", Font.BOLD, 20));
		lblRoomType.setBounds(32, 343, 134, 32);
		contentPane.add(lblRoomType);
		
		JLabel lblBedType = new JLabel("BED TYPE");
		lblBedType.setFont(new Font("", Font.BOLD, 20));
		lblBedType.setBounds(27, 403, 123, 25);
		contentPane.add(lblBedType);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("", Font.BOLD, 20));
		lblPrice.setBounds(32, 461, 107, 35);
		contentPane.add(lblPrice);
		
		name = new JTextField();
		name.setFont(new Font("", Font.BOLD, 20));
		name.setBounds(201, 142, 197, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		addr = new JTextField();
		addr.setFont(new Font("", Font.BOLD, 20));
		addr.setBounds(201, 187, 197, 32);
		contentPane.add(addr);
		addr.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("", Font.BOLD, 20));
		phone.setBounds(201, 225, 197, 32);
		contentPane.add(phone);
		phone.setColumns(10);
		
		roomType = new JTextField();
		roomType.setFont(new Font("", Font.BOLD, 20));
		roomType.setBounds(201, 343, 197, 32);
		contentPane.add(roomType);
		roomType.setColumns(10);
		
		bedType = new JTextField();
		bedType.setFont(new Font("", Font.BOLD, 20));
		bedType.setBounds(201, 399, 197, 32);
		contentPane.add(bedType);
		bedType.setColumns(10);
		
		price = new JTextField();
		price.setFont(new Font("", Font.BOLD, 20));
		price.setBounds(201, 456, 197, 32);
		contentPane.add(price);
		price.setColumns(10);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int selectedRow =table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				roomNo.setText(model.getValueAt(selectedRow, 0).toString());
				roomType.setText(model.getValueAt(selectedRow, 1).toString());
				bedType.setText(model.getValueAt(selectedRow,2).toString());
				price.setText(model.getValueAt(selectedRow,3).toString());
			}
		});

		scrollPane.setBounds(427, 173, 419, 408);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

//		버튼 추가
		JButton btnCheckIn = createCheckInButton();
		contentPane.add(btnCheckIn);

		JButton btnBack = createBackButton();
		contentPane.add(btnBack);

		JButton btnCheckout = createCheckOutButton();
		contentPane.add(btnCheckout);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuSelectView menuSelect = new MenuSelectView();
				MenuSelectController controller = new MenuSelectController(menuSelect);
				menuSelect.setVisible(true);
				menuSelect.pack();
				menuSelect.setLocationRelativeTo(null);
				menuSelect.setBounds(100, 100, 1080, 633);
				setVisible(false);
			}
		});

		days = new JTextField();
		days.setFont(new Font("", Font.BOLD, 20));
		days.setBounds(201, 507, 197, 32);
		contentPane.add(days);
		days.setColumns(10);
		
		JLabel lblNoOfDays = new JLabel("NO OF DAYS");
		lblNoOfDays.setFont(new Font("", Font.BOLD, 20));
		lblNoOfDays.setBounds(32, 511, 147, 25);
		contentPane.add(lblNoOfDays);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("", Font.BOLD, 20));
		lblTotal.setBounds(32, 556, 107, 25);
		contentPane.add(lblTotal);
		
		total = new JTextField();
		total.setFont(new Font("", Font.BOLD, 20));
		total.setBounds(201, 552, 197, 32);
		contentPane.add(total);
		total.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(858, 176, 348, 408);
		contentPane.add(textArea);
		
		nameError = new JLabel("*");
		nameError.setFont(new Font("Tahoma", Font.BOLD, 20));
		nameError.setForeground(new Color(255, 0, 0));
		nameError.setBounds(404, 143, 22, 25);
		contentPane.add(nameError);
		
		addrError = new JLabel("*");
		addrError.setFont(new Font("Tahoma", Font.BOLD, 20));
		addrError.setForeground(Color.RED);
		addrError.setBounds(404, 196, 22, 16);
		contentPane.add(addrError);
		
		phoneError = new JLabel("*");
		phoneError.setForeground(Color.RED);
		phoneError.setFont(new Font("Tahoma", Font.BOLD, 20));
		phoneError.setBounds(404, 230, 22, 16);
		contentPane.add(phoneError);

		JLabel lblRoomNo = new JLabel("ROOM NO");
		lblRoomNo.setFont(new Font("", Font.BOLD, 20));
		lblRoomNo.setBounds(32, 286, 147, 29);
		contentPane.add(lblRoomNo);
		
		roomNo = new JTextField();
		roomNo.setFont(new Font("", Font.BOLD, 20));
		roomNo.setBounds(199, 284, 199, 32);
		contentPane.add(roomNo);
		roomNo.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("hotel-management/images/jk1.jpg"));
		label.setBounds(0, 0, 1218, 212);
		contentPane.add(label);

		JButton btnShowHistory = createShowHistoryButton();
		contentPane.add(btnShowHistory);

	}

	private JButton createCheckInButton() {
		JButton btnCheckIn = new JButton("CHECK-IN");
		btnCheckIn.setFont(new Font("", Font.BOLD, 20));
		btnCheckIn.setIcon(new ImageIcon("hotel-management/images/updated.jpg"));
		btnCheckIn.addActionListener(e -> checkIn());
		btnCheckIn.setBounds(115, 603, 180, 38);
		return btnCheckIn;
	}

	private JButton createBackButton() {
		JButton btnBack = new JButton("BACK");
		btnBack.setIcon(new ImageIcon("hotel-management/images/back.png"));
		btnBack.addActionListener(e -> goBack());
		btnBack.setFont(new Font("", Font.BOLD, 20));
		btnBack.setBounds(900, 603, 180, 38);
		return btnBack;
	}

	private JButton createCheckOutButton() {
		JButton btnCheckout = new JButton("CHECK-OUT");
		btnCheckout.addActionListener(e -> checkOut());
		btnCheckout.setFont(new Font("", Font.BOLD, 20));
		btnCheckout.setBounds(300, 603, 180, 38);
		return btnCheckout;
	}

	private JButton createShowHistoryButton() {
		JButton btnShowHistory = new JButton("Check Room");
		btnShowHistory.setFont(new Font("", Font.BOLD, 20));
		btnShowHistory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Show History 버튼을 클릭했을 때 이벤트 처리
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRoomNo = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
					displayHistoryForRoom(selectedRoomNo);
				} else {
					JOptionPane.showMessageDialog(null, "방을 선택해주세요.");
				}
			}
		});
		btnShowHistory.setBounds(500, 603, 180, 38);
		return btnShowHistory;
	}

	private void hideErrorLabels() {
		nameError.setVisible(false);
		addrError.setVisible(false);
		phoneError.setVisible(false);
	}

	private void displayBillReceipt() {
		textArea.setText("**************************************************************************\n");
		textArea.append("******      	    YOUR BILL RECEIPT      	     ******\n");
		textArea.append("*************************************************************************\n\n");
		textArea.append("TIME     : " + simpledateformat.format(date) + "\n\n");
		textArea.append("NAME     :    " + name.getText() + "\n\n");
		textArea.append("ADDRESS  :    " + addr.getText() + "\n\n");
		textArea.append("PHONE NUM  :    " + phone.getText() + "\n\n");
		textArea.append("ROOM TYPE  : " + roomType.getText() + "\n\n");
		textArea.append("BED TYPE  : " + bedType.getText() + "\n\n");
		textArea.append("TOTAL AMOUNT   :   " + total.getText() + "\n\n");
	}

	private void displayHistoryForRoom(int roomNumber) {
		Connection conn = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// HISTORY 테이블에서 방 번호에 해당하는 데이터 조회
			String historyQuery = "SELECT * FROM HISTORY WHERE ROOM_NO = ?";
			preparedStatement = conn.prepareStatement(historyQuery);
			preparedStatement.setInt(1, roomNumber);
			resultSet = preparedStatement.executeQuery();

			// JTextArea에 HISTORY 데이터 표시
			StringBuilder historyText = new StringBuilder("방 번호" + roomNumber + ":\n");
			while (resultSet.next()) {
				historyText.append("체크인 날짜: ").append(resultSet.getDate("START_DATE")).append("\n");
				historyText.append("체크아웃 날짜: ").append(resultSet.getDate("END_DATE")).append("\n");
				historyText.append("고객 이름: ").append(resultSet.getString("CUSTOMER_NAME")).append("\n");
				historyText.append("전화번호: ").append(resultSet.getString("PHONE")).append("\n\n");
			}

			textArea.setText(historyText.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (preparedStatement != null) preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void displayRooms() {
//		GetConnection connect=new GetConnection();
		Connection conn= DBConnection.getInstance();
		 DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ROOM NO");
		model.addColumn("ROOM TYPE");
		model.addColumn("BED TYPE");
		model.addColumn("PRICE");
		model.addColumn("STATUS");

		try {
			String query = "SELECT * FROM room";
			try (Statement st = conn.createStatement()) {
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
                    model.addRow(new Object[]{
							rs.getString("ROOM_No"),
							rs.getString("ROOM_Type"),
							rs.getString("BED_Type"),
							rs.getString("Price"),
							rs.getString("STATUS")
					});
				}

				rs.close();

			}
			conn.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(70);
			table.getColumnModel().getColumn(4).setPreferredWidth(70);

			table.getColumnModel().getColumn(4).setCellRenderer(new StatusCellRenderer());
		}
		
		catch(Exception e) {
		e.printStackTrace();
		}
	
	}

//	방 상태에 따른 색깔 변화
	private static class StatusCellRenderer extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			String status = (String) value;
			switch (status) {
				case "0":
					cellComponent.setBackground(Color.GREEN);
					break;
				case "1":
					cellComponent.setBackground(Color.BLUE);
					break;
				case "2":
					cellComponent.setBackground(Color.RED);
					break;
				default:
					cellComponent.setBackground(table.getBackground());
			}

			return cellComponent;
		}
	}

	public void calculateTotal() {
		int day=Integer.parseInt(days.getText());
		int pr= Integer.parseInt(price.getText());
		int total=day*pr;
		System.out.println(total);
		this.total.setText(Integer.toString(total));
		
	}

	public void checkIn() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int numberOfDays = Integer.parseInt(days.getText());
		LocalDate startDate = java.time.LocalDate.now();
		LocalDate endDate = startDate.plusDays(numberOfDays);

		try {
			int selectedRoomNo = Integer.parseInt(roomNo.getText());

			Connection conn = DBConnection.getInstance();

			// 선택한 방이 비어있는지 확인
			String checkAvailabilityQuery = "SELECT * FROM ROOM WHERE ROOM_NO = ? AND STATUS = 0";
			preparedStatement = conn.prepareStatement(checkAvailabilityQuery);
			preparedStatement.setInt(1, selectedRoomNo);
			resultSet = preparedStatement.executeQuery();

			// 체크인 상태로 변경
			if (resultSet.next()) {
				String updateStatusQuery = "UPDATE ROOM SET STATUS = 2 WHERE ROOM_NO = ?";
				preparedStatement = conn.prepareStatement(updateStatusQuery);
				preparedStatement.setInt(1, selectedRoomNo);

				int updatedRows = preparedStatement.executeUpdate();

				if (updatedRows > 0) {

					String insertHistoryQuery = "INSERT INTO HISTORY (ROOM_NO, START_DATE, END_DATE, CUSTOMER_NAME, PHONE) " +
							"VALUES (?, ?, ?, ?, ?)";
					preparedStatement = conn.prepareStatement(insertHistoryQuery);
					preparedStatement.setInt(1, selectedRoomNo);
					preparedStatement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
					preparedStatement.setDate(3, java.sql.Date.valueOf(endDate));
					preparedStatement.setString(4, name.getText()); // 고객 이름
					preparedStatement.setString(5, phone.getText()); // 고객 전화번호


					preparedStatement.executeUpdate();

					JOptionPane.showMessageDialog(null, "체크인이 완료되었습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "체크인에 실패하였습니다.");
				}

				calculateTotal();
				displayBillReceipt();
			} else {
				JOptionPane.showMessageDialog(null, "이 방은 체크인 할 수 없습니다.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (preparedStatement != null) preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void checkOut() {
		PreparedStatement preparedStatement = null;

		try {
			Connection conn = DBConnection.getInstance();

			// 체크아웃 시 해당 방의 상태를 0으로 변경 (비어있음)
			preparedStatement = conn.prepareStatement("UPDATE ROOM SET STATUS = 0 WHERE ROOM_NO = ?");
			preparedStatement.setInt(1, Integer.parseInt(roomNo.getText()));

			if (preparedStatement.executeUpdate() > 0) {

				JOptionPane.showMessageDialog(null, "체크아웃이 완료되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "체크아웃에 실패하였습니다.");
			}
			calculateTotal();
			displayBillReceipt();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void goBack() {
		MenuSelectView menuSelect = new MenuSelectView();
		MenuSelectController controller = new MenuSelectController(menuSelect);
		menuSelect.setVisible(true);
		menuSelect.pack();
		menuSelect.setLocationRelativeTo(null);
		menuSelect.setBounds(100, 100, 1080, 633);
		setVisible(false);
	}

}