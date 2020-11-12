package action;

import java.util.Scanner;

import service.UserRemoveService;
import ui.ConsolUtil;

public class UserRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//������ ������� ��ȣ �Է¹ޱ�
		ConsolUtil console = new ConsolUtil();
		int no = console.printUserRemove(sc);
		//�Է¹��� ��ȣ�� ���� �ѱ��
		UserRemoveService service = new UserRemoveService();
		//dbó������� ���� �޼��� ���
		if(service.userRemove(no)) {
			console.printRemoveSuccessMessage();
		} else {
			console.printRemoveFailSuccessMessage();
		}
	}

}
