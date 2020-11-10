package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			//오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";
			//db와 연결
			con = DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("연결되었습니다.");
			}
		} catch (ClassNotFoundException | SQLException e)  {
			e.printStackTrace();
		} finally {
			try {
				//자원해제
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
