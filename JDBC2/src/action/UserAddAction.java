package action;

import java.util.Scanner;

import domain.User_VO;
import service.UserAddService;
import ui.ConsolUtil;

public class UserAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
	
		ConsolUtil console = new ConsolUtil();
		
		//추가할 회원정보 가져오기
		User_VO user = console.getNewUser(sc);
		
		//회원정보 Service 객체에 넘기기
		UserAddService service = new UserAddService();
		boolean isAddSuccess = service.addUser(user);
		//addUser(null)을 (user)로 바꾸심
		
		//실행 결과에 따라 결과 메시지 출력
		if(isAddSuccess) {
			console.printAddSuccessMessage(user);
		} else {
			console.printAddFailSuccessMessage(user);
		}
	}
	
	

}
