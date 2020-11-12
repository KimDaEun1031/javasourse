package service;


import java.sql.Connection;

import persistence.UserDAO;

import static persistence.JDBCUtil.*;

public class UserRemoveService {
	public boolean userRemove(int no) {
		//삭제할 사용자의 번호를 dao에 넘겨 삭제한 후 결과 전송받기
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
