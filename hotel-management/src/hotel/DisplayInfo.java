package  hotel;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DisplayInfo extends JFrame {

    private JFrame frame;
    private JTextField searchTextField;

    private final hotel.ManageCustomer customer = new hotel.ManageCustomer();
    private String[][] data;

    private DefaultTableModel tableModel ;
    private JTable table ;

    private JLabel telLabel;

    private JLabel nameLabel;
    private JLabel roomNumLabel;
    private JLabel guestNumLabel;

    private JTextField idTextfield;
    private JTextField telTextfield;

    private JTextField nameTextfield;

    private JTextField roomNumTextfield;
    private JTextField guestNumTextfield;


    private JButton btnSave;
    private JButton btnCancel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JPanel panelBottomCh;
    private JPanel tablePanel;


    private JButton btnInsert;
    private JButton btnDelete;
    private JButton btnUpdate;

    private int selectedIdx;
    private boolean updateMode = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {    // ?? invokeLater 찾기
            public void run() {
                try {
                    DisplayInfo displayInfo = new DisplayInfo();
                    displayInfo.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

        public DisplayInfo() {
            initialize();
        }

        private void initialize() {

            hotel.ManageCustomer customer = new hotel.ManageCustomer();

            // 패널 배치
            frame = new JFrame("고객 관리");     // 메인 프레임
            frame.setSize(1024, 768);             // 프레임 크기
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 누르면 프로그램 종료
            frame.setLocationRelativeTo(null);  // 프레임을 화면 중앙에 배치
            frame.setResizable(false);            // 프레임 크기를 변경하지 못하도록 설정
            frame.getContentPane().setLayout(null); // 프레임에 추가되는 컴포넌트 레이아웃 -> Absolute

            panelTop = new JPanel();
            panelTop.setBounds(6, 6, 1012, 354);
            panelTop.setLayout(null);
            frame.getContentPane().add(panelTop);
            panelTop.setVisible(true);

            panelBottom = new JPanel();
            panelBottom.setBounds(6, 372, 1012, 354);
            panelBottom.setLayout(null);
            frame.getContentPane().add(panelBottom);
            panelBottom.setVisible(false);


// 검색 필드
            JLabel lblSearch = new JLabel("검색어 입력");
            lblSearch.setBounds(6, 10, 129, 30);
            panelTop.add(lblSearch);

            searchTextField = new JTextField();
            searchTextField.setBounds(135, 9, 857, 30);
            searchTextField.setColumns(10);
            panelTop.add(searchTextField);

            searchTextField.addKeyListener(new KeyAdapter() { // 검색어 입력 텍스트필드 이벤트
                @Override
                public void keyReleased(KeyEvent e) {
                    String val = searchTextField.getText();
                    TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
                    table.setRowSorter(trs);
                    trs.setRowFilter(RowFilter.regexFilter(val));
                }
            });

            tablePanel = new JPanel();
            tablePanel.setBounds(20, 50, 972, 268);
            frame.getContentPane().add(tablePanel);
            panelTop.add(tablePanel);
            tablePanel.setVisible(true);

// 버튼 배치
            btnInsert = new JButton("추가");
            btnInsert.setBounds(689, 318, 100, 30);
            panelTop.add(btnInsert);


            btnUpdate = new JButton("변경");
            btnUpdate.setBounds(792, 318, 100, 30);
            panelTop.add(btnUpdate);

            btnDelete = new JButton("삭제");
            btnDelete.setBounds(892, 318, 100, 30);
            panelTop.add(btnDelete);

// 상세 정보 레이블
            JLabel lblDetails = new JLabel(" 상세 정보");
            lblDetails.setFont(new Font("Lucida Grande", Font.BOLD, 15));
            lblDetails.setBounds(20, 10, 100, 30);
            panelBottom.add(lblDetails);

// 각 항목 레이블
            String[] labels = {  "고객 이름", "고객 전화번호", "방 번호", "고객 번호"};
            JLabel [] labelFields = { nameLabel, telLabel, roomNumLabel, guestNumLabel};
            for (int i = 0; i < labels.length; i++) {
                labelFields[i]= new JLabel();
                //labelFields[i].setEditable(false);
                labelFields[i].setFont(new Font("Lucida Grande", Font.PLAIN, 14));
                labelFields[i].setText("       " + labels[i]);
                labelFields[i].setBounds(20, 50 + i * 50, 130, 40);
                panelBottom.add(labelFields[i]);
            }

// 각 항목 입력 필드
            // 텍스트 필드 위치 조정
            nameTextfield = new JTextField();
            nameTextfield.setColumns(10);
            nameTextfield.setBounds(155, 50, 341, 40);
            panelBottom.add(nameTextfield);

            telTextfield = new JTextField();
            telTextfield.setColumns(10);
            telTextfield.setBounds(155, 100, 341, 40);
            panelBottom.add(telTextfield);

            roomNumTextfield = new JTextField();
            roomNumTextfield.setColumns(10);
            roomNumTextfield.setBounds(155, 150, 341, 40);
            panelBottom.add(roomNumTextfield);

            guestNumTextfield = new JTextField();
            guestNumTextfield.setColumns(10);
            guestNumTextfield.setBounds(155, 200, 341, 40);
            panelBottom.add(guestNumTextfield);

// 저장, 취소 버튼
            btnSave = new JButton("저장");
            btnSave.setBounds(892, 13, 100, 30);
            panelBottom.add(btnSave);

            btnCancel = new JButton("취소");
            btnCancel.setBounds(792, 12, 100, 30);
            panelBottom.add(btnCancel);


            // 이벤트
            showTable();
            addTableRow();
            deleteTableRow();
            updateTableRow();
            saveData();
            cancelDate();

        }

        public void showTable() {
            hotel.ManageCustomer customer = new hotel.ManageCustomer();
            data = customer.getReservations();

            String[] header = new String[]{"예약번호", "이름", "전화번호", "호실", "고객번호"};

           tableModel = new DefaultTableModel(data, header);


           table = new JTable(tableModel) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            table.setBounds(50, 50, 975, 255);

            // 셀 값 가운데 정렬
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
            table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);

            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // 컬럼 크기
            TableColumnModel colModel = table.getColumnModel();
            colModel.getColumn(0).setPreferredWidth(15);
            colModel.getColumn(1).setPreferredWidth(30);
            colModel.getColumn(2).setPreferredWidth(100);
            colModel.getColumn(3).setPreferredWidth(300);

            table.getTableHeader().setFont(new Font("NanumGothic", Font.BOLD, 13));
            table.getTableHeader().setPreferredSize(new Dimension(100, 30));
            table.setFont(new Font("NanumGothic", Font.PLAIN, 13));
            table.setRowHeight(30);
//		table.setAlignmentX(0);

            // 테이블에 스크롤바 추가
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(975, 255));
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            tablePanel.add(scrollPane);

        }

        public String getCustomerId(int seledtedIdx) {
            return (String) table.getValueAt(seledtedIdx, 0);
        }

        public void deleteTableRow() {

            btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    selectedIdx = table.getSelectedRow();    // 선택한 행 인덱스 반환. 선택한 행이 없으면 -1 반환
                    if( selectedIdx == -1) {
                        JOptionPane.showMessageDialog(null, "테이블에서 삭제할 행을 선택하세요.");
                    } else {
                        // 선택한 행의 고객번호(id) 가져오기
                        String selectednum = getCustomerId(selectedIdx);
                        // db 데이터 삭제
                        customer.deleteReservation(selectednum);
                        // UI 테이블 행 삭제
                        tableModel.removeRow(selectedIdx);

                        JOptionPane.showMessageDialog(null, "고객 정보가 삭제되었습니다");
                    }
                }
            });
        }

    public void addTableRow() {
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
                panelBottom.setVisible(true);
            }
        });
    }

    public void updateTableRow() {
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateMode=true;
                handleUpdateAction();
            }
        });
    }

    private void handleUpdateAction() {
        selectedIdx = table.getSelectedRow();

        if (selectedIdx == -1) {
            JOptionPane.showMessageDialog(null, "테이블에서 변경할 행을 선택하세요.");
        } else {
            Object value = table.getValueAt(selectedIdx, 0);
            int id = Integer.parseInt(value.toString());
            nameTextfield.setText((String) table.getValueAt(selectedIdx, 1));
            telTextfield.setText((String) table.getValueAt(selectedIdx, 2));
            roomNumTextfield.setText((String) table.getValueAt(selectedIdx, 3));
            guestNumTextfield.setText((String) table.getValueAt(selectedIdx, 4));

            panelBottom.setVisible(true);

            btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 텍스트 필드에서 변경된 값을 가져오기
                    String updatedName = nameTextfield.getText();
                    String updatedTel = telTextfield.getText();
                    String updatedRoomNum = roomNumTextfield.getText();
                    String updatedGuestNum = guestNumTextfield.getText();

                    // updateReservation 메서드에 변경된 값 전달
                    customer.updateReservation(id, updatedName, updatedTel, updatedRoomNum, updatedGuestNum);

                    // 테이블에서 다른 곳을 선택할 수 없도록 설정
                    tableModel.fireTableDataChanged();  // UI 테이블 정보 갱신
                    panelBottom.setVisible(false);
                }
            });
        }
    }

    public void saveData() {
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    handleSaveAction();

            }
        });
    }

    private void handleSaveAction() {
        String[] inputList = getInputList();
        boolean valid = isValid(inputList);

        if (valid) {
            // update 버튼 이후에 호출된 경우
            if (updateMode) {
                int id = Integer.parseInt(table.getValueAt(selectedIdx, 0).toString());
                String updatedName = nameTextfield.getText();
                String updatedTel = telTextfield.getText();
                String updatedRoomNum = roomNumTextfield.getText();
                String updatedGuestNum = guestNumTextfield.getText();

                customer.updateReservation(id, updatedName, updatedTel, updatedRoomNum, updatedGuestNum);

                // 테이블 모델의 값 업데이트
                tableModel.setValueAt(updatedName, selectedIdx, 1);
                tableModel.setValueAt(updatedTel, selectedIdx, 2);
                tableModel.setValueAt(updatedRoomNum, selectedIdx, 3);
                tableModel.setValueAt(updatedGuestNum, selectedIdx, 4);
            }
            // insert 버튼 이후에 호출된 경우
            else {
                int id = customer.createReservation(inputList[0], inputList[1], inputList[2], inputList[3]);

                if (id != -1) {
                    String[] newRow = {Integer.toString(id), inputList[0], inputList[1], inputList[2], inputList[3]};
                    tableModel.addRow(newRow);
                    JOptionPane.showMessageDialog(null, "고객 정보가 추가되었습니다");
                }
            }

            // 테이블 모델의 데이터 변경을 알리고, 하단 패널을 감추기
            tableModel.fireTableDataChanged();
            panelBottom.setVisible(false);

            // 상태 초기화 (다음에는 insert 상태로 변경)
            updateMode = false;
        }
    }

    private String[] getInputList() {
        String[] inputList = new String[4];
        inputList[0] = nameTextfield.getText();
        inputList[1] = telTextfield.getText();
        inputList[2] = roomNumTextfield.getText();
        inputList[3] = guestNumTextfield.getText();
        return inputList;
    }

    private void clearTextFields() {
        nameTextfield.setText("");
        telTextfield.setText("");
        roomNumTextfield.setText("");
        guestNumTextfield.setText("");
    }

    public boolean isValid(String[] inputList) {

        // 필수 입력값이 비어있으면 안내
        if(inputList[0].equals("") | inputList[0].length() == 0) {
            nameTextfield.setText("고객 이름을 입력하세요.");

        } else if(inputList[1].equals("") | inputList[1].length() == 0) {
            telTextfield.setText("고객 전화번호를 입력하세요.");

        } else if(inputList[2].equals("") | inputList[2].length() == 0) {
            roomNumTextfield.setText("고객 주소를 입력하세요.");

        }

        // 필수 입력칸이 입력되었는지 검사
        for(String item: inputList) {
            if(item.equals("") | item.length() == 0)
                return false;
        }
        return true;
    }

    public void cancelDate() {
            btnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nameTextfield.setText(null);
                    telTextfield.setText(null);
                    roomNumTextfield.setText(null);
                    guestNumTextfield.setText(null);
                    panelBottom.setVisible(false);
                    table.setVisible(true);
                }
            });
        }

    }




