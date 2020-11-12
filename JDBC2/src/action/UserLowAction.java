package action;

import java.util.Scanner;

import domain.User_VO;
import service.UserLowService;
import ui.ConsolUtil;

public class UserLowAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//��ȸ�� ������� ��ȣ�� �Է¹޾� service ��ü���� �Ѱ��ֱ�
		ConsolUtil console = new ConsolUtil();
		int no = console.printUserRow(sc);
		
		UserLowService service = new UserLowService();
		User_VO user = service.getUserRow(no);
		
		//��ȸ ����� console�� �Ѱ� ȭ�� ���\
		console.printUserDetail(user);
	}

}
