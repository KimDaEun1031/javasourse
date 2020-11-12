package service;

import domain.User_VO;
import persistence.UserDAO;
import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class UserAddService {
	public boolean addUser(User_VO vo) throws Exception {
		boolean isInsertSuccess = false;
		//DAO ÀÛ¾÷
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		
		if(dao.insertUser(vo)) {
			commit(con);
			isInsertSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isInsertSuccess;
	}

}
