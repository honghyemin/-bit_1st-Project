package kr.co.bit.library.login.main.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.co.bit.library.common.util.JDBC_Close;
import kr.co.bit.library.main.dto.MemberDTO;

public class LoginDAO {
	Scanner sc = new Scanner(System.in);

	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@192.168.0.11:1521:xe";
	private final String USER = "BIT_LIBRARY";
	private final String PASSWORD = "library";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public LoginDAO() {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	public String ididid(String id) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT ID FROM MEMBER WHERE ID = ? ");
			pstmt = conn.prepareStatement(sb.toString());
		
			pstmt.setString(1,id );
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(id);
			} else {
				id = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return id;
	}
	


	// 회원가입
	public int insertMember(MemberDTO member) {

		int memberCount = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO MEMBER ");
			sb.append(" (ID, PASSWORD, NAME, ADDRESS, PHONE, HINT) ");
			sb.append(" VALUES(?, ?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getHint());

			memberCount = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}
		return memberCount;

	}

	// 로그인

	// 아이디, 비밀번호 찾기
	// 아이디 찾기 - 핸드폰번호 확인
	public String checkPhone(String phone) {

		String id = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT ID FROM MEMBER WHERE PHONE = ? ");

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, phone);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				id = rs.getString("id");
				
			} else {
				id = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}

		return id;
	}
	
	// 아이디 찾기 - 힌트로 찾기
	public String checkHint(String hint) {

		String id = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT ID FROM MEMBER WHERE HINT = ? ");

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, hint);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				id = rs.getString("id");
				
			} else {
				id = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}

		return id;
	}
	
	// 비밀번호 찾기 - 핸드폰번호로 찾기
	public String checkPhone2(String phone) {

		String password = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT PASSWORD FROM MEMBER WHERE PHONE = ? ");

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, phone);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				password = rs.getString("password");
			} else {
				password = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}

		return password;
	}
	
	// 비밀번호 찾기 -  힌트로 찾기(ID)
		public String checkHint2(String hint) {

			String pw = null;

			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT PASSWORD FROM MEMBER WHERE HINT = ? ");

				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, hint);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					pw = rs.getString("password");
					
				} else {
					pw = null;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
			}

			return pw;
		}


	// 아이디 존재여부 확인
	public boolean checkId(String id) {

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT ID FROM MEMBER ");

			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("id").equals(id)) {
					return true;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		return false;

	}

	// 비밀번호 일치 확인
	public boolean checkPw(String id, String pw) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT PASSWORD FROM MEMBER WHERE ID = ? ");

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("password").equals(pw)) {
					return true;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}

		return false;
	}

}
