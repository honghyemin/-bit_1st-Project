package kr.co.bit.library.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 여기저기서 사용할 close(); 메소드 클래스
public class JDBC_Close {

	public static void closeConnStmtRs(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeConnStmt(Connection conn, PreparedStatement pstmt) {

		
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
