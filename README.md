# 호텔 객실관리 프로그램
### 프로젝트 설명
  호텔에서 사용하는 프로그램으로 사용자는 고객이 아닌 관리자로 지정 하였으며, 관리자 회원가입, 로그인, 예약, 체크인, 체크아웃기능 등 호텔의 전반적인 시스템을 조율하는 프로그램입니다.
이 주제를 선정 한 이유는 객체지향 프로그래밍 언어인 자바 언어를 기반으로 객체지향의 특성이 잘 나타날 수 있으며, 외부시스템의 비중이 작다고 생각했습니다. 또한 클래스의 개수가 10개 내외인 주제를 브레인스토밍 했으며, 팀원 간의 투표를 통해 호텔 객실관리 프로그램으로 선정하게 되었습니다.

### 참고 소스코드 및 수정,추가 사항
https://github.com/ShefaliDigikar/Hotel-Management-System-Java
<br></br>
체크인, 체크아웃 상태를 구분이 없어서 상태를 구분하도록 데이터베이스를 생성하였고 기존의 기능에서 수정 및 추가 한 사항은 다음과 같습니다.
1.	체크인 기능(수정)
기존의 소스코드에서는 영수증 발행 기능을 진행하면 체크인이 되었다고 가정하도록 설계되어 있었습니다. 체크인 버튼을 생성하여 체크인 기능 실행 시에 보조 기능으로 영수증이 발행되도록 수정하였습니다.

2.	예약 기능 (추가)
객실 예약 기능이 없어서 해당 객실을 예약하는 기능을 추가하였습니다.

3.	방 상태에 따른 정보 표시 (추가)
해당 객실의 공실/체크인/예약 상태에 따른 정보를 표시하는 기능을 추가하였습니다. 공실일 경우에는 공실이라는 메시지를 표시하고, 체크인/예약인 경우에는 해당 고객의 이름과 전화번호, 그리고 체크인 상태인지 예약상태인지 메시지를 표시합니다.

### LRC
![image](https://github.com/user-attachments/assets/f76b0dba-ae52-4c1d-9955-011b831320ae)
![image](https://github.com/user-attachments/assets/54212608-c5f7-40d5-bb93-8d93aa59fa50)

### Usecase Diagram
![image](https://github.com/user-attachments/assets/c7037d8c-7824-499b-9b21-48bf88128452)

### Class Diagram
![image](https://github.com/user-attachments/assets/4558f236-8ac1-4c54-988a-9ff39e256cca)

### Communication Diagram
1.	로그인
![image](https://github.com/user-attachments/assets/ffd22e16-1abd-41d7-a955-df3fec2188a4)
2.	사용자 등록
![image](https://github.com/user-attachments/assets/c4def41e-64c2-4750-b743-31a29db8b00b)
3.	객실 예약
![image](https://github.com/user-attachments/assets/26336372-e030-480c-82c3-23ce969703da)
4.	체크아웃
![image](https://github.com/user-attachments/assets/499a54ef-0714-437a-a1a2-3970f03a748b)
5.	체크인
![image](https://github.com/user-attachments/assets/cd28bbec-49cf-4e16-aad4-6d99d5ff819f)
6.	객실 예약 취소
![image](https://github.com/user-attachments/assets/f158b510-388f-4dea-a3a1-dbc378fd6326)
7.	객실 종류 추가 커뮤니케이션
![image](https://github.com/user-attachments/assets/66a2e429-1bc5-4151-83a2-a3697a326c38)
8.	객실 종류 삭제 커뮤니케이션
![image](https://github.com/user-attachments/assets/16380266-4028-4403-b853-2463894d3ca5)
9.	객실 종류 변경 커뮤니케이션
![image](https://github.com/user-attachments/assets/d2fb3243-e072-4402-89c5-334965a47fa3)
10.	 객실 고객 정보 조회
![image](https://github.com/user-attachments/assets/9cf5da4b-b7fc-4900-a470-925bc50c48ee)
11.	 객실 예약 변경
![image](https://github.com/user-attachments/assets/bef44870-f53f-4026-84b1-a0d87507de6a)
12.	객실 예약 정보 조회
![image](https://github.com/user-attachments/assets/6ddbaacc-721a-4991-aa00-ed58eacfc51e)

### Sequence Diagram
1.	로그인
![image](https://github.com/user-attachments/assets/6b9fc549-596f-470b-96b6-7c31a812b8e1)
2.	사용자 등록
![image](https://github.com/user-attachments/assets/a2c046f0-4b72-4b4b-9c63-e2b9ccfeb95f)
3.	객실 예약
![image](https://github.com/user-attachments/assets/b4ccdf9b-5130-4e19-b370-41de24299f7d)
4.	체크아웃
![image](https://github.com/user-attachments/assets/a8329d8d-3c23-42a7-b168-d00903eef7fe)
5.	체크인
![image](https://github.com/user-attachments/assets/ddaecc2f-bf21-4537-9336-d1142bc8497b)
6.	객실 예약 취소
![image](https://github.com/user-attachments/assets/766befd9-8c34-4203-a7b6-ca0bfd5be735)
7.	객실 종류 추가 커뮤니케이션
![image](https://github.com/user-attachments/assets/4724782d-368e-47d2-9fe2-8a1bb5b85574)
8.	객실 종류 삭제 커뮤니케이션
![image](https://github.com/user-attachments/assets/a885ca7e-b969-4bdd-bdb7-9d6b437953e6)
9.	객실 종류 변경 커뮤니케이션
![image](https://github.com/user-attachments/assets/c8b84dcd-b91e-4534-9df9-30ce9cf9bedb)
10.	 객실 고객 정보 조회
![image](https://github.com/user-attachments/assets/f47941d3-37af-479b-af95-2ce94f6f4cc2)
11.	 객실 예약 변경
![image](https://github.com/user-attachments/assets/89bb31e4-3568-4fc5-9ede-ccf5bf145b7c)
12.	 객실 예약 정보 조회
![image](https://github.com/user-attachments/assets/44a04a6e-b9b6-4a4f-9f51-c92c868a272b)
<br></br>
뷰 -> 컨트롤러 -> 모델 -> DB연결 모델 ->컨트롤러 ->뷰 -> 사용자
이 방식으로 모든 시퀀스/커뮤니케이션 다이어그램 구성(메시지 전달되는 모델 개수는 조금씩 달라질 수는 있지만, 이게 원칙)

### Statechart Diagram
![image](https://github.com/user-attachments/assets/8fdd4567-26c0-49db-8adf-920d3e162530)
상태는 아래 3가지로 정의했습니다
Vacant(공실), Checked In(체크인 된), Reserved(예약 된)
이 3가지 상태에서 서로 왔다 갔다 하는데 체크인에서 예약 상태로는 못 가도록 했습니다.
각 상태 전이가 일어날 때, 이벤트와 액션을 기술했으며, 액션은 모두 DB에 정보 전달로 통일했습니다..

### Activity Diagram
1.	로그인/사용자등록
![image](https://github.com/user-attachments/assets/01a53f88-cbcb-4185-9277-6f23ae4b104c)
<br></br>
2.	방상태조회/체크인/체크아웃
![image](https://github.com/user-attachments/assets/3bb2e77b-ce13-43a3-8490-77665b4b2fbb)
<br></br>
3.	객실예약관리(객실 예약, 예약 취소, 예약 변경)
![image](https://github.com/user-attachments/assets/b39d2241-5236-417a-b567-f6851e392b87)
<br></br>
4.	객실종류관리(객실 종류 추가, 삭제, 변경)
![image](https://github.com/user-attachments/assets/204f7b73-fc35-4a10-8858-ada4e108ef86)
<br></br>
유스케이스 별로 작성이 원칙이지만, 비슷한 기능들의 다이어그램을 위의 4부류로 통합해서 작성했습니다.

### 실행결과 화면 및 설명
1. 방을 추가하고 삭제하는 기능
![image](https://github.com/user-attachments/assets/06dcb804-93bb-4a7c-bbdf-866daa32c751)
<br></br>
위의 사진은 호텔에서 방의 개수가 늘어나거나 줄었을 때 또는 방의 종류를 변경하고자 할 때 사용할 수 있는 기능입니다. 

2. 체크인과 체크아웃 관리 기능
![image](https://github.com/user-attachments/assets/0bf8b7a8-3df6-4b11-bc76-ccac5bf837b7)
<br></br>
위 페이지는 체크인 체크아웃을 관리하는 기능으로 각각 정보들을 기입하고 버튼을 누르면 기능이 수행됩니다. 또한 정보를 기입할 때 가운데에 있는 테이블의 항목을 선택하면 그 항목들은 자동적으로 텍스트 필드에 기입이 됩니다.

3. 방의 상태 확인
![image](https://github.com/user-attachments/assets/bf12af64-c37e-4da1-91a4-453bd3f21fcf)
<br></br>
위의 사진과 같이 가운데의 테이블에서 항목을 선택 후에 check Room 버튼을 클릭하면 오른쪽 필드에 방의 상태가 확인 됩니다.

4. 체크아웃 시 영수증 출력
![image](https://github.com/user-attachments/assets/7192e236-b98d-4047-b989-cf0eddcb80cf)
<br></br>
체크아웃이 진행되면 오른쪽과 같이 영수증이 출력되는 것을 볼 수 있습니다.

5. 예약 관리 테이블
![image](https://github.com/user-attachments/assets/c02488b0-9e62-4ee8-9b92-0ff2309dacc1)
<br></br>
위의 그림은 예약 관리 테이블의 초기 화면입니다.
![image](https://github.com/user-attachments/assets/b1cf7c07-78be-4704-ab41-25f564d19e45)
<br></br>
이 화면은 예약 추가를 위한 화면으로 예약 추가 시에는 텍스트 필드가 빈 칸으로 나오고 텍스트 필드를 모두 채우고 우측의 저장 버튼을 클릭하면 예약이 추가 됩니다. 다음은 예약 정보가 추가 된 테이블의 모습니다.
![image](https://github.com/user-attachments/assets/b7babda8-0368-4896-a7f6-0c2a407a5184)
<br></br>
변경에 대한 화면은 추가와 같은 텍스트 필드로 되어 있지만 다른 점으로 텍스트 필드가 테이블에서 선택된 항목과 동일하게 채워집니다.
![image](https://github.com/user-attachments/assets/1f7bf45d-75d9-443e-8b2f-404bbbae201e)
<br></br>
테이블 정보 항목 삭제는 변경과 동일하게 항목을 클릭하여 선택하고 삭제 버튼을 눌러 진행됩니다.
![image](https://github.com/user-attachments/assets/58638a6e-e8cf-4100-bc1e-e832b9b03978)
<br></br>
마지막으로 검색 기능입니다. 이와 같이 2개 이상의 데이터가 항목에 표시될 경우 화면 상단의 검색 텍스트 필드에 키워드를 입력하면 다음과 같이 키워드에 해당되는 데이터들만 테이블에 출력이 됩니다.
![image](https://github.com/user-attachments/assets/8e9897b9-d69e-43df-9de1-323c57e4459c)
<br></br>
