package service;

import domain.User_VO;
import persistence.UserDAO;
import static persistence.JDBCUtil.*;


import java.io.Closeable;
import java.sql.Connection;




public class UserLowService {
	public User_VO getUserRow(int no) {
		//UserDAO�� getRow() ȣ���Ͽ� ��� ���۹ޱ�
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		User_VO vo = dao.getRow(no);
		
		close(con);
		//���۹��� ����� UserRowAction �Ѱ��ֱ�
		return vo;
	}
	


}
