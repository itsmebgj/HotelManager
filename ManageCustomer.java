package hotel;

import com.mysql.jdbc.Statement;
import hotel.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ManageCustomer {
    private PreparedStatement psmt;


    // update
    public void updateReservation(int reserveNo, String customerName, String phone, String roomNo, String guestNum) {
        try {
            Connection conn= DBConnection.getInstance();
            psmt = conn.prepareStatement("UPDATE RESERVE SET CUSTOMER_NAME = ?, PHONE = ?, ROOM_NO = ?, GUEST_NUM = ? WHERE RESERVE_NO = ?");
            psmt.setString(1, customerName);
            psmt.setString(2, phone);
            psmt.setInt(3, Integer.parseInt(roomNo));
            psmt.setInt(4, Integer.parseInt(guestNum));
            psmt.setInt(5, reserveNo);

            psmt.executeUpdate();
            System.out.println("예약 정보가 변경되었습니다");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    // get last ID
    public int getLastId() {
        try {
            Connection conn= DBConnection.getInstance();
            psmt = conn.prepareStatement("SELECT id FROM customertb ORDER BY id DESC LIMIT 1;");
            ResultSet rs = psmt.executeQuery();
            rs.next();        //ResultSet에서 데이터를 읽을 때 cursor point를 첫 번째 로우에 맞추어야 한다.
            return rs.getInt(1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    // delete
    public void deleteReservation(String reserveNo) {
        try {
            Connection conn= DBConnection.getInstance();
            psmt = conn.prepareStatement("DELETE FROM RESERVE WHERE RESERVE_NO = '" + reserveNo + "'");
            psmt.executeUpdate();
            System.out.println("예약 정보가 삭제되었습니다");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    // table 데이터 가져오기. JTable이 문자열 2차원 배열을 입력값으로 받기 때문에
    public String[][] getReservations() {
        try {
            Connection conn= DBConnection.getInstance();
            psmt = conn.prepareStatement("SELECT RESERVE_NO, CUSTOMER_NAME, PHONE, ROOM_NO, GUEST_NUM FROM RESERVE");
            ResultSet rs = psmt.executeQuery();
            ArrayList<String[]> list = new ArrayList<String[]>();
            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("RESERVE_NO"),
                        rs.getString("CUSTOMER_NAME"),
                        rs.getString("PHONE"),
                        rs.getString("ROOM_NO"),
                        rs.getString("GUEST_NUM"),
                });
            }
            String[][] arr = new String[list.size()][5];
            System.out.println("데이터 불러오기 완료");
            return list.toArray(arr);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    // table에 데이터 추가

    public int createReservation(String customerName, String phone, String roomNo, String guestNum) {
        try {
            Connection conn= DBConnection.getInstance();
            psmt = conn.prepareStatement(
                    "INSERT INTO RESERVE (CUSTOMER_NAME, PHONE, ROOM_NO, GUEST_NUM) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            psmt.setString(1, customerName);
            psmt.setString(2, phone);
            psmt.setInt(3, Integer.parseInt(roomNo));
            psmt.setInt(4, Integer.parseInt(guestNum));

            psmt.executeUpdate();

            ResultSet rs = psmt.getGeneratedKeys();
            if (rs.next()) {
               int reserveNo = rs.getInt(1);
                System.out.println("예약이 추가되었습니다. 예약 번호: " + reserveNo);
                return reserveNo;
            } else {
                System.out.println("예약 정보를 가져올 수 없습니다.");
                return -1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }


    // database 연결




}
