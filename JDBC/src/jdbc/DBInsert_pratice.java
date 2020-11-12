package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DBInsert_pratice {
	//자동 커밋
	

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("url을 입력하시오");
			String url = sc.nextLine();
			System.out.println("user 명을 입력하시오");
			String user = sc.next();
			System.out.println("password을 입력하시오");
			String password = sc.next();
			
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				String sql="insert into userTBL values(userTBL_seq.nextval,'김다은',1998,'경기','010-3323-6543')";
				
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
