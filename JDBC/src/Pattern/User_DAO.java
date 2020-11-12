package Pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {
	//드라이버 로드 부분
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
			String user = "javaDB";
			String password = "12345";
			
			con=DriverManager.getConnection(url, user, password);
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
	// 조회 메소드 select
	public List<User_VO> getList() {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		List<User_VO> list = new ArrayList<User_VO>();


		try {
			con = getConnection();	
			//select : 여러 행의 결과가 출력되는 것인지(ArrayList) 아니면 
			//하나의 행만 출력되는 것인지에(~~VO) 따라 담을 객체가 결정된다.
			//vo = value의 약자
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
		} finally { //더이상 자식클래스를 만들지 않음
			close(rs);
			close(pstmt);
			close(con);
		}
		return list;
		
		
		
	}
	// 삭제 메소드 delete
	public boolean deleteUser(int no) {
		Connection con = null;
		PreparedStatement pstmt=null;
		Boolean flag = false;

		try {
			con = getConnection();	
			//String sql = "delete from userTBL where no="+no;
			//위에건 보안이 뚫릴 가능성이 있기에 권장하지 않음
			String sql = "delete from userTBL where no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			
			if(result>0) { //삭제 성공
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
		
	// 수정 메소드 update
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
	// 삽입 메소드 insert
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
