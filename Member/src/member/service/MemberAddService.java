package member.service;

import java.sql.Connection;

import member.domain.MemberVO;
import member.persistence.MemberDAO;

import static member.persistence.MemberUtil.*;

public class MemberAddService {
	public boolean addMember(MemberVO vo) {
		//member�� �Է��ϴ� dao�� ȣ���Ͽ� db �۾��ϱ�
		//�۾� �Ϸ� �� ����� action�� ����
		boolean isAddSuccess = false;

		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		int addResult = dao.memberInsert(vo);
		
		if(addResult>0) {
			isAddSuccess = true;
			commit(con);
		} else { 
			rollback(con);
		}
		
		close(con);
		
		return isAddSuccess;
	}
}
