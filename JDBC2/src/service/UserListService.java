package service;

import java.sql.Connection;
import java.util.List;

import domain.User_VO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

public class UserListService {
	//dao.getList()를 부르는것이 목적  User_VO 얘가 리턴 됨 
	//결과를 받아서 UserListAction에게 넘기기
	public List<User_VO> getUserList() {
		
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		
		List<User_VO> list = dao.getList();
		
		close(con);
		
		return list;		
	}	
}
