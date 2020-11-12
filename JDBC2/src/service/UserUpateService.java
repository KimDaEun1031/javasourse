package service;

import java.sql.Connection;

import domain.User_VO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

public class UserUpateService {
	public boolean userUpdate(User_VO updateUser) {
		boolean isUpdateSuccess = false;
		
		//ȸ�� ���� ���� �����͸� dao�� �Ѱ��ֱ� ��� ���� �ޱ�
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		
		if(dao.updateUser(updateUser.getAddr(), updateUser.getNo())) {
			commit(con);
			isUpdateSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isUpdateSuccess;
	}
}
