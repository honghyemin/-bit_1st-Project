package kr.co.bit.library.insert.login.dao;

import java.util.Scanner; 


import kr.co.bit.library.book.main.dao.BookTest;
import kr.co.bit.library.main.LibraryMain;
import kr.co.bit.library.main.SaveID;
import kr.co.bit.library.main.dto.MemberDTO;

public class InsertLoginTest {
// 로그인 접속 후 메인화면
	String id = SaveID.myId;
	Scanner sc = new Scanner(System.in);
	InsertLoginDAO insertLoginDAO = new InsertLoginDAO();
	BookTest btest = new BookTest();

	public void InsertLoginView() {

		while (true) {
			System.out.println("----------------------------------");
			System.out.println("1. 도서 열람/대출/반납            ");
			System.out.println("2. 열람실 이용               ");
			System.out.println("3. 마이페이지                ");
			System.out.println("4. 로그아웃                 ");
			System.out.println("5. 뒤로 가기               ");
			System.out.println("----------------------------------");
			System.out.print(">>> ");
			
			String choice = sc.next();

			switch (choice) {

			case "1":
				btest.BookMain();
				break;
			case "2":

				break;
			case "3":
				Mypage();
				break;
			case "4":
				// 로그아웃
				System.out.println("정말 로그아웃 하시겠습니까?");
				System.out.print("(Y/N) :");
				char logout = sc.next().toUpperCase().charAt(0);
				if (logout == 'Y') {
					System.out.println("메인화면으로 이동합니다.");
					SaveID.myId = null;
					try {
						Thread.sleep(1000);
						LibraryMain.main(null);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else if (logout == 'N') {
					InsertLoginView();
				} else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					InsertLoginView();
				}
				
			case "5" :
				// 로그인 유지 상태
				LibraryMain.main(null);
			default : 
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				InsertLoginView();
			}

		}
	}

	// 3. 마이페이지 메서드
	public void Mypage() {

		System.out.println("----------------------------------");
		System.out.println("         < MY PAGE >         ");
		System.out.println("1. 내 정보                    ");
		System.out.println("2. 대출 내역 조회                ");
		System.out.println("3. 열람실 예약 내역 조회           ");
		System.out.println("4. 뒤로가기         ");
		System.out.println("----------------------------------");
		System.out.println(">>> ");
		String choice = sc.next();

		switch (choice) {

		case "1":
			String id = SaveID.myId;
			MemberDTO mdto = insertLoginDAO.MyInfo(id);
			System.out.println("______[ 내 정보 ]______");
			System.out.println("아이디 : " + mdto.getId());
			System.out.println("비밀번호 : " + mdto.getPassword());
			System.out.println("이름 : " + mdto.getName());
			System.out.println("주소 : " + mdto.getAddress());
			System.out.println("핸드폰번호 : " + mdto.getPhone());
			System.out.println();

			try {
				Thread.sleep(1500);
				System.out.println("정보를 수정하겠습니까? ");
				System.out.print("(Y/N) : ");
				char modify = sc.next().toUpperCase().charAt(0);

				if (modify == 'Y') {

					System.out.println("____[ 내 정보 수정 ]____");
					System.out.println("1. 비밀번호 수정         ");
					System.out.println("2. 이름 수정        ");
					System.out.println("3. 주소 수정                ");
					System.out.println("4. 핸드폰번호 수정         ");
					System.out.println("5. 뒤로 가기         ");
					System.out.println("______________________");
					int modifyMp = sc.nextInt();

					if (modifyMp == 1) {
						modifyPassword();
						break;
					} else if (modifyMp == 2) {
						modifyName();
						break;
					} else if (modifyMp == 3) {
						modifyAddress();
						break;
					} else if (modifyMp == 4) {
						modifyPhone();
						break;
					} else if (modifyMp == 5) {
						Mypage();
						break;
					}
				} else if(modify == 'N') {
					Mypage();
				} else {
					System.out.println("잘못입력했습니다. 다시 입력해주세요.");
				}
				

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case "2":
			// 대출 내역 조회
			BookTest bookTest = new BookTest();
			bookTest.InfoRentalBook();
			break;
		case "3":
			// 열람실 예약 내역 조회
			break;
		}

	}

	// 3-1. 비밀번호 변경
	public void modifyPassword() {
		MemberDTO memberDTO = new MemberDTO();
		String id = SaveID.myId;
		System.out.println("변경할 비밀번호를 입력해주세요.");
		System.out.print(">>> ");
		String password = sc.next();

		memberDTO = new MemberDTO(id, password, "", "", "", "");

		System.out.println("비밀번호가 " + password + "로 변경이 완료되었습니다!");
		insertLoginDAO.modifyPw(memberDTO);

	}

	// 3-2.이름 변경
	public void modifyName() {
		MemberDTO memberDTO = new MemberDTO();
		String id = SaveID.myId;
		System.out.println("변경할 성함을 입력해주세요.");
		System.out.print(">>> ");
		String name = sc.next();

		memberDTO = new MemberDTO(id, "", name, "", "", "");

		System.out.println("성함이 " + name + "로 변경이 완료되었습니다!");
		insertLoginDAO.modifyN(memberDTO);

	}

	// 3-3. 주소변경
	public void modifyAddress() {
		MemberDTO memberDTO = new MemberDTO();
		String id = SaveID.myId;
		System.out.println("변경할 주소를 입력해주세요.");
		System.out.print(">>> ");
		String address = sc.next();

		memberDTO = new MemberDTO(id,"" , "", "", address, "");

		System.out.println("주소가 " + address + "로 변경이 완료되었습니다!");
		insertLoginDAO.modifyAd(memberDTO);

	}

	// 3-4. 폰번호변경
	public void modifyPhone() {
		MemberDTO memberDTO = new MemberDTO();
		String id = SaveID.myId;
		System.out.println("변경할 휴대폰번호를 입력해주세요.");
		System.out.print(">>> ");
		String phone = sc.next();

		memberDTO = new MemberDTO(id,  "", "", "", "",phone);

		System.out.println("주소가 " + phone + "로 변경이 완료되었습니다!");
		insertLoginDAO.modifyPh(memberDTO);

	}

}