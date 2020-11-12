package action;

import java.util.Scanner;

import domain.User_VO;
import service.UserLowService;
import ui.ConsolUtil;

public class UserLowAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//조회할 사용자의 번호를 입력받아 service 객체에게 넘겨주기
		ConsolUtil console = new ConsolUtil();
		int no = console.printUserRow(sc);
		
		UserLowService service = new UserLowService();
		User_VO user = service.getUserRow(no);
		
		//조회 결과를 console에 넘겨 화면 출력\
		console.printUserDetail(user);
	}

}
