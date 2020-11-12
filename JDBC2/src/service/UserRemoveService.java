package service;


import java.sql.Connection;

import persistence.UserDAO;

import static persistence.JDBCUtil.*;

public class UserRemoveService {
	public boolean userRemove(int no) {
		//������ ������� ��ȣ�� dao�� �Ѱ� ������ �� ��� ���۹ޱ�
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		
		if(dao.deleteUser(no)) {
			commit(con);
			return true;
		} else {
			rollback(con);
			return false;
		}
	}
}
