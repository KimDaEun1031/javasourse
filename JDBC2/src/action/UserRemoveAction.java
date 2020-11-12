package action;

import java.util.Scanner;

import service.UserRemoveService;
import ui.ConsolUtil;

public class UserRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//삭제할 사용자의 번호 입력받기
		ConsolUtil console = new ConsolUtil();
		int no = console.printUserRemove(sc);
		//입력받은 번호를 서비스 넘기기
		UserRemoveService service = new UserRemoveService();
		//db처리결과에 따라 메세지 출력
		if(service.userRemove(no)) {
			console.printRemoveSuccessMessage();
		} else {
			console.printRemoveFailSuccessMessage();
		}
	}

}
