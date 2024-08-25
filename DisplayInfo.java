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

    private final ManageCustomer customer = new ManageCustomer();
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
        public static void main(String[] args) {

            EventQueue.invokeLater(new Runnable() {    // ?? invokeLater 찾기
                public void run() {
                    try {
                        DisplayInfo window = new DisplayInfo();
                        window.frame.setVisible(true);
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

            ManageCustomer customer = new ManageCustomer();

            // 패널 배치
            frame = new JFrame("고객 관리");     // 메인 프레임
            frame.setSize(1024, 768);             // 프레임 크기
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 누르면 프로그램 종료
            frame.setLocationRelativeTo(null);  // 프레임을 화면 중앙에 배치
            frame.setResizable(false);            // 프레임 크기를 변경하지 못하도록 설정
            frame.getContentPane().setLayout(null); // 프레임에 추가되는 컴포넌트 레이아웃 -> Absolute

            panelTop = new JPanel();            // 상단 패널
            panelTop.setBounds(6, 6, 1012, 354); // 패널 위치와 크기  -> (x좌표, y좌표, 넓이, 높이)
            panelTop.setLayout(null);           // 상단 패널에 추가되는 컴포넌트 레이아웃 -> Absolute
            frame.getContentPane().add(panelTop); // 프레임에 추가하기
            panelTop.setVisible(true);           // 패널 보이기

            panelBottom = new JPanel();                // 하단 패널
            panelBottom.setBounds(6, 372, 1012, 354); // 패널 위치와 크기  -> (x좌표, y좌표, 넓이, 높이)
            panelBottom.setLayout(null);               // 하단 패널에 추가되는 컴포넌트 레이아웃 -> Absolute
            frame.getContentPane().add(panelBottom);   // 프레임에 추가하기
            panelBottom.setVisible(false);             // 하단 패널 가리기\


// 검색 필드
            JLabel lblSearch = new JLabel("검색어 입력"); // 검색어 입력 레이블
            lblSearch.setBounds(6, 10, 129, 30);         // 검색어 입력 레이블 위치와 크기
            panelTop.add(lblSearch);                     // 상단 패널에 붙이기

            searchTextField = new JTextField();           // 검색어 입력 텍스트필드 생성
            searchTextField.setBounds(135, 9, 857, 30);   // 검색어 입력 텍스트필드 위치와 크기
            searchTextField.setColumns(10);               // 검색어 길이 설정
            panelTop.add(searchTextField);               // 상단 패널에 붙이기

            searchTextField.addKeyListener(new KeyAdapter() { // 검색어 입력 텍스트필드 이벤트
                public void keyReleased(KeyEvent e) {
                    String val = searchTextField.getText();
                    TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
                    table.setRowSorter(trs);
                    trs.setRowFilter(RowFilter.regexFilter(val));
                }
            });

            tablePanel = new JPanel();            // 테이블 패널 생성
            tablePanel.setBounds(20, 50, 972, 268); // 테이블 패널 위치와 크기
            frame.getContentPane().add(tablePanel); // 테이블 패널 추가
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

        /** UI테이블 설정
         *
         */

        public void showTable() {
            ManageCustomer customer = new ManageCustomer();
            data = customer.getReservations();

            String[] header = new String[]{"예약번호", "이름", "전화번호", "호실", "고객번호"};

           tableModel = new DefaultTableModel(data, header);


           table = new JTable(tableModel) {                    // 셀에서 편집할 수 없게 함.
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

            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //행을 하나만 선택할 수 있도록

            // 컬럼 크기
            TableColumnModel colModel = table.getColumnModel();
            colModel.getColumn(0).setPreferredWidth(15);
            colModel.getColumn(1).setPreferredWidth(30);
            colModel.getColumn(2).setPreferredWidth(100);
            colModel.getColumn(3).setPreferredWidth(300);

            table.getTableHeader().setFont(new Font("NanumGothic", Font.BOLD, 13));  // header 폰트 설정
            table.getTableHeader().setPreferredSize(new Dimension(100, 30));		// header 넓이, 높이
            table.setFont(new Font("NanumGothic", Font.PLAIN, 13));                 // 셀 폰트, 크기
            table.setRowHeight(30);
//		table.setAlignmentX(0);

            // 테이블에 스크롤바 추가
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(975, 255));
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));	// padding(상, 좌, 하, 우)
            tablePanel.add(scrollPane); // JScrollPane을 panelTop에 바로 올리면 안 보임. 전용 tablePanel에 올려야 보임

        }

        /**
         *  UI테이블에 행 추가
         */
        public void addTableRow() {
            btnInsert.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelBottom.setVisible(true);
                }
            });
        }

        /**
         *  UI테이블에서 선택한 행의 고객번호(id) 가져오기
         */
        public String getCustomerId(int seledtedIdx) {
            String selectedId = (String) table.getValueAt(seledtedIdx, 0);  // 인덱스 행의 첫번째 컬럼값 반환
            return selectedId;
        }

        /**
         *  UI테이블에서 선택한 행 삭제
         */
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



        public void updateTableRow() {
            btnUpdate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selectedIdx = table.getSelectedRow();    // 선택한 행이 없으면 -1 반환
                    if( selectedIdx == -1) {
                        JOptionPane.showMessageDialog(null, "테이블에서 변경할 행을 선택하세요.");
                    } else {
                        nameTextfield.setText((String)table.getValueAt(selectedIdx, 1));
                        telTextfield.setText((String)table.getValueAt(selectedIdx, 2));
                        roomNumTextfield.setText((String)table.getValueAt(selectedIdx, 3));


                        panelBottom.setVisible(true);

                        String[] inputList = new String[4];
                        inputList[0] = nameTextfield.getText();
                        inputList[1] = telTextfield.getText();
                        inputList[2] = roomNumTextfield.getText();
                        inputList[3] = guestNumTextfield.getText();

                        customer.updateReservation(selectedIdx,inputList[0],inputList[0],inputList[0],inputList[0]);
                        // 테이블에서 다른 곳을 선택할 수 없도록 설정

                    }
                }
            });
        }


        /**
         * 텍스트 필드에 값을 입력했는지 여부 검사
         */
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




        /**
         * UI테이블에 저장
         */
        public void saveData() {
            ManageCustomer customer = new ManageCustomer();
            btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String[] inputList = new String[4];
                    inputList[0] = nameTextfield.getText();
                    inputList[1] = telTextfield.getText();
                    inputList[2] = roomNumTextfield.getText();
                    inputList[3] = guestNumTextfield.getText();



                    boolean valid = isValid(inputList);  // 데이터가 모두 입력되었는지 검사

                    // 데이터베이스에 추가 (고객번호 필드는 비어있고 다른 필드는 모두 값이 입력됨)
                    if (valid ) {

                        // 데이터베이스에 고객정보 추가하고 id 가져오기
                        int id = customer.createReservation(inputList[0], inputList[1], inputList[2], inputList[3]);

                        if (id != -1) {
                            String[] newRow = { Integer.toString(id), inputList[0], inputList[1], inputList[2], inputList[3]};

                            tableModel.addRow(newRow);			// UI 테이블에 행 추가

                            JOptionPane.showMessageDialog(null, "고객 정보가 추가되었습니다");

                            tableModel.fireTableDataChanged();  // UI 테이블 정보 갱신
                        }
                        table.setVisible(true);
                        panelBottom.setVisible(false);          // 하단 패널 가리기

                        // 데이터베이스 변경 (고객번호 필드에 값이 있으면 변경 처리)
                    }



                }
            });
        }

        /**
         * 취소 버튼 설정
         */
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




