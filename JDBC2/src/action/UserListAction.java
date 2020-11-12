package action;

import java.util.List;
import java.util.Scanner;

import domain.User_VO;
import service.UserListService;
import ui.ConsolUtil;

public class UserListAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//UserListService 의 getUserList() 호출해서 결과 전송받기
		UserListService service = new UserListService();
		List<User_VO> userList =  service.getUserList();
		
		//받은 결과를 ConseleUtil 로 넘겨서 리스트 출력하기
		ConsolUtil console = new ConsolUtil();
		console.printUserList(userList);
	}

}
