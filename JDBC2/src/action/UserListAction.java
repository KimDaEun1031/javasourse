package action;

import java.util.List;
import java.util.Scanner;

import domain.User_VO;
import service.UserListService;
import ui.ConsolUtil;

public class UserListAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//UserListService �� getUserList() ȣ���ؼ� ��� ���۹ޱ�
		UserListService service = new UserListService();
		List<User_VO> userList =  service.getUserList();
		
		//���� ����� ConseleUtil �� �Ѱܼ� ����Ʈ ����ϱ�
		ConsolUtil console = new ConsolUtil();
		console.printUserList(userList);
	}

}
