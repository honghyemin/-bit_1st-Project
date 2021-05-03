package kr.co.bit.library.login.main.dao;

import java.util.Scanner;

import kr.co.bit.library.insert.login.dao.InsertLoginTest;
import kr.co.bit.library.main.LibraryMain;
import kr.co.bit.library.main.SaveID;
import kr.co.bit.library.main.dto.MemberDTO;
// 로그인화면 메인

public class LoginTest {
	Scanner sc = new Scanner(System.in);
	LoginDAO login = new LoginDAO();

	public void LoginView() {

		while (true) {
			System.out.println("----------------------------------");
			System.out.println("             비트 도서관             ");
			System.out.println("__________________________________");
			System.out.println(" >>> 1. 로그인하기                   ");
			System.out.println(" >>> 2. 회원가입                     ");
			System.out.println(" >>> 3. 아이디 찾기                  ");
			System.out.println(" >>> 4. 비밀번호 찾기                 ");
			System.out.println(" >>> 5. 뒤로가기                     ");
			System.out.println("__________________________________");
			System.out.println(" 원하시는 목록을 선택해주세요 ");
			System.out.print(">>> ");
			String choice = sc.next();

			switch(choice) {
			
			case "1": 
			// 로그인 화면 메서드(아이디,패스워드 입력창)
				LoginMethod();
				break;
			case "2":
			// 회원가입
				JoinMethod();
				break;
			case "3":
			// 아이디찾기 메서드
				searchId();	
				break;
			case "4":
			// 비밀번호찾기 메서드
				searchPw();	
				break;
			case "5":
				LibraryMain.main(null);
			
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
			
		}

	}

	// 1. 로그인하기 메서드(메인에서)
	public Boolean LoginMethod() {
		int count = 0;
		LoginDAO login = new LoginDAO();
		InsertLoginTest ilt = new InsertLoginTest();

		while (true) {
			System.out.print("ID : ");
			String id = sc.next();
			System.out.println();
			System.out.print("PASSWORD : ");
			String pw = sc.next();

			if (login.checkId(id)) {
				SaveID.myId = id;
				if (login.checkPw(id, pw)) {
					System.out.println("[" + id + "]님이 로그인 하셨습니다.");
					ilt.InsertLoginView();
					try {
						Thread.sleep(1000);
						LibraryMain.main(null);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println();
				} else if (login.checkPw(id, pw) == false) {
					count++;
					System.out.println("비밀번호가 맞지 않습니다. 다시 입력해주세요.");
					System.out.println();

				}

			} else if ((login.checkId(id) != true)) {
				count++;
				System.out.println("아이디를 확인해주세요.");
				System.out.println();

			}
			if (count == 5) {
				System.out.println("입력 횟수를 초과하였습니다. 아이디/비밀번호 찾기 화면으로 이동합니다.");
				LoginView();
			}

		}

	}

	// 1-2. 로그인하기 메서드 - 도서관으로 이동
		public Boolean LoginMethod2() { 
			int count = 0;
			LoginDAO login = new LoginDAO();
			InsertLoginTest ilt = new InsertLoginTest();

			while (true) {
				System.out.print("ID : ");
				String id = sc.next();
				System.out.println();
				System.out.print("PASSWORD : ");
				String pw = sc.next();

				if (login.checkId(id)) {
					SaveID.myId = id;
					if (login.checkPw(id, pw)) {
						System.out.println("["+id + "]님이 로그인 하셨습니다.");
						try {
							Thread.sleep(1000);
							LibraryMain.main(null);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						System.out.println();
					} else if (login.checkPw(id, pw) == false) {
						count++;
						System.out.println("비밀번호가 맞지 않습니다. 다시 입력해주세요.");
						System.out.println();

					}
					
				} else if ((login.checkId(id) != true)) {
					count++;
					System.out.println("아이디를 확인해주세요.");
					System.out.println();

				}
				if (count == 5) {
					System.out.println("입력 횟수를 초과하였습니다. 아이디/비밀번호 찾기 화면으로 이동합니다.");
					LoginView();
				}
				
				
			}
			
		}

	// 2. 회원가입 메서드
	public void JoinMethod() {

		sc = new Scanner(System.in);
		LoginDAO join = new LoginDAO();

		while (true) {

			System.out.print("회원가입을 진행하시겠습니까? (Y/N) ▶");
			char joinSelect = sc.next().toUpperCase().charAt(0);

			if (joinSelect == 'Y') {

				while (true) {

					System.out.println("----------------------------------");
					System.out.print("ID : ");
					String id = sc.next();

					// 중복된 아이디가 있을 경우 경고문구
					while (join.checkId(id)) {
						System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
						System.out.print("ID : ");
						id = sc.next();
					}

					System.out.print("PASSWORD : ");
					String pw = sc.next();
					System.out.print("이름 : ");
					String name = sc.next();
					System.out.print("주소 : ");
					String address = sc.next();
					System.out.print("핸드폰 : ");
					String phone = sc.next();
					System.out.println("[ 아이디/비밀번호 찾기 시 사용할 질문입니다 ]");
					System.out.print("당신의 고향은 어디입니까? : ");
					String hint = sc.next();

					MemberDTO memberDTO = new MemberDTO(id, pw, name, address, phone, hint);
					join.insertMember(memberDTO);
					System.out.println("회원가입을 축하드립니다! 메인화면으로 이동합니다.");
					try {
						Thread.sleep(1000);
						LibraryMain.main(null);

					} catch (InterruptedException e) {
						break;
					}

				}
			} else if (joinSelect == 'N') {
				LoginView();

			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");

			}
		}
	}

	// 3. 아이디찾기 메서드
	public void searchId() {
		LoginDAO login = new LoginDAO();

		while (true) {
			System.out.println("아이디를 찾으시겠습니까?");
			System.out.print("Y/N : ");
			char choiceId = sc.next().toUpperCase().charAt(0);

			if (choiceId == 'Y') {
				System.out.println("----------------------------------");
				System.out.println("      아이디 찾기 방법       ");
				System.out.println("----------------------------------");
				System.out.println("1. 전화번호로 찾기           ");
				System.out.println("2. 힌트로 찾기              ");
				System.out.println("----------------------------------");

				System.out.print(">>>");
				String sId = sc.next();

				switch (sId) {

				case "1":
					System.out.println("전화번호를 입력해주세요");
					System.out.print(">>");
					String phone = sc.next();
					String id = login.checkPhone(phone);
					// 번호가 일치하면 아이디 확인
					if (login.checkPhone(phone) != null) {
						System.out.println("당신의 아이디는 '" + id + "' 입니다.");
						System.out.println(" 로그인 창으로 이동합니다. ");
						try {
							Thread.sleep(1000);
							LoginView();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					} else {
						System.out.println("일치하는 정보가 없습니다. 다시 확인해주세요.");
					}
					break;
				case "2":
					System.out.println("당신의 고향은 어디입니까?");
					String hint = sc.next();
					id = login.checkHint(hint);
					if (login.checkHint(hint) != null) {
						System.out.println("당신의 아이디는 '" + id + "' 입니다.");
						System.out.println(" 로그인 창으로 이동합니다. ");
						try {
							Thread.sleep(1000);
							LoginView();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					} else {
						System.out.println("일치하는 정보가 없습니다. 다시 확인해주세요.");
					}
					break;

				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				}

			} else if (choiceId == 'N') {
				LoginView();
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.println();

			}

		}

	}

	// 4. 비밀번호찾기 메서드
	public void searchPw() {

		System.out.println("비밀번호를 찾으시겠습니까?");
		System.out.println("Y/N : ");
		char choiceId = sc.next().toUpperCase().charAt(0);

		// 먼저 아이디를 입력받은 후 존재하는 아이디면 핸드폰번호 or 힌트의 답을 입력받고 비밀번호 출력

		if (choiceId == 'Y') {
			System.out.print("아이디를 입력해주세요. : ");
			String id = sc.next();

			if (login.checkId(id)) {
				System.out.println("아이디가 일치합니다.");
				System.out.println("----------------------------------");
				System.out.println("비밀번호 찾기 방법을 선택해주세요. ");
				System.out.println("----------------------------------");
				System.out.println("1. 전화번호로 찾기           ");
				System.out.println("2. 힌트로 찾기              ");
				System.out.println("----------------------------------");
				System.out.print(">>>");
				String sPw = sc.next();

				switch (sPw) {

				case "1":
					System.out.println("전화번호를 입력해주세요");
					System.out.print(">>");
					String phone = sc.next();
					String pw = login.checkPhone2(phone);

					if (login.checkPhone2(phone) != null) {
						System.out.println("당신의 비밀번호는 '" + pw + "' 입니다.");
						System.out.println("로그인 창으로 이동합니다. ");
						try {
							Thread.sleep(1000);
							LoginView();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					} else {
						System.out.println("번호가 일치하지 않습니다. 다시 확인해주세요.");
					}

				case "2":
					// 힌트로 찾기.
					System.out.println("당신의 고향은 어디입니까?");
					String hint = sc.next();
					pw = login.checkHint2(hint);
					if (login.checkHint2(hint) != null) {
						System.out.println("당신의 비밀번호는 '" + pw + "' 입니다.");
						System.out.println("로그인 창으로 이동합니다. ");
						try {
							Thread.sleep(1000);
							LoginView();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					} else {
						System.out.println("일치하는 정보가 없습니다. 다시 확인해주세요.");
					}
				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");

				}

			} else {
				System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
			}

		} else if (choiceId == 'N') {
			LoginView();
		} else {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		}

	}

}
