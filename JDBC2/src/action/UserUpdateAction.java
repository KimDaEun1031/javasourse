package action;

import java.util.Scanner;

import domain.User_VO;
import service.UserUpateService;
import ui.ConsolUtil;

public class UserUpdateAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		//������ ���� �Է¹��� �� ���񽺿� �Ѱܼ� ���� ��� �ޱ�
		ConsolUtil console = new ConsolUtil();
		User_VO updateUser =  console.printUpdateMessage(sc);
		
		
		UserUpateService service = new UserUpateService();
		boolean updateSuccess = service.userUpdate(updateUser);
		
		if(updateSuccess) {
			
		} else {
			
		}
	}

}
