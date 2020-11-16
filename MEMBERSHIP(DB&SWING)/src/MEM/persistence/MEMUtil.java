package MEM.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MEMUtil {
		static {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Collection 객체를 생성해주는 메소드
		public static Connection getConnection() {
			Connection con = null;
			
			try {
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "JAVAKIM";
				String password = "103522";
				
				con=DriverManager.getConnection(url, user, password);
				//auto commit 중지
				con.setAutoCommit(false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		//객체 연결 종료 메소드
		public static void close(Connection con) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void close(PreparedStatement pstmt) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void close(ResultSet rs) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void commit(Connection con) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void rollback(Connection con) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}

