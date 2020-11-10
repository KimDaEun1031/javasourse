package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DBInsert {
	//자동 커밋

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";
			
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				String sql="insert into userTBL values(userTBL_seq.nextval,'김승우',1996,'서울','010-3323-6543')";
				
				pstmt = con.prepareStatement(sql);
				//insert, update, delete 구문은 executeUpdate()로 실행
				int result = pstmt.executeUpdate();
				
				if(result>0) {
					System.out.println("입력 성공");
				} else {
					System.out.println("입력 실패");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
