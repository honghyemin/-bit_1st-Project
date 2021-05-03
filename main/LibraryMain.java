package kr.co.bit.library.main;

import java.util.Scanner; 

import kr.co.bit.library.book.main.dao.BookTest;
import kr.co.bit.library.insert.login.dao.InsertLoginTest;
import kr.co.bit.library.login.main.dao.LoginTest;

public class LibraryMain {

	public static void main(String[] args) {

		LoginTest loginTest = new LoginTest();
		BookTest bookTest = new BookTest();
		Scanner sc = new Scanner(System.in);
		InsertLoginTest insertLoginTest = new InsertLoginTest();

		while (true) {

			System.out.println("----------------------------------");
			System.out.println("             비트 도서관             ");
			System.out.println("__________________________________");
			System.out.println(" >>> 1. 도서 대출/반납               ");
			System.out.println(" >>> 2. 열람실 입장                  ");
			if(SaveID.myId!=null) {
				System.out.println(" >>> 3. 내정보                      ");
			} else {
			System.out.println(" >>> 3. 로그인                      ");
			}
			System.out.println(" >>> 4. 관리자 로그인                 ");
			System.out.println(" >>> 5. 종료                        ");
			System.out.println("__________________________________");
			// 현재 접속자?? 
			if(SaveID.myId!=null) {
				System.out.println("			사용자:" + SaveID.myId);
			} else {
				System.out.println("			사용자:" + " ");
			}
//			
			System.out.println("■ 원하시는 목록을 선택해주세요 ");
			System.out.print(">>>");
			String choice = sc.next();

			switch (choice) {
			case "1":
				// 도서검색 메서드
				bookTest.BookMain();
			case "2":
				// 열람실 메서드
			case "3":
				if(SaveID.myId!=null) {
					insertLoginTest.InsertLoginView();
				} else {
				loginTest.LoginView();
				}
			case "4":
				// 관리자로그인 메서드
			case "5":
				System.out.println("프로그램이 곧 종료됩니다.");
				try {
					Thread.sleep(1000);
					System.out.println("...3...");
					Thread.sleep(1000);
					System.out.println("...2...");
					Thread.sleep(1000);
					System.out.println("...1...");
					System.exit(0);;
				} catch (Exception e) {
					break;
				}

			default:
				System.out.println("잘못 입력했습니다. 다시 입력해주세요.");

			}
		}
	}

}
