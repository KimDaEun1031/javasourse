package member.service;

import java.sql.Connection;

import member.domain.MemberVO;
import member.persistence.MemberDAO;

import static member.persistence.MemberUtil.*;

public class MemberAddService {
	public boolean addMember(MemberVO vo) {
		//member를 입력하는 dao를 호출하여 db 작업하기
		//작업 완료 후 결과를 action에 리턴
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
