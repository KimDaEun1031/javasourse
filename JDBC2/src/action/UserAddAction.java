package action;

import java.util.Scanner;

import domain.User_VO;
import service.UserAddService;
import ui.ConsolUtil;

public class UserAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
	
		ConsolUtil console = new ConsolUtil();
		
		//�߰��� ȸ������ ��������
		User_VO user = console.getNewUser(sc);
		
		//ȸ������ Service ��ü�� �ѱ��
		UserAddService service = new UserAddService();
		boolean isAddSuccess = service.addUser(user);
		//addUser(null)�� (user)�� �ٲٽ�
		
		//���� ����� ���� ��� �޽��� ���
		if(isAddSuccess) {
			console.printAddSuccessMessage(user);
		} else {
			console.printAddFailSuccessMessage(user);
		}
	}
	
	

}
