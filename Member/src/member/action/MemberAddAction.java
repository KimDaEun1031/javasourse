package member.action;

import java.io.Console;
import java.util.Scanner;

import member.domain.MemberVO;
import member.service.MemberAddService;
import member.ui.MemberConsoleUtil;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//����ڷκ��� �Է��� �ޱ� - memberconsoleutil�� getaddmember()		
		MemberConsoleUtil console = new MemberConsoleUtil();
		MemberVO vo = console.getAddMember(sc);
		//�Է¹��� ��ü�� service�� �Ѱܼ� dbó���� �� �Ŀ� ����� ���۹޾� 		
		MemberAddService service = new MemberAddService();
		
		//������ ��� �޼��� ��� - memberconsoleutil�� printaddsuccessmessage()
		if(service.addMember(vo)) {
			console.printAddSuccessMessage(vo.getName());
		}
	}

}
