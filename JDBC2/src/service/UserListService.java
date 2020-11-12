package service;

import java.sql.Connection;
import java.util.List;

import domain.User_VO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

public class UserListService {
	//dao.getList()�� �θ��°��� ����  User_VO �갡 ���� �� 
	//����� �޾Ƽ� UserListAction���� �ѱ��
	public List<User_VO> getUserList() {
		
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		
		List<User_VO> list = dao.getList();
		
		close(con);
		
		return list;		
	}	
}
