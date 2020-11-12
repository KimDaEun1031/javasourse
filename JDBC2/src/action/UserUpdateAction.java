package action;

import java.util.Scanner;

import domain.User_VO;
import service.UserUpateService;
import ui.ConsolUtil;

public class UserUpdateAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		//수정할 정보 입력받은 후 서비스에 넘겨서 수정 결과 받기
		ConsolUtil console = new ConsolUtil();
		User_VO updateUser =  console.printUpdateMessage(sc);
		
		
		UserUpateService service = new UserUpateService();
		boolean updateSuccess = service.userUpdate(updateUser);
		
		if(updateSuccess) {
			
		} else {
			
		}
	}

}
