package kr.co.bit.library.insert.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.bit.library.common.util.JDBC_Close;
import kr.co.bit.library.main.dto.MemberDTO;

public class InsertLoginDAO {

	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@192.168.0.11:1521:xe";
	private final String USER = "BIT_LIBRARY";
	private final String PASSWORD = "library";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public InsertLoginDAO() {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	// 내정보 확인
	public MemberDTO MyInfo(String id) {
		MemberDTO mdto = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT ID, PASSWORD, NAME, ADDRESS, PHONE, HINT ");
			sb.append(" FROM MEMBER ");
			sb.append(" WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdto = new MemberDTO(rs.getString("ID"),
										 rs.getString("PASSWORD"),
										 rs.getString("NAME"),
										 rs.getString("ADDRESS"),
										 rs.getString("PHONE"),
										 rs.getString("HINT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}

		
		return mdto;
	}
	
	// 내정보 수정 - 1. 비밀번호
	public int modifyPw(MemberDTO memberDTO) {

		// List<MemberDTO> mdtoo = new ArrayList<>();
		// HashMap<String, String> map = new HashMap<>();

		int result = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" UPDATE MEMBER ");
			sb.append(" SET PASSWORD = ? ");
			sb.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, memberDTO.getPassword());
			pstmt.setString(2, memberDTO.getId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}

		return result;

	}

	// 내정보 수정 - 2.이름
	public int modifyN(MemberDTO memberDTO) {
		int result = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" UPDATE MEMBER ");
			sb.append(" SET NAME= ? ");
			sb.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}

		return result;

	}

	// 내정보 수정 - 3. 주소
	public int modifyAd(MemberDTO memberDTO) {
		int result = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" UPDATE MEMBER ");
			sb.append(" SET ADDRESS= ? ");
			sb.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, memberDTO.getAddress());
			pstmt.setString(2, memberDTO.getId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}

		return result;

	}

	// 내정보 수정 - 4. 폰번호
	public int modifyPh(MemberDTO memberDTO) {
		int result = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sb = new StringBuilder();
			sb.append(" UPDATE MEMBER ");
			sb.append(" SET PHONE= ? ");
			sb.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, memberDTO.getPhone());
			pstmt.setString(2, memberDTO.getId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}

		return result;

	}

}
