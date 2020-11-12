package service;

import java.sql.Connection;

import domain.User_VO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

public class UserUpateService {
	public boolean userUpdate(User_VO updateUser) {
		boolean isUpdateSuccess = false;
		
		//회원 정보 수정 데이터를 dao에 넘겨주기 결과 리턴 받기
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
