package member.action;

import java.io.Console;
import java.util.Scanner;

import member.domain.MemberVO;
import member.service.MemberAddService;
import member.ui.MemberConsoleUtil;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//사용자로부터 입력을 받기 - memberconsoleutil의 getaddmember()		
		MemberConsoleUtil console = new MemberConsoleUtil();
		MemberVO vo = console.getAddMember(sc);
		//입력받은 객체를 service로 넘겨서 db처리를 한 후에 결과를 전송받아 		
		MemberAddService service = new MemberAddService();
		
		//성공한 경우 메세지 출력 - memberconsoleutil의 printaddsuccessmessage()
		if(service.addMember(vo)) {
			console.printAddSuccessMessage(vo.getName());
		}
	}

}
