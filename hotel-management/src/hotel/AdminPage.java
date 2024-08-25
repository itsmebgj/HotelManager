package hotel;

import hotel.controller.MenuSelectController;
import hotel.database.DBConnection;
import hotel.view.MenuSelectView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminPage extends JFrame {

	private final JTable table;
	private final JTextField r1;
	private final JTextField r2;
	private final JTextField r3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminPage() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				displayRooms();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 965, 577);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddRooms = new JButton("ADD ROOMS");
		btnAddRooms.setIcon(new ImageIcon("images\\plus (1).png"));
		btnAddRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRooms();
				
			}
		});
		btnAddRooms.setFont(new Font("", Font.BOLD, 23));
		btnAddRooms.setBounds(12, 456, 225, 50);
		contentPane.add(btnAddRooms);
		
		JButton btnUpdate = new JButton("UPDATE ROOMS");
		btnUpdate.setIcon(new ImageIcon("images\\updated.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateRooms();
			}
		});
		btnUpdate.setFont(new Font("", Font.BOLD, 23));
		btnUpdate.setBounds(518, 456, 270, 50);
		contentPane.add(btnUpdate);
		
		JButton btnDleteRooms = new JButton("DELETE ROOMS");
		btnDleteRooms.setIcon(new ImageIcon("images\\iconfinder_f-cross_256_282471 (1).png"));
		btnDleteRooms.setFont(new Font("", Font.BOLD, 23));
		btnDleteRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRooms();
			}
		});
		btnDleteRooms.setBounds(248, 457, 258, 49);
		contentPane.add(btnDleteRooms);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(330, 201, 431, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("", Font.BOLD, 20));
		lblRoomType.setBounds(12, 216, 136, 38);
		contentPane.add(lblRoomType);
		
		JLabel lblBedType = new JLabel("BED TYPE");
		lblBedType.setFont(new Font("", Font.BOLD, 20));
		lblBedType.setBounds(12, 289, 136, 25);
		contentPane.add(lblBedType);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("", Font.BOLD, 20));
		lblPrice.setBounds(23, 345, 107, 27);
		contentPane.add(lblPrice);
		
		r1 = new JTextField();
		r1.setFont(new Font("", Font.BOLD, 20));
		r1.setBounds(160, 220, 147, 30);
		contentPane.add(r1);
		r1.setColumns(10);
		
		r2 = new JTextField();
		r2.setFont(new Font("", Font.BOLD, 20));
		r2.setBounds(160, 286, 146, 30);
		contentPane.add(r2);
		r2.setColumns(10);
		
		r3 = new JTextField();
		r3.setFont(new Font("", Font.BOLD, 20));
		r3.setBounds(160, 343, 147, 30);
		contentPane.add(r3);
		r3.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setIcon(new ImageIcon("hotel-management/images/back.png"));
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

		btnBack.setFont(new Font("", Font.BOLD, 20));
		btnBack.setBounds(800, 457, 136, 50);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("hotel-management/images/collage.jpg"));
		lblNewLabel.setBounds(0, 0, 947, 202);
		contentPane.add(lblNewLabel);
	}
	
	public void displayRooms()
	{
//		GetConnection connect=new GetConnection();
		Connection conn = DBConnection.getInstance();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ROOM NO");
		model.addColumn("ROOM TYPE");
		model.addColumn("BED TYPE");
		model.addColumn("PRICE");
		
		try {
			String query = "SELECT * FROM room";
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("room_No"),
						rs.getString("room_Type"),
						rs.getString("bed_Type"),
						rs.getString("Price")
				});
			}
			
			rs.close();
			st.close();
			conn.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(140);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setPreferredWidth(90);
			
			
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}
	
	public void addRooms()
	{
		 PreparedStatement preparedstatement;
		    ResultSet resultset = null;
				try {
			    	   
//			    		GetConnection connect=new GetConnection();
					Connection conn = DBConnection.getInstance();
			        	 preparedstatement=conn.prepareStatement("INSERT INTO room(ROOM_TYPE,BED_TYPE,PRICE) VALUES (?,?,?)");
		                 preparedstatement.setString(1,r1.getText());
			             preparedstatement.setString(2,r2.getText());
			             preparedstatement.setString(3,r3.getText());

			             if(preparedstatement.executeUpdate()>0)
			             {
			            	 JOptionPane.showMessageDialog(null, "New Room Added");
			             }
			         
			    	}
			    	
			    	catch(Exception ex)
			    	{
			    		ex.printStackTrace();
			    	}
	}
	
	public void updateRooms()
	{
		 PreparedStatement ps;
		    ResultSet result = null;
				try {
					int i =table.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					String no= model.getValueAt(i, 0).toString();
					System.out.println(no);
//			    		GetConnection connect=new GetConnection();
			    		Connection conn=DBConnection.getInstance();
			        	 ps=conn.prepareStatement("UPDATE room SET ROOM_TYPE=?, BED_TYPE= ?, PRICE=? where ROOM_NO=?");
		                 ps.setString(1,r1.getText());
			             ps.setString(2,r2.getText());
			             ps.setString(3,r3.getText());
			             ps.setString(4, no);
			             if(ps.executeUpdate()>0)
			             {
			            	 JOptionPane.showMessageDialog(null, " Room Updated ");
			             }
			         
			    	}
			    	
			    	catch(Exception ex)
			    	{
			    		ex.printStackTrace();
			    	}
	}
	
	public void deleteRooms()
	{
		PreparedStatement ps;
	    ResultSet result = null;
			try {
				int i =table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				String no= model.getValueAt(i, 0).toString();
				System.out.println(no);
//		    		GetConnection connect=new GetConnection();
		    		Connection conn=DBConnection.getInstance();
		        	 ps=conn.prepareStatement("DELETE FROM room  where ROOM_NO=?");
	                
		             ps.setString(1, no);
		             
		             
		             if(ps.executeUpdate()>0)
		             {
		            	 JOptionPane.showMessageDialog(null, " Room Deleted ");
		             }
		         
		    	}
		    	
		    	catch(Exception ex)
		    	{
		    		ex.printStackTrace();
		    	}
	}

}
