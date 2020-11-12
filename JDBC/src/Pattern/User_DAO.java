package Pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {
	//����̹� �ε� �κ�
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Collection ��ü�� �������ִ� �޼ҵ�
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";
			
			con=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//��ü ���� ���� �޼ҵ�
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
	// ��ȸ �޼ҵ� select
	public List<User_VO> getList() {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		List<User_VO> list = new ArrayList<User_VO>();


		try {
			con = getConnection();	
			//select : ���� ���� ����� ��µǴ� ������(ArrayList) �ƴϸ� 
			//�ϳ��� �ุ ��µǴ� ��������(~~VO) ���� ���� ��ü�� �����ȴ�.
			//vo = value�� ����
			String sql = "select * from userTBL";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				User_VO user = new User_VO();				
				user.setNo(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setBirthYear(rs.getInt("birthyear"));
				user.setAddr(rs.getString("addr"));
				user.setMobile(rs.getString("mobile"));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //���̻� �ڽ�Ŭ������ ������ ����
			close(rs);
			close(pstmt);
			close(con);
		}
		return list;
		
		
		
	}
	// ���� �޼ҵ� delete
	public boolean deleteUser(int no) {
		Connection con = null;
		PreparedStatement pstmt=null;
		Boolean flag = false;

		try {
			con = getConnection();	
			//String sql = "delete from userTBL where no="+no;
			//������ ������ �ո� ���ɼ��� �ֱ⿡ �������� ����
			String sql = "delete from userTBL where no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			
			if(result>0) { //���� ����
				flag=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return flag;
	}
		
	// ���� �޼ҵ� update
	public boolean updateUser(String addr, int no) {
		boolean flag= false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {			
			con = getConnection();
			String sql = "update userTBL set addr=? where no =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setInt(2, no);			
			int result = pstmt.executeUpdate();
			if(result>0) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return flag;
		
	}
	// ���� �޼ҵ� insert
	public boolean insertUser(User_VO uvo ) {
		boolean flag= false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {			
			con = getConnection();
			String sql = "insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, uvo.getUserName());
			pstmt.setInt(2, uvo.getBirthYear());	
			pstmt.setString(3, uvo.getAddr());
			pstmt.setString(4, uvo.getMobile());
			int result = pstmt.executeUpdate();
			if(result>0) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return flag;
	
	}
}
