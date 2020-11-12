package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static persistence.JDBCUtil.*;
//import ������ static���� ����ø� �� �Ǵ� ���� Ŭ���� ���� �޼ҵ尡 �� static�� ��
import domain.User_VO;


public class UserDAO {
	Connection con;	
	
	public UserDAO(Connection con) {
		super();
		this.con = con;
	}
	//���� ��ȸ �޼ҵ�
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

	//��ü ��ȸ �޼ҵ� select
		public List<User_VO> getList() {
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			List<User_VO> list = new ArrayList<User_VO>();


			try {
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
//			JDBCUtil.close(rs); ���� �ص� ������ import static persistence.JDBCUtil.*; 
//			����Ʈ �ؼ� ���� ���� �� ���ĵ� ��
				close(rs);
				close(pstmt);
				
			}
			return list;
			
			
			
		}
		
		// ���� �޼ҵ� delete
		public boolean deleteUser(int no) {
			PreparedStatement pstmt=null;
			Boolean flag = false;

			try {
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
				
			}
			return flag;
		}
			
		// ���� �޼ҵ� update
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
		// ���� �޼ҵ� insert
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
