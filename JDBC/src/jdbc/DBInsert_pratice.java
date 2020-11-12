package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DBInsert_pratice {
	//�ڵ� Ŀ��
	

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("url�� �Է��Ͻÿ�");
			String url = sc.nextLine();
			System.out.println("user ���� �Է��Ͻÿ�");
			String user = sc.next();
			System.out.println("password�� �Է��Ͻÿ�");
			String password = sc.next();
			
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				String sql="insert into userTBL values(userTBL_seq.nextval,'�����',1998,'���','010-3323-6543')";
				
				pstmt = con.prepareStatement(sql);
				//insert, update, delete ������ executeUpdate()�� ����
				int result = pstmt.executeUpdate();
				
				if(result>0) {
					System.out.println("�Է� ����");
				} else {
					System.out.println("�Է� ����");
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
