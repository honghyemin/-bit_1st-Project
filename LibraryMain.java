package kr.co.bit.library.main;

import java.util.Scanner; 

import kr.co.bit.library.book.main.dao.BookTest;
import kr.co.bit.library.login.main.dao.LoginDAO;
import kr.co.bit.library.login.main.dao.LoginTest;
import kr.co.bit.library.main.dto.MemberDTO;




public class LibraryMain {
	
	

	public static void main(String[] args) {

		LoginTest loginTest = new LoginTest();
		BookTest bookTest = new BookTest();
		MemberDTO dto = new MemberDTO();
		LoginDAO dao = new LoginDAO();

		Scanner sc = new Scanner(System.in);
		
		
		while (true) {

			System.out.println("------------------------------------");
			System.out.println("|             비트 도서관             |");
			System.out.println("|__________________________________|");
			System.out.println("| >>> 1. 도서 검색                    |");
			System.out.println("| >>> 2. 열람실 입장                  |");
			System.out.println("| >>> 3. 로그인                      |");
			System.out.println("| >>> 4. 관리자 로그인                 |");
			System.out.println("| >>> 5. 종료                        |");
			System.out.println("|___________________________________|");
			System.out.println("id:" + SaveID.myId);
			System.out.println(" 원하시는 목록을 선택해주세요 ");
			System.out.print("▶");

//			try {
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					// 도서검색 메서드
					bookTest.BookMain();
				case 2:
					// 열람실 메서드
				case 3:
					loginTest.LoginView();
				case 4:
					// 관리자로그인 메서드
				case 5:
					System.out.println("프로그램이 곧 종료됩니다.");
					try {
						Thread.sleep(1000);
						System.out.println("...3...");
						Thread.sleep(1000);
						System.out.println("...2...");
						Thread.sleep(1000);
						System.out.println("...1...");
						System.exit(choice);
					} catch (Exception e) {
						break;
					}

				}
//			} catch (Exception e) {
//				System.out.println("숫자를 입력해주세요!!");
//				System.out.println("메인화면으로 이동합니다.");
//				LibraryMain.main(null);
//				break;
//			} 

		}
	}

}
