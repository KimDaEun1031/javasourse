package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static persistence.JDBCUtil.*;
//import 구문은 static으로 끌어올릴 때 되는 경우는 클래스 안의 메소드가 다 static일 때
import domain.User_VO;


public class UserDAO {
	Connection con;	
	
	public UserDAO(Connection con) {
		super();
		this.con = con;
	}
	//개별 조회 메소드
		public User_VO getRow(int no) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			User_VO vo = null;
			try {
				String sql = "select * from userTBL where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					vo = new User_VO();
					vo.setNo(rs.getInt("no"));
					vo.setUserName(rs.getString("userName"));
					vo.setBirthYear(rs.getInt("birthYear"));
					vo.setAddr(rs.getString("addr"));
					vo.setMobile(rs.getString("mobile"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return vo;
			
			
		}

	//전체 조회 메소드 select
		public List<User_VO> getList() {
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			List<User_VO> list = new ArrayList<User_VO>();


			try {
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
//			JDBCUtil.close(rs); 으로 해도 되지만 import static persistence.JDBCUtil.*; 
//			임포트 해서 쓰면 굳이 안 고쳐도 됨
				close(rs);
				close(pstmt);
				
			}
			return list;
			
			
			
		}
		
		// 삭제 메소드 delete
		public boolean deleteUser(int no) {
			PreparedStatement pstmt=null;
			Boolean flag = false;

			try {
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
				
			}
			return flag;
		}
			
		// 수정 메소드 update
		public boolean updateUser(String addr, int no) {
			boolean flag= false;
			PreparedStatement pstmt = null;
			
			
			try {			
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
				
			}
			
			return flag;
			
		}
		// 삽입 메소드 insert
		public boolean insertUser(User_VO uvo ) {
			boolean flag= false;
			PreparedStatement pstmt = null;
			
			
			try {			
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
				
			}
			
			return flag;
		
		}
		
}
