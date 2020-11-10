package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBSelect {

	public static void main(String[] args) {
		Connection con=null;
		//sql문 전송를 담고있는 객체
		PreparedStatement pstmt=null;
		//sql 문 결과를 담고 있는 객체
		ResultSet rs= null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password  = "12345";
			
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				String sql = "select * from userTBL";
				
				pstmt = con.prepareStatement(sql);
				//서버로 미리 보내는 작업
				rs = pstmt.executeQuery();
				//전송된 sql문을 실행 후 결과를 담는 작업
				//rs.next() : 하나의 컬럼
 				while(rs.next()) { //SQL테이블 안에 담긴 내용을 출력
					System.out.print(rs.getInt(1)+"\t"); //NUMBER형태
					System.out.print(rs.getString(2)+"\t"); //VARCHAR/CHAR 형태
					System.out.print(rs.getInt(3)+"\t");
					System.out.print(rs.getString(4)+"\t");
					System.out.print(rs.getString(5)+"\n");					
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close(); //제일 처음에 연것은 제일 마지막에 닫히게
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
